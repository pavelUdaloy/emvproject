package elizaveta.management.viden.project.service;

import elizaveta.management.viden.project.entity.Project;
import elizaveta.management.viden.project.http.dto.EditProjectRequest;
import elizaveta.management.viden.project.rep.ProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final LogService logService;

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
    public Project findByName(String name) {
        Optional<Project> project = projectRepository.findByName(name);
        if (project.isEmpty()) {
            log.error("Cannot find project with name = {}", name);
            throw new UsernameNotFoundException("Cannot find project with name = " + name);
        }
        return project.get();
    }

    @Transactional(readOnly = true)
    public List<Project> findAllApproved() {
        return projectRepository.findAllApproved();
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
        logService.addLog("Проект " + name + " был создан");

        Optional<Project> optionalProject = projectRepository.findByName(name);
        if (optionalProject.isPresent()) {
            log.error("Project with name {} already exists", name);
            throw new RuntimeException("Project with name " + name + " already exists");
        }

        Project project = new Project();
        project.setName(name);
        project.setApproved(false);
        project.setCreatedAt(LocalDateTime.now(ZoneOffset.of("+03:00")));

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

    @Transactional(readOnly = true)
    public List<Project> findAllNotApproved() {
        return projectRepository.findAllNotApproved();
    }

    @Transactional
    public void approve(int projectId) {
        Project project = findById(projectId);
        project.setApproved(true);
        project.setApprovedAt(LocalDateTime.now(ZoneOffset.of("+03:00")));

        projectRepository.save(project);

        logService.addLog("Проект " + project.getName() + " был подтвержден менеджером");
    }
}
