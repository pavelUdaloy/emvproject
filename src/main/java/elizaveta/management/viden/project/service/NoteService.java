package elizaveta.management.viden.project.service;

import elizaveta.management.viden.project.entity.Note;
import elizaveta.management.viden.project.entity.Project;
import elizaveta.management.viden.project.entity.User;
import elizaveta.management.viden.project.rep.NoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoteService {

    private final UserService userService;
    private final ProjectService projectService;
    private final NoteRepository noteRepository;

    @Transactional
    public Note checkAndCreate(int projectId, int userId, String message, Integer rootNoteId) {
        User user = userService.findById(userId);
        Project project = projectService.findById(projectId);

        Note note = new Note();
        note.setUser(user);
        note.setProject(project);
        note.setMessage(message);
        note.setSendedAt(LocalDateTime.now(ZoneOffset.of("+03:00")));
        note.setRootNote(findById(rootNoteId));

        try {
            return noteRepository.save(note);
        } catch (Exception e) {
            log.error("Error per saving new note to db, message = {}, userId = {}, projectId = {}", message, userId, project.getId());
            throw new RuntimeException("Error per saving new note to db");
        }
    }

    @Nullable
    @Transactional(readOnly = true)
    public Note findById(Integer id) {
        if (id == null) {
            return null;
        }
        Optional<Note> note = noteRepository.findById(id);
        return note.orElse(null);
    }

    @Nullable
    @Transactional(readOnly = true)
    public List<Note> getAllByProjectId(int projectId) {
        Project project = projectService.findById(projectId);
        return noteRepository.findAllByProjectIsAndRootNoteIsNull(project);
    }
}
