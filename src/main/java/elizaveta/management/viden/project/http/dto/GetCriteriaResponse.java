package elizaveta.management.viden.project.http.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class GetCriteriaResponse {

    private int projectId;
    private String projectName;
    private int criteriaId;
    private String criteriaName;
    private String userEmail;
    private String description;
    private String status;
    private String offer;
    private LocalDateTime deadline;
}
