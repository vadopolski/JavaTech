import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.function.BinaryOperator;

public class StreamExample {

    public static void main(String[] args) {
        Stream<String> stream1 = Stream.empty();

        Stream<Integer> stream2 = Stream.of(1);

        Stream<Integer> stream3 = Stream.of(1, 2, 3);

        List<String> list = Arrays.asList("a", "b", "c");

        Stream<String> listStream1 = list.stream();

        Stream<String> listStream2 = list.parallelStream();

        System.out.println(list);

        System.out.println(listStream1);

        Stream<Double> randoms = Stream.generate(Math::random);

        Stream<Integer> integerStream = Stream.iterate(1, n -> n + 2);

//        integerStream.forEach(System.out::print);

        Stream<String> monkeys = Stream.of("chimpanzee", "gorilla", "martishka");

        Optional<String> min = monkeys.min((x, y) -> x.length() - y.length());

        min.ifPresent(System.out::println);

//        System.out.println(monkeys.count());

        Stream<String> monkeys2 = Stream.of("gorilla", "chimpanzee", "martishka");
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

        // reduce example
        // old version
        String[] array = {"t", "e", "s", "t"};
        String res = "";

        for (String st : array) {
            res += st;
        }

        System.out.println(res);

        // new version
        Stream<String> stream_red_1 = Stream.of("t", "e", "s", "t");
        String word = stream_red_1.reduce("", (x, y) -> x + y);
        System.out.println(word);

        Stream<String> stream_red_2 = Stream.of("t", "e", "s", "t");
        word = stream_red_2.reduce("", String::concat);
        System.out.println(word);

        Stream<Integer> stream_red_3 = Stream.of(1, 2, 3);
        System.out.println(stream_red_3.reduce(1, (a, b) -> a * b));

        BinaryOperator<Integer> op = (x, y) -> x * y;

        Stream<Integer> emptyStream = Stream.empty();
        Stream<Integer> oneElementStream = Stream.of(3);
        Stream<Integer> threeElementStream = Stream.of(3, 5, 6);

        emptyStream.reduce(op).ifPresent(System.out::println);
        oneElementStream.reduce(op).ifPresent(System.out::println);
        threeElementStream.reduce(op).ifPresent(System.out::println);

        // filter(), distinkt(),
        Stream<String> stream = Stream.of("monkey", "bomboo", "apple");

        stream.filter(x -> x.startsWith("a")).forEach(System.out::println);

        Stream<String> s = Stream.of("duck", "duck", "duck", "goose");

        s.distinct().forEach(System.out::println);

        // limit(), skip()
        Stream<Integer> intStream = Stream.iterate(1, n -> n + 1);
        intStream.skip(8).limit(3).forEach(System.out::println);

        // map()
        Stream<String> s1 = Stream.of("one", "two", "three");

        s1.map(String::toUpperCase).forEach(System.out::println);

        //flatMap()
        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("one");
        List<String> two = Arrays.asList("two", "three");

        Stream<List<String>> listStream = Stream.of(zero, one, two);

        listStream.flatMap(l -> l.stream()).forEach(System.out::println);

        // sorted()
        Stream stream4 = Stream.of("one", "oane");

        stream4.sorted().forEach(System.out::println);

        Stream abcdStream = Stream.of("a", "b", "c", "d");

        abcdStream.sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // peek()
        Stream<String> stream5 = Stream.of("maria", "anna", "alena");
        long count = stream5.filter(ss -> ss.startsWith("a")).peek(System.out::println).count();

        StringBuilder builder = new StringBuilder();

        List<Integer> li = new ArrayList<>();
        List<Character> lc = new ArrayList<>();

        li.add(1);
        lc.add('c');

        Stream<List<?>> sss = Stream.of(li, lc);

        sss.map(l -> lc.size()).forEach(System.out::print);

        Stream<List<?>> ass = Stream.of(li,lc);

        ass.peek(z -> builder.append(z)).map(List::size).forEach(System.out::print);

        System.out.println(builder);

        // putting together in the pipeline
        List<String> l1 = Arrays.asList("Anna", "Mary", "Kate", "Indigo");
        List<String> f1 = new ArrayList<>();

        for (String st : l1) {
            if (st.length() == 4 ) {
                f1.add(st);
            }
        }

        Iterator<String> iter = f1.iterator();

        if (iter.hasNext())
            System.out.println(iter.next());
        if (iter.hasNext())
            System.out.println(iter.next());


        l1.stream().filter(x -> x.length() == 4)
            .sorted()
            .limit(2)
            .forEach(System.out::println);

        Stream.generate(() -> "Elsa")
            .filter(n -> n.length() == 4)
            .limit(2)
            .sorted()
            .forEach(System.out::println);

        Stream<Integer> infiniteInt = Stream.iterate(1, n -> n +1);

        infiniteInt
            .limit(5)
            .filter(x -> x % 2 == 1)
            .forEach(System.out::print);

        Stream<Integer> infiniteInt2 = Stream.iterate(1, n -> n+1);

        System.out.println();

        infiniteInt2
            .peek(System.out::print)
            .limit(5)
            .forEach(System.out::println);

    }
}