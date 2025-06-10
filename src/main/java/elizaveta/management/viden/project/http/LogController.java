package elizaveta.management.viden.project.http;

import elizaveta.management.viden.project.facade.LogFacade;
import elizaveta.management.viden.project.http.dto.GetLogResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogController {

    private final LogFacade logFacade;

    @GetMapping
    public List<GetLogResponse> getAll(@RequestHeader(value = "startDate", required = false) String startDate,
                                       @RequestHeader(value = "endDate", required = false) String endDate) {

        LocalDateTime start = startDate != null ? LocalDateTime.parse(startDate) : null;
        LocalDateTime end = endDate != null ? LocalDateTime.parse(endDate) : null;

        return logFacade.getAll(start, end);
    }
}
