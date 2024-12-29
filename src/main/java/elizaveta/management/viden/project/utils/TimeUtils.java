package elizaveta.management.viden.project.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TimeUtils {

    public static LocalDateTime now() {
        return LocalDateTime.now(ZoneId.of("Europe/Minsk"));
    }

    @SuppressWarnings("SimpleDateFormatWithoutLocale")
    public static String formattedNow() {
        return now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
