package elizaveta.management.viden.project.rep;

import elizaveta.management.viden.project.entity.ProjectCriteria;
import elizaveta.management.viden.project.entity.ProjectCriteria.ProjectCriteriaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectCriteriaRepository extends JpaRepository<ProjectCriteria, ProjectCriteriaId> {

    @Query("SELECT pc FROM ProjectCriteria pc WHERE pc.project.id = :projectId")
    List<ProjectCriteria> findByProjectId(int projectId);

    @Query("SELECT pc FROM ProjectCriteria pc WHERE pc.analyst.id = :analystId")
    List<ProjectCriteria> findByAnalystId(int analystId);
}