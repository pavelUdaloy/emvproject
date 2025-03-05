package elizaveta.management.viden.project.service;

import elizaveta.management.viden.project.entity.Project;
import elizaveta.management.viden.project.http.dto.EditProjectRequest;
import elizaveta.management.viden.project.rep.ProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Transactional(readOnly = true)
    public Project findById(int id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isEmpty()) {
            log.error("Cannot find project with id = {}", id);
            throw new UsernameNotFoundException("Cannot find project with id = " + id);
        }
        return project.get();
    }

    @Transactional(readOnly = true)
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Transactional
    public void delete(int id) {
        Project project = findById(id);
        projectRepository.delete(project);
    }

    @Transactional
    public Project checkAndCreate(String name) {
        Optional<Project> optionalProject = projectRepository.findByName(name);
        if (optionalProject.isPresent()) {
            log.error("Project with name {} already exists", name);
            throw new RuntimeException("Project with name " + name + " already exists");
        }

        Project project = new Project();
        project.setName(name);

        return projectRepository.save(project);
    }

    @Transactional
    public Project edit(int id, EditProjectRequest editProjectRequest) {
        Project project = findById(id);

        if (editProjectRequest.getName() != null) {
            project.setName(editProjectRequest.getName());
        }

        return projectRepository.save(project);
    }
}
