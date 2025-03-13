package elizaveta.management.viden.project.rep;

import elizaveta.management.viden.project.entity.Note;
import elizaveta.management.viden.project.entity.Project;
import elizaveta.management.viden.project.entity.ProjectCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

    List<Note> findAllByProjectCriteriaAndRootNoteIsNull(ProjectCriteria projectCriteria);
}