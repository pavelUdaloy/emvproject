package elizaveta.management.viden.project.facade;

import elizaveta.management.viden.project.entity.Project;
import elizaveta.management.viden.project.entity.Role;
import elizaveta.management.viden.project.http.dto.CreateAnalystRequest;
import elizaveta.management.viden.project.http.dto.GetUserResponse;
import elizaveta.management.viden.project.service.ProjectService;
import elizaveta.management.viden.project.service.RoleService;
import elizaveta.management.viden.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;
    private final ProjectService projectService;
    private final RoleService roleService;

    public List<GetUserResponse> getAll() {
        return userService.findAll().stream()
                .map(u -> GetUserResponse.builder()
                        .id(u.getId())
                        .email(u.getEmail())
                        .firstName(u.getFirstName())
                        .lastName(u.getLastName())
                        .projectName(u.getProject().getName())
                        .roleName(u.getRole().getName())
                        .build())
                .collect(Collectors.toList());
    }

    public List<GetUserResponse> getByProjectId(int projectId) {
        return userService.findAll().stream()
                .filter(user -> user.getProject().getId() == projectId)
                .map(u -> GetUserResponse.builder()
                        .id(u.getId())
                        .email(u.getEmail())
                        .firstName(u.getFirstName())
                        .lastName(u.getLastName())
                        .projectName(u.getProject().getName())
                        .roleName(u.getRole().getName())
                        .build())
                .collect(Collectors.toList());
    }

    public List<GetUserResponse> getAllAnalysts() {
        return userService.findAll().stream()
                .filter(user -> Objects.equals(user.getRole().getName(), "VIDEN_ANALYST"))
                .map(u -> GetUserResponse.builder()
                        .id(u.getId())
                        .email(u.getEmail())
                        .firstName(u.getFirstName())
                        .lastName(u.getLastName())
                        .projectName(u.getProject().getName())
                        .roleName(u.getRole().getName())
                        .build())
                .collect(Collectors.toList());
    }

    public void create(CreateAnalystRequest createUserRequest) {
        Project project = projectService.findByName("VIDEN");
        Role role = roleService.findByName("VIDEN_ANALYST");

        userService.checkAndCreate(project, role, createUserRequest.getEmail(), createUserRequest.getPassword(),
                createUserRequest.getFirstName(), createUserRequest.getLastName());
    }
}
