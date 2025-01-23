package elizaveta.management.viden.project.http;

import elizaveta.management.viden.project.facade.AuthFacade;
import elizaveta.management.viden.project.http.dto.LoginRequest;
import elizaveta.management.viden.project.http.dto.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthFacade authFacade;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return authFacade.login(loginRequest.getEmail(), loginRequest.getPassword());
    }
}
