package elizaveta.management.viden.project.facade;

import elizaveta.management.viden.project.entity.User;
import elizaveta.management.viden.project.http.dto.LoginResponse;
import elizaveta.management.viden.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthFacade {

    private final UserService userService;

    public LoginResponse login(String login, String password) {
        User user = userService.checkAccount(login, password);

        return LoginResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .projectName(user.getProject().getName())
                .projectId(user.getProject().getId())
                .roleId(user.getRole().getId())
                .roleName(user.getRole().getName())
                .projectApproved(user.getProject().isApproved())
                .build();
    }
}
