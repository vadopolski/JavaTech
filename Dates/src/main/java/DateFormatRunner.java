import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import javax.jws.soap.SOAPBinding;

public class DateFormatRunner {
    public static void main(String[] args) throws ParseException {
        LocalDate date = LocalDate.of(2017, Month.SEPTEMBER, 29);
        LocalTime time = LocalTime.of(12, 18);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        DateTimeFormatter shortF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter mediumF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

        System.out.println(shortF.format(dateTime));
        System.out.println(mediumF.format(dateTime));

        DateTimeFormatter ownF1 = DateTimeFormatter.ofPattern("dd MMMM, yyyy, hh:mm");
        DateTimeFormatter ownF2 = DateTimeFormatter.ofPattern("MMyy");

        System.out.println(ownF1.format(dateTime));
        System.out.println(ownF2.format(dateTime));

        // Java 7 style
        String expirationDate = "0909";
        SimpleDateFormat sdf = new SimpleDateFormat("MMyy");
        Date date1 = sdf.parse(expirationDate);
        System.out.println(date1);

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date1);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);

        Date lastDayOfMonth = calendar.getTime();

        sdf.applyPattern("yyyyMMdd");


        System.out.println(sdf.format(lastDayOfMonth));
    }
}