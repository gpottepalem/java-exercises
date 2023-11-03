import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

class Scratch {
    public static void main(String[] args) {
        var dateTimeStr = "2023-10-16T09:16:37-0400";
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
        System.out.println(
            ZonedDateTime.parse(dateTimeStr, formatter)
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM))
        );
        System.out.println(
            LocalDateTime.parse(dateTimeStr, formatter)
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM))
        );
    }
}