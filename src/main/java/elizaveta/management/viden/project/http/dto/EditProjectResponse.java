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
public class EditProjectResponse {

    private Integer id;
    private String name;

    private int usersCount;
}
