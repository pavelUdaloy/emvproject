package elizaveta.management.viden.project.http;

import elizaveta.management.viden.project.facade.UserFacade;
import elizaveta.management.viden.project.http.dto.CreateUserRequest;
import elizaveta.management.viden.project.http.dto.CreateUserResponse;
import elizaveta.management.viden.project.http.dto.GetUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @PostMapping
    public CreateUserResponse create(@RequestBody CreateUserRequest createUserRequest) {
        return userFacade.create(createUserRequest);
    }

    @GetMapping
    public List<GetUserResponse> getAll() {
        return userFacade.getAll();
    }
}
