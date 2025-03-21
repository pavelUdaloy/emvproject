package elizaveta.management.viden.project.rep;

import elizaveta.management.viden.project.entity.Criteria;
import elizaveta.management.viden.project.entity.Note;
import elizaveta.management.viden.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriteriaRepository extends JpaRepository<Criteria, Integer> {
}