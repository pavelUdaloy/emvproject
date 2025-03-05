package elizaveta.management.viden.project.facade;

import elizaveta.management.viden.project.entity.Project;
import elizaveta.management.viden.project.http.dto.CreateProjectRequest;
import elizaveta.management.viden.project.http.dto.CreateProjectResponse;
import elizaveta.management.viden.project.http.dto.EditProjectRequest;
import elizaveta.management.viden.project.http.dto.EditProjectResponse;
import elizaveta.management.viden.project.http.dto.GetProjectResponse;
import elizaveta.management.viden.project.http.dto.GetProjectShortedResponse;
import elizaveta.management.viden.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProjectFacade {

    private final ProjectService projectService;

    public CreateProjectResponse create(CreateProjectRequest createProjectRequest) {
        Project project = projectService.checkAndCreate(createProjectRequest.getName());

        return CreateProjectResponse.builder()
                .id(project.getId())
                .name(project.getName())
                .build();
    }

    public List<GetProjectShortedResponse> getAll() {
        return projectService.findAll().stream()
                .map(project -> GetProjectShortedResponse.builder()
                        .id(project.getId())
                        .name(project.getName())
                        .build())
                .collect(Collectors.toList());
    }

    public void delete(int id) {
        projectService.delete(id);
    }

    public EditProjectResponse edit(int id, EditProjectRequest editProjectRequest) {
        Project project = projectService.edit(id, editProjectRequest);
        return EditProjectResponse.builder()
                .id(project.getId())
                .name(project.getName())
                .usersCount(project.getUsers().size())
                .build();
    }

    public GetProjectResponse getById(int id) {
        Project project = projectService.findById(id);
        return GetProjectResponse.builder()
                .id(project.getId())
                .name(project.getName())
                .usersCount(project.getUsers().size())
                .build();
    }
}
