package elizaveta.management.viden.project.facade;

import elizaveta.management.viden.project.entity.Criteria;
import elizaveta.management.viden.project.entity.Project;
import elizaveta.management.viden.project.entity.ProjectCriteria;
import elizaveta.management.viden.project.entity.User;
import elizaveta.management.viden.project.http.dto.CreateCriteriaRequest;
import elizaveta.management.viden.project.http.dto.GetCriteriaResponse;
import elizaveta.management.viden.project.http.dto.GetSystemCriteriaResponse;
import elizaveta.management.viden.project.http.dto.UpdateCriteriaRequest;
import elizaveta.management.viden.project.service.CriteriaService;
import elizaveta.management.viden.project.service.ProjectService;
import elizaveta.management.viden.project.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class CriteriaFacade {

    private final CriteriaService criteriaService;
    private final ProjectService projectService;
    private final UserService userService;

    public List<GetSystemCriteriaResponse> getAllSystemCriteries() {
        List<Criteria> systemCriteries = criteriaService.getAllSystemCriteries();
        return systemCriteries.stream()
                .map(criteria -> GetSystemCriteriaResponse.builder()
                        .id(criteria.getId())
                        .name(criteria.getName())
                        .build())
                .collect(Collectors.toList());
    }

    public void addCriteria(int projectId, CreateCriteriaRequest request) {
        Project project = projectService.findById(projectId);
        User user = userService.findById(request.getUserId());
        Criteria criteria = criteriaService.findById(request.getCriteriaId());
        criteriaService.addProjectCriteria(project, criteria, user, request.getStatus(), request.getDescription(), request.getDeadline());
    }

    public List<GetCriteriaResponse> getAllByProjectId(int projectId) {
        List<ProjectCriteria> projectCriteries = criteriaService.getAllByProjectId(projectId);
        return projectCriteries.stream()
                .map(criteria -> GetCriteriaResponse.builder()
                        .projectId(criteria.getProject().getId())
                        .criteriaId(criteria.getCriteria().getId())
                        .criteriaName(criteria.getCriteria().getName())
                        .userEmail(criteria.getAnalyst().getLastName() + " " + criteria.getAnalyst().getFirstName())
                        .description(criteria.getDescription())
                        .status(criteria.getStatus())
                        .deadline(criteria.getDeadline())
                        .build())
                .collect(Collectors.toList());
    }

    public List<GetCriteriaResponse> getAllByAnalystId(int analystId) {
        List<ProjectCriteria> projectCriteries = criteriaService.getAllByAnalystId(analystId);
        return projectCriteries.stream()
                .map(criteria -> GetCriteriaResponse.builder()
                        .projectId(criteria.getProject().getId())
                        .projectName(criteria.getProject().getName())
                        .criteriaId(criteria.getCriteria().getId())
                        .criteriaName(criteria.getCriteria().getName())
                        .userEmail(criteria.getAnalyst().getEmail())
                        .description(criteria.getDescription())
                        .status(criteria.getStatus())
                        .deadline(criteria.getDeadline())
                        .build())
                .collect(Collectors.toList());
    }

    public void updateCriteria(int projectId, int criteriaId, UpdateCriteriaRequest request) {
        criteriaService.updateCriteria(projectId, criteriaId, request.getStatus());
    }
}
