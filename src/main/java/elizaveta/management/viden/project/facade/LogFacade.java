package elizaveta.management.viden.project.facade;

import elizaveta.management.viden.project.entity.Log;
import elizaveta.management.viden.project.http.dto.GetLogResponse;
import elizaveta.management.viden.project.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LogFacade {

    private final LogService logService;

    public List<GetLogResponse> getAll(LocalDateTime startDate, LocalDateTime endDate) {
        List<Log> logs;
        if (startDate == null || endDate == null) {
            logs = logService.findAll();
        } else {
            logs = logService.findAll(startDate, endDate);
        }

        return logs.stream()
                .map(log -> GetLogResponse.builder()
                        .id(log.getId())
                        .description(log.getType())
                        .actionAt(log.getActionAt())
                        .build())
                .collect(Collectors.toList());
    }
}
