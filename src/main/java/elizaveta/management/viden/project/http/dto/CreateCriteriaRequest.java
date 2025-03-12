package elizaveta.management.viden.project.http.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CreateCriteriaRequest {

    private int criteriaId;
    private int userId;
    private String status;
    private String description;
    private LocalDateTime deadline;
}
