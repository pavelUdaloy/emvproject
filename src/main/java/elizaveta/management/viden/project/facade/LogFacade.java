package elizaveta.management.viden.project.facade;

import elizaveta.management.viden.project.entity.Log;
import elizaveta.management.viden.project.entity.User;
import elizaveta.management.viden.project.http.dto.GetLogResponse;
import elizaveta.management.viden.project.http.dto.LoginResponse;
import elizaveta.management.viden.project.service.LogService;
import elizaveta.management.viden.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LogFacade {

    private final LogService logService;

    public List<GetLogResponse> getAll() {
        List<Log> logs = logService.findAll();
        return logs.stream()
                .map(log -> GetLogResponse.builder()
                        .id(log.getId())
                        .description(log.getType())
                        .actionAt(log.getActionAt())
                        .build())
                .collect(Collectors.toList());
    }
}
