package elizaveta.management.viden.project.http;

import elizaveta.management.viden.project.facade.UserFacade;
import elizaveta.management.viden.project.http.dto.GetUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @GetMapping
    public List<GetUserResponse> getAll() {
        return userFacade.getAll();
    }

    @GetMapping("/analysts")
    public List<GetUserResponse> getAllAnalysts() {
        return userFacade.getAllAnalysts();
    }

    @GetMapping("/{projectId}")
    public List<GetUserResponse> getByProjectId(@PathVariable("projectId") int projectId) {
        return userFacade.getByProjectId(projectId);
    }
}
