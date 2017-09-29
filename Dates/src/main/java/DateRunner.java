import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateRunner {
    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());

        LocalDate localDate = LocalDate.of(2020, Month.JANUARY, 21);
        LocalTime localTime = LocalTime.of(11, 12, 14);
        LocalDateTime dateTime = LocalDateTime.of(localDate, localTime);

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(dateTime);

        System.out.println(localDate.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(localTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(shortDateTime.format(dateTime));
        System.out.println(shortDateTime.format(localDate));

        DateTimeFormatter shortDateTime1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(shortDateTime1.format(dateTime)); // 1/20/20
        System.out.println(shortDateTime1.format(localDate)); // 1/20/20
        System.out.println(shortDateTime1.format(localTime)); // UnsupportedTemporalTypeException
    }
}
