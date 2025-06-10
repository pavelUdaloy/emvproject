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
public class GetProjectResponse {

    private Integer id;
    private String name;
    private String clientEmail;
    private LocalDateTime createdAt;
    private LocalDateTime approvedAt;
    private LocalDateTime finishedAt;

    private int usersCount;
}
