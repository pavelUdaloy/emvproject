package elizaveta.management.viden.project.http;

import elizaveta.management.viden.project.facade.ProjectFacade;
import elizaveta.management.viden.project.http.dto.EditProjectRequest;
import elizaveta.management.viden.project.http.dto.EditProjectResponse;
import elizaveta.management.viden.project.http.dto.GetProjectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectFacade projectFacade;

    @GetMapping
    public List<GetProjectResponse> findAllApproved() {
        return projectFacade.findAllApproved();
    }

    @GetMapping("/all/all")
    public List<GetProjectResponse> findAll() {
        return projectFacade.findAll();
    }

    @GetMapping("/{id}")
    public GetProjectResponse getById(@PathVariable("id") int id) {
        return projectFacade.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        projectFacade.delete(id);
    }

    @PutMapping("/{id}")
    public EditProjectResponse edit(@PathVariable("id") int id, @RequestBody EditProjectRequest editProjectRequest) {
        return projectFacade.edit(id, editProjectRequest);
    }
}
