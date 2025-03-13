package elizaveta.management.viden.project.http;

import elizaveta.management.viden.project.facade.CriteriaFacade;
import elizaveta.management.viden.project.facade.ProjectFacade;
import elizaveta.management.viden.project.http.dto.CreateCriteriaRequest;
import elizaveta.management.viden.project.http.dto.CreateOrderRequest;
import elizaveta.management.viden.project.http.dto.EditProjectRequest;
import elizaveta.management.viden.project.http.dto.EditProjectResponse;
import elizaveta.management.viden.project.http.dto.GetCriteriaResponse;
import elizaveta.management.viden.project.http.dto.GetProjectResponse;
import elizaveta.management.viden.project.http.dto.GetSystemCriteriaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projects/{projectId}/criteries")
@RequiredArgsConstructor
public class CriteriaController {

    private final CriteriaFacade criteriaFacade;

    @GetMapping
    public List<GetCriteriaResponse> getAllByProjectId(@PathVariable("projectId") int projectId) {
        return criteriaFacade.getAllByProjectId(projectId);
    }

    @GetMapping("/by-analyst/{analystId}")
    public List<GetCriteriaResponse> getAllByAnalystId(@PathVariable("projectId") int projectId,
                                                       @PathVariable("analystId") int analystId) {
        return criteriaFacade.getAllByAnalystId(analystId);
    }

    @PostMapping
    public void addCriteria(@PathVariable("projectId") int projectId, @RequestBody CreateCriteriaRequest createCriteriaRequest) {
        criteriaFacade.addCriteria(projectId, createCriteriaRequest);
    }

    @GetMapping("/system")
    public List<GetSystemCriteriaResponse> getAllSystemCriteries(@PathVariable String projectId) {
        return criteriaFacade.getAllSystemCriteries();
    }
}
