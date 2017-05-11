import java.time.LocalDate;
import java.util.Locale;

@FunctionalInterface
interface Supplier<T> {
    public T get();
}

public class FunctionalInterfaceExample {

    public static void main(String[] args) {
        Supplier<LocalDate> s1 = () -> LocalDate.now();
        Supplier<LocalDate> s2 = LocalDate::now;

        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();

        System.out.println(d1);
        System.out.println(d2);
    }
}