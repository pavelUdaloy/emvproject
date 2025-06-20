package elizaveta.management.viden.project.rep;

import elizaveta.management.viden.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query("SELECT p FROM Project p WHERE p.name = :name")
    Optional<Project> findByName(String name);

    @Query("SELECT p FROM Project p WHERE p.approved = false")
    List<Project> findAllNotApproved();

    @Query("SELECT p FROM Project p WHERE p.approved = true AND p.finishedAt IS NULL")
    List<Project> findAllApprovedNotFinished();
}