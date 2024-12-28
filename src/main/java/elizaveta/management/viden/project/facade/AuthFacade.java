package elizaveta.management.viden.project.facade;

import elizaveta.management.viden.project.entity.User;
import elizaveta.management.viden.project.http.dto.LoginResponse;
import elizaveta.management.viden.project.http.dto.RefreshResponse;
import elizaveta.management.viden.project.service.TokenService;
import elizaveta.management.viden.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthFacade {

    private final TokenService tokenService;
    private final UserService userService;

    public void logout(String email) {
        User user = userService.findByEmail(email);

        tokenService.deletePairByUser(user);
    }

    public LoginResponse login(String login, String password) {
        User user = userService.checkAccount(login, password);
        Pair<String, String> tokens = tokenService.createNewPair(user);

        return LoginResponse.builder()
                .accessToken(tokens.getFirst())
                .refreshToken(tokens.getSecond())
                .build();
    }

    public RefreshResponse refresh(String refreshToken) {
        Pair<String, String> tokens = tokenService.refresh(refreshToken);

        return RefreshResponse.builder()
                .accessToken(tokens.getFirst())
                .refreshToken(tokens.getSecond())
                .build();
    }
}
