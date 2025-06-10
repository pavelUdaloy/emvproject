package elizaveta.management.viden.project.service;

import elizaveta.management.viden.project.entity.Log;
import elizaveta.management.viden.project.rep.LogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LogService {

    private final LogRepository logRepository;

    @Transactional
    public void addLog(String description) {
        Log log = new Log();
        log.setActionAt(LocalDateTime.now(ZoneOffset.of("+03:00")));
        log.setType(description);

        logRepository.save(log);
    }

    @Transactional(readOnly = true)
    public List<Log> findAll() {
        return logRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Log> findAll(LocalDateTime startDate, LocalDateTime endDate) {
        return logRepository.findAllBetween(startDate, endDate);
    }
}
