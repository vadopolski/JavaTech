import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.BooleanSupplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample2 {

    public static int max (IntStream ints){
        OptionalInt oInt = ints.max();
        return oInt.orElseThrow(RuntimeException::new);
    }

    public static int range(IntStream ints) {
        IntSummaryStatistics stats = ints.summaryStatistics();
        if (stats.getCount() == 0) throw new RuntimeException();
        return stats.getMax() - stats.getMin();
    }

    public static void main(String[] args) {

        Stream<Integer> intStream1 = Stream.of(1, 2, 3);
        System.out.println(intStream1.reduce(0, (s, n) -> s + n));

        Stream<Integer> intStream2 = Stream.of(1, 2, 3);
        System.out.println(intStream2.mapToInt(x -> x).sum());

        DoubleStream empty = DoubleStream.empty();
        DoubleStream oneValue = DoubleStream.of(3.14);
        DoubleStream twoValue = DoubleStream.of(3.14, 5.10);

        oneValue.forEach(System.out::println);
        twoValue.forEach(System.out::print);

        System.out.println();

        DoubleStream random = DoubleStream.generate(Math::random);
        DoubleStream fractions = DoubleStream.iterate(.5, d -> d / 2);

        random.limit(3).forEach(System.out::println);

        System.out.println();

        fractions.limit(3).forEach(System.out::println);

        IntStream count = IntStream.iterate(1, n -> n + 1).limit(5);
        count.forEach(System.out::println);

        IntStream range = IntStream.range(1, 6);
        range.forEach(System.out::println);

        IntStream stream = IntStream.rangeClosed(1, 10);
        OptionalDouble optional = stream.average();

        optional.ifPresent(System.out::println);

        IntStream imax = IntStream.of(1, 3, 6, 8);
        System.out.println(max(imax));

        IntStream iranges = IntStream.of(5, 7, 8, 9, 11);
        System.out.println(range(iranges));

        // Functional Interfaces for Primitives
        BooleanSupplier b1 = () -> true;
        BooleanSupplier b2 = () -> Math.random() > .5;

        System.out.println(b1.getAsBoolean());
        System.out.println(b2.getAsBoolean());




    }
}
