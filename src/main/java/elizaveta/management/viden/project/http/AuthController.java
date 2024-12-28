package elizaveta.management.viden.project.http;

import elizaveta.management.viden.project.facade.AuthFacade;
import elizaveta.management.viden.project.http.dto.LoginRequest;
import elizaveta.management.viden.project.http.dto.LoginResponse;
import elizaveta.management.viden.project.http.dto.RefreshResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    public static final String REFRESH_TOKEN_HEADER = "Authorization-Refresh";

    private final AuthFacade authFacade;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return authFacade.login(loginRequest.getLogin(), loginRequest.getPassword());
    }

    @GetMapping("/refresh")
    public RefreshResponse refresh(@RequestHeader(REFRESH_TOKEN_HEADER) String refreshToken) {
        if (refreshToken == null || refreshToken.isEmpty()) {
            throw new RuntimeException("Refresh token on refresh api can not be empty");
        }
        return authFacade.refresh(refreshToken);
    }

    @GetMapping("/logout")
    public void logout(@AuthenticationPrincipal String login) {
        authFacade.logout(login);
    }
}
