package elizaveta.management.viden.project.rep;

import elizaveta.management.viden.project.entity.Log;
import elizaveta.management.viden.project.entity.Note;
import elizaveta.management.viden.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {

    @Query("SELECT l FROM Log l WHERE l.actionAt BETWEEN :startDate AND :endDate")
    List<Log> findAllBetween(LocalDateTime startDate, LocalDateTime endDate);
}