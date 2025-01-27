package elizaveta.management.viden.project.http.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class GetNoteResponse {

    private int id;
    private String message;
    private LocalDateTime sendedAt;
    private String userEmail;
    private List<GetNoteResponse> notes = new ArrayList<>();
}
