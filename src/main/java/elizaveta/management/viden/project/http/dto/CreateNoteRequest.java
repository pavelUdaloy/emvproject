package elizaveta.management.viden.project.http.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateNoteRequest {

    private String message;
    private int projectId;
    private int userId;
    private Integer rootNoteId;
}
