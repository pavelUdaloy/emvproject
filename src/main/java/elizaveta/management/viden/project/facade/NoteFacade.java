package elizaveta.management.viden.project.facade;

import elizaveta.management.viden.project.entity.Note;
import elizaveta.management.viden.project.http.dto.CreateNoteRequest;
import elizaveta.management.viden.project.http.dto.CreateNoteResponse;
import elizaveta.management.viden.project.http.dto.GetNoteResponse;
import elizaveta.management.viden.project.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class NoteFacade {

    private final NoteService noteService;

    public CreateNoteResponse create(CreateNoteRequest createNoteRequest) {
        Note note = noteService.checkAndCreate(createNoteRequest.getProjectId(), createNoteRequest.getCriteriaId(), createNoteRequest.getUserId(), createNoteRequest.getMessage(), createNoteRequest.getRootNoteId());

        return CreateNoteResponse.builder()
                .id(note.getId())
                .message(note.getMessage())
                .userId(note.getUser().getId())
                .build();
    }

    public List<GetNoteResponse> getAllByProjectIdAndCriteriaId(int projectId, int criteriaId) {
        List<Note> notes = noteService.getAllByProjectIdAndCriteriaId(projectId, criteriaId);
        List<GetNoteResponse> responses = new ArrayList<>();
        for (Note note : notes) {
            responses.add(convertToResponse(note));
        }
        return responses;
    }

    private GetNoteResponse convertToResponse(Note note) {
        return GetNoteResponse.builder()
                .id(note.getId())
                .message(note.getMessage())
                .sendedAt(note.getSendedAt())
                .userEmail(note.getUser().getEmail())
                .notes(note.getChildNotes().stream()
                        .map(this::convertToResponse)
                        .collect(Collectors.toList()))
                .build();
    }
}
