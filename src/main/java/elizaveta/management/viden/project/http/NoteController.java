package elizaveta.management.viden.project.http;

import elizaveta.management.viden.project.facade.NoteFacade;
import elizaveta.management.viden.project.http.dto.CreateNoteRequest;
import elizaveta.management.viden.project.http.dto.CreateNoteResponse;
import elizaveta.management.viden.project.http.dto.GetNoteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteFacade noteFacade;

    @PostMapping
    public CreateNoteResponse create(@RequestBody CreateNoteRequest createNoteRequest) {
        return noteFacade.create(createNoteRequest);
    }

    @GetMapping("/{projectId}/{criteriaId}")
    public List<GetNoteResponse> getAllByProjectIdAndCriteriaId(@PathVariable("projectId") int projectId, @PathVariable("criteriaId") int criteriaId) {
        return noteFacade.getAllByProjectIdAndCriteriaId(projectId, criteriaId);
    }
}
