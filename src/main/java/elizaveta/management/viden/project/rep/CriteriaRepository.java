package elizaveta.management.viden.project.rep;

import elizaveta.management.viden.project.entity.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriteriaRepository extends JpaRepository<Criteria, Integer> {
}