package elizaveta.management.viden.project.service;

import elizaveta.management.viden.project.config.prop.JwtProperties;
import elizaveta.management.viden.project.config.prop.TokenTtlProperties;
import elizaveta.management.viden.project.entity.AccessToken;
import elizaveta.management.viden.project.entity.RefreshToken;
import elizaveta.management.viden.project.entity.User;
import elizaveta.management.viden.project.rep.AccessTokenRepository;
import elizaveta.management.viden.project.rep.RefreshTokenRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final JwtProperties jwtProperties;
    private final TokenTtlProperties tokenTtlProperties;
    private final AccessTokenRepository accessTokenRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public Pair<String, String> refresh(String refreshToken) {
        Optional<RefreshToken> optionalRefreshToken = refreshTokenRepository.findByTokenAndTime(refreshToken, LocalDateTime.now(ZoneId.of("Europe/Minsk")));

        if (optionalRefreshToken.isEmpty()) {
            throw new RuntimeException("Refresh token expired or does not exists");
        }

        User user = optionalRefreshToken.get().getAccessToken().getUser();
        deletePairByUser(user);
        return createNewPair(user);
    }

    @Transactional
    public Pair<String, String> createNewPair(User user) {
        deletePairByUser(user);
        AccessToken accessToken = createAccessToken(user);
        RefreshToken refreshToken = createRefreshToken(accessToken);
        return Pair.of(accessToken.getToken(), refreshToken.getToken());
    }

    @Transactional
    public void deletePairByUser(User user) {
        refreshTokenRepository.removeByUserId(user.getId());
        accessTokenRepository.removeByUserId(user.getId());
    }

    private AccessToken createAccessToken(User user) {
        LocalDateTime startedAt = LocalDateTime.now(ZoneId.of("Europe/Minsk"));
        LocalDateTime issuedAt = startedAt.plusSeconds(tokenTtlProperties.getAccess());
        String token = createToken(user.getEmail(), issuedAt);

        AccessToken accessToken = new AccessToken();
        accessToken.setToken(token);
        accessToken.setCreatedAt(startedAt);
        accessToken.setExpiredAt(issuedAt);
        accessToken.setUser(user);
        return accessTokenRepository.save(accessToken);
    }

    private RefreshToken createRefreshToken(AccessToken accessToken) {
        LocalDateTime startedAt = LocalDateTime.now(ZoneId.of("Europe/Minsk"));
        LocalDateTime issuedAt = startedAt.plusSeconds(tokenTtlProperties.getRefresh());
        String token = createToken("refreshToken", issuedAt);

        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(token);
        refreshToken.setCreatedAt(startedAt);
        refreshToken.setExpiredAt(issuedAt);
        refreshToken.setAccessToken(accessToken);
        return refreshTokenRepository.save(refreshToken);
    }

    private String createToken(String subject, LocalDateTime issuedAt) {
        String token = Jwts.builder()
                .signWith(Keys.hmacShaKeyFor(jwtProperties.getKey().getBytes(StandardCharsets.UTF_8)))
                .setIssuer(jwtProperties.getTokenIssuer())
                .setSubject(subject)
                .setIssuedAt(Date.from(issuedAt.atZone(ZoneId.of("Europe/Minsk")).toInstant()))
                .claim("account_type", "emvproject_user")
                .compact();

        return jwtProperties.getTokenPrefix() + token;
    }
}
