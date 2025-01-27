package elizaveta.management.viden.project.facade;

import elizaveta.management.viden.project.entity.Project;
import elizaveta.management.viden.project.entity.User;
import elizaveta.management.viden.project.http.dto.CreateUserRequest;
import elizaveta.management.viden.project.http.dto.CreateUserResponse;
import elizaveta.management.viden.project.http.dto.GetUserResponse;
import elizaveta.management.viden.project.service.ProjectService;
import elizaveta.management.viden.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;
    private final ProjectService projectService;

    public CreateUserResponse create(CreateUserRequest createUserRequest) {
        Project project = projectService.findById(createUserRequest.getProjectId());

        User user = userService.checkAndCreate(project, createUserRequest.getEmail(), createUserRequest.getPassword(),
                createUserRequest.getTitle(), createUserRequest.getFirstName(), createUserRequest.getLastName());

        return CreateUserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .title(user.getTitle())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

    public List<GetUserResponse> getAll() {
        return userService.findAll().stream()
                .map(u -> GetUserResponse.builder()
                        .id(u.getId())
                        .email(u.getEmail())
                        .title(u.getTitle())
                        .firstName(u.getFirstName())
                        .lastName(u.getLastName())
                        .projectName(u.getProject().getName())
                        .build())
                .collect(Collectors.toList());
    }

    public void delete(int id) {
        userService.delete(id);
    }

    public List<GetUserResponse> getByProjectId(int projectId) {
        return userService.findAll().stream()
                .filter(user -> user.getProject().getId() == projectId)
                .map(u -> GetUserResponse.builder()
                        .id(u.getId())
                        .email(u.getEmail())
                        .title(u.getTitle())
                        .firstName(u.getFirstName())
                        .lastName(u.getLastName())
                        .projectName(u.getProject().getName())
                        .build())
                .collect(Collectors.toList());
    }
}
