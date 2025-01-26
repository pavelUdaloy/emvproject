package elizaveta.management.viden.project.http.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class LoginResponse {

    private Integer id;
    private String email;
    private String password;
    private String title;
    private String firstName;
    private String lastName;
    private String projectName;
    private int projectId;
}
