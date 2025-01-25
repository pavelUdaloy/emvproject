package elizaveta.management.viden.project.http.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class CreateNoteResponse {

    private int id;
    private String message;
    private int userId;
}
