import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        Stream<String> stream1 = Stream.empty();

        Stream<Integer> stream2 = Stream.of(1);

        Stream<Integer> stream3 = Stream.of(1,2,3);

        List<String> list = Arrays.asList("a", "b", "c");

        Stream<String> listStream1 = list.stream();

        Stream<String> listStream2 = list.parallelStream();

        System.out.println(list);

        System.out.println(listStream1);

        Stream<Double> randoms = Stream.generate(Math::random);

        Stream<Integer> integerStream = Stream.iterate(1, n -> n+2);

//        integerStream.forEach(System.out::print);

        Stream<String> monkeys = Stream.of("chimpanzee", "gorilla", "martishka");

        Optional<String> min = monkeys.min((x, y) -> x.length() - y.length());

        min.ifPresent(System.out::println);

//        System.out.println(monkeys.count());

        Stream<String> monkeys2 = Stream.of( "gorilla", "chimpanzee", "martishka");
        Stream<String> monkeys3 = Stream.generate(() -> "bonobo");

        monkeys2.findAny().ifPresent(System.out::println);
        monkeys3.findAny().ifPresent(System.out::println);

        List<String> listMonkeys = Arrays.asList("gorilla", "test", "martishka");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
        Stream<String> infinite = Stream.generate(() -> "gorilla");

        System.out.println(list.stream().anyMatch(pred));
        System.out.println(list.stream().allMatch(pred));
        System.out.println(list.stream().noneMatch(pred));

        System.out.println("last " + infinite.anyMatch(pred));
    }
}