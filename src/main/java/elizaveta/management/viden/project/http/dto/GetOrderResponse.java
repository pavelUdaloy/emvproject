package elizaveta.management.viden.project.http.dto;

import jakarta.persistence.Column;
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
public class GetOrderResponse {

    private Integer id;
    private String name;
    private String ownerEmail;
    private String ownerFirstName;
    private String ownerLastName;
    private LocalDateTime createdAt;
    private LocalDateTime approvedAt;
    private LocalDateTime finishedAt;
}
