package elizaveta.management.viden.project.config.security;

import elizaveta.management.viden.project.config.prop.JwtProperties;
import elizaveta.management.viden.project.entity.AccessToken;
import elizaveta.management.viden.project.rep.AccessTokenRepository;
import elizaveta.management.viden.project.utils.TimeUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@SuppressWarnings("NullableProblems")
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final AccountDetailsService accountDetailsService;
    private final AccessTokenRepository accessTokenRepository;
    private final JwtProperties jwtProperties;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(AUTHORIZATION);

        if (token != null) {
            String login = parseAccessToken(token);
            Optional<AccessToken> accessToken = accessTokenRepository.findByLoginAndToken(login, token, TimeUtils.now().minusHours(3));

            if (accessToken.isEmpty()) {
                log.error("Access token for that user (login = {}) was expired", login);
            } else {
                AccountDetails accountDetails = accountDetailsService.loadUserByUsername(login);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(accountDetails.getUsername(), null, accountDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }

    public String parseAccessToken(String accessToken) {
        if (!accessToken.startsWith(this.jwtProperties.getTokenPrefix())) {
            throw new RuntimeException("Cannot parse request token " + accessToken);
        }
        byte[] signingKey = this.jwtProperties.getKey().getBytes(StandardCharsets.UTF_8);
        Jws<Claims> parsedToken = Jwts.parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(accessToken.replace(this.jwtProperties.getTokenPrefix(), ""));
        return parsedToken.getBody().getSubject();
    }
}
