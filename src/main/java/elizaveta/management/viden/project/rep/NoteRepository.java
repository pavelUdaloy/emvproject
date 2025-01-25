package elizaveta.management.viden.project.rep;

import elizaveta.management.viden.project.entity.Note;
import elizaveta.management.viden.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

    List<Note> findAllByProjectIsAndRootNoteIsNull(Project project);
}