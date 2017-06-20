import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sbt-opolskiy-va on 16.06.2017.
 */

class ExceptionCaseStudy {
    public static List<String> create() throws IOException {
        throw new IOException();
    }
}

public class AdvancedStreamTest1 {

    public static void threeDigitNum(Optional<Integer> optional) {
        if (optional.isPresent()) {
            Integer num = optional.get();
            String str = "" + num;

            if (str.length() > 3) {
                System.out.println(str);
            }
        }
    }

    private static void threeDigitNum2(Optional<Integer> optional) {
        optional.map(n -> "" + n)
            .filter(s -> s.length() > 3)
            .ifPresent(System.out::println);
    }

    private static List<String> createSafe () {
        try {
            return ExceptionCaseStudy.create();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        List<String> cats = new ArrayList<>();

        cats.add("Mars");
        cats.add("Musja");

        Stream<String> scats = cats.stream();

        cats.add("Kesha");

        System.out.println(scats.count());

        Optional<Integer> opt = Optional.ofNullable(1231);

        threeDigitNum(opt);

        Optional<Integer> opt2 = Optional.ofNullable(1231);

        threeDigitNum2(opt2);

        Supplier<List<String>> s = () -> {
            try {
                return ExceptionCaseStudy.create();

            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        Stream<String> ohMy = Stream.of("lion", "bird", "fish");
        String result = ohMy.collect(Collectors.joining(", "));
        System.out.println(result);

        Stream<String> averageLength = Stream.of("lion", "bird", "fish");
        Double result2 = averageLength.collect(Collectors.averagingDouble(String::length));
        System.out.println(result2);

//        Stream<String> animals2 = Stream.of("lion", "horse", "cow");
//        TreeSet<String> result3 = animals2
//            .filter(t -> t.startsWith("l"))
//            .collect(Collectors.toCollection(TreeSet::new));
//        System.out.println(result3);

//
//        Stream<String> animals3 = Stream.of("lion", "horse", "cow");
//        Map<String, Integer> result4 = animals3
//            .collect(Collectors.toMap(st -> st, String::length));
//        System.out.println(result4);


        Stream<String> animals4 = Stream.of("lion", "horse", "cow");
        Map<Integer, String> result5 = animals4
            .collect(Collectors.toMap(String::length, z -> z, (x, y) -> x + y, TreeMap::new));
        System.out.println(result5);
        System.out.println(result5.getClass());

        // grouping data
        Stream<String> stream6 = Stream.of("test1", "test2", "test33");
        Map<Integer, List<String>> map = stream6.collect(Collectors.groupingBy(String::length));
        System.out.println(map);

        Stream<String> animals6 = Stream.of("lion", "tiger", "mouse");
        Map<Integer, Set<String>> map2 = animals6.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(map2);
        System.out.println(map2.getClass());

        Stream<String> animals7 = Stream.of("bee", "fish", "snake");
        TreeMap<Integer, Set<String>> map3 = animals7
            .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
        System.out.println(map3);
        System.out.println(map3.getClass());

        Stream<String> animals8 = Stream.of("bee", "fish", "snake");
        TreeMap<Integer, List<String>> map4 = animals8
            .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
        System.out.println(map4);
        System.out.println(map4.getClass());

        Stream<String> animals9 = Stream.of("bee", "fish", "snake");
        Map<Boolean, List<String>> map5 = animals9
            .collect(Collectors.groupingBy(x -> x.length() > 4 ));
        System.out.println(map5);

        Stream<String> animals10 = Stream.of("lions", "tigers", "bears");
        Map<Integer, Long> map6 = animals10
            .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(map6);

        Stream<String> animals11 = Stream.of("lions", "tigers", "bears");
        Map<Integer, Optional<Character>> map7 = animals11.collect(
            Collectors.groupingBy(
                String::length,
                Collectors.mapping(j -> j.charAt(0),
                    Collectors.minBy(Comparator.naturalOrder()))));
//        System.out.println(map7);

    }
}