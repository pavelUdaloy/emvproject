package elizaveta.management.viden.project.service;

import elizaveta.management.viden.project.entity.Criteria;
import elizaveta.management.viden.project.entity.Project;
import elizaveta.management.viden.project.entity.ProjectCriteria;
import elizaveta.management.viden.project.entity.ProjectCriteria.ProjectCriteriaId;
import elizaveta.management.viden.project.entity.User;
import elizaveta.management.viden.project.rep.CriteriaRepository;
import elizaveta.management.viden.project.rep.ProjectCriteriaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CriteriaService {

    private final CriteriaRepository criteriaRepository;
    private final ProjectCriteriaRepository projectCriteriaRepository;
    private final LogService logService;

    @Transactional
    public List<Criteria> getAllSystemCriteries() {
        return criteriaRepository.findAll();
    }

    @Transactional
    public void addProjectCriteria(Project project, Criteria criteria, User user, String status, String description, LocalDateTime deadline) {
        logService.addLog("Критерий " + criteria.getName() + " был добавлен в проект " + project.getName());

        ProjectCriteria projectCriteria = new ProjectCriteria();
        projectCriteria.setCriteria(criteria);
        projectCriteria.setProject(project);
        projectCriteria.setAnalyst(user);
        projectCriteria.setStatus(status);
        projectCriteria.setDescription(description);
        projectCriteria.setDeadline(deadline);
        projectCriteria.setId(new ProjectCriteriaId(project.getId(), criteria.getId()));

        projectCriteriaRepository.save(projectCriteria);
    }

    @Transactional(readOnly = true)
    public Criteria findById(int id) {
        Optional<Criteria> criteria = criteriaRepository.findById(id);
        if (criteria.isEmpty()) {
            log.error("Cannot find system criteria with id = {}", id);
            throw new UsernameNotFoundException("Cannot find system criteria with id = " + id);
        }
        return criteria.get();
    }

    @Transactional(readOnly = true)
    public List<ProjectCriteria> getAllByProjectId(int projectId) {
        return projectCriteriaRepository.findByProjectId(projectId);
    }

    @Transactional(readOnly = true)
    public List<ProjectCriteria> getAllByAnalystId(int analystId) {
        return projectCriteriaRepository.findByAnalystId(analystId);
    }

    @Transactional
    public void updateCriteria(int projectId, int criteriaId, String status, String offer) {
        ProjectCriteriaId id = new ProjectCriteriaId(projectId, criteriaId);
        ProjectCriteria projectCriteria = projectCriteriaRepository.findById(id).get();
        projectCriteria.setStatus(status);
        projectCriteria.setOffer(offer);
        projectCriteriaRepository.save(projectCriteria);
    }

    @Transactional(readOnly = true)
    public ProjectCriteria findById(int projectId, int criteriaId) {
        ProjectCriteriaId id = new ProjectCriteriaId(projectId, criteriaId);
        Optional<ProjectCriteria> projectCriteria = projectCriteriaRepository.findById(id);
        if (projectCriteria.isEmpty()) {
            log.error("Cannot find projectCriteria with id = {}", id);
            throw new UsernameNotFoundException("Cannot find projectCriteria with id = " + id);
        }
        return projectCriteria.get();
    }
}
