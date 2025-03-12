package elizaveta.management.viden.project.http.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateAnalystRequest {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
