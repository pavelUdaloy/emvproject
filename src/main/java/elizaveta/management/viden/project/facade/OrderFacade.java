package elizaveta.management.viden.project.facade;

import elizaveta.management.viden.project.entity.Project;
import elizaveta.management.viden.project.entity.Role;
import elizaveta.management.viden.project.http.dto.CreateOrderRequest;
import elizaveta.management.viden.project.http.dto.GetOrderResponse;
import elizaveta.management.viden.project.service.ProjectService;
import elizaveta.management.viden.project.service.RoleService;
import elizaveta.management.viden.project.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderFacade {

    private final ProjectService projectService;
    private final UserService userService;
    private final RoleService roleService;

    public void create(CreateOrderRequest createProjectRequest) {
        Project project = projectService.checkAndCreate(createProjectRequest.getProjectName());
        Role role = roleService.findByName("CLIENT");
        userService.checkAndCreate(project, role, createProjectRequest.getEmail(),
                createProjectRequest.getPassword(), createProjectRequest.getFirstName(),
                createProjectRequest.getLastName());
    }

    public List<GetOrderResponse> getAll() {
        List<Project> projects = projectService.findAllNotApproved();
        return projects.stream()
                .map(project -> GetOrderResponse.builder()
                        .id(project.getId())
                        .name(project.getName())
                        .build())
                .collect(Collectors.toList());
    }

    public void approve(int projectId) {
        projectService.approve(projectId);
    }
}
