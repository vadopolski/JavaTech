import java.util.Optional;

public class OptionalExample {

    public static Optional<Double> average(int... scores) {
        if (scores.length == 0) {
            return Optional.empty();
        }

        double sum = 0.0;
        for (double score : scores) {
            sum += score;
        }

        return Optional.of( sum / scores.length );
    }

    public static void main(String[] args) {
        System.out.println("The avergae is " + average(5, 8));
        System.out.println("The average is " + average());

        Optional<Double> opt = average(5, 8);

        if (opt.isPresent()) {
            System.out.println(opt.get());
        }

        opt.ifPresent(System.out::println);

        Optional<Double> opt2 = average();
        System.out.println(opt2.orElse(Double.NaN));
        System.out.println(opt2.orElseGet(() -> Math.random()));
        System.out.println(opt2.orElseThrow(() -> new IllegalStateException()));
    }
}