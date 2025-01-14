package elizaveta.management.viden.project.http;

import elizaveta.management.viden.project.facade.ProjectFacade;
import elizaveta.management.viden.project.http.dto.CreateProjectRequest;
import elizaveta.management.viden.project.http.dto.CreateProjectResponse;
import elizaveta.management.viden.project.http.dto.GetProjectResponse;
import elizaveta.management.viden.project.http.dto.GetProjectShortedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectFacade projectFacade;

    @PostMapping
    public CreateProjectResponse create(@RequestBody CreateProjectRequest createProjectRequest) {
        return projectFacade.create(createProjectRequest);
    }

    @GetMapping
    public List<GetProjectShortedResponse> getAll() {
        return projectFacade.getAll();
    }

    @GetMapping("/{id}")
    public GetProjectResponse getById(@PathVariable("id") int id) {
        return projectFacade.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        projectFacade.delete(id);
    }
}
