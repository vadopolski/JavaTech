import java.util.function.Predicate;


@FunctionalInterface
interface PredicateLocal<T> {
    boolean test (T t);
}

@FunctionalInterface
interface BiPredicateLocal<B, T> {
    boolean test (B b, T t);
}

public class FunctionalPredicateEx {

    public static void main(String[] args) {

        PredicateLocal<String> p1 = String::isEmpty;
        PredicateLocal<String> p2 = x -> x.isEmpty();

        System.out.println( p1.test("") );
        System.out.println( p2.test(""));

        BiPredicateLocal<String, String> b1 = String::startsWith;
        BiPredicateLocal<String, String> b2 = (x , y) -> x.startsWith(y);

        System.out.println( b1.test("test", "t"));
        System.out.println( b2.test("test", "t"));

        Predicate<String> egg = x -> x.contains("egg");
        Predicate<String> brown = x -> x.contains("brown");
        PredicateLocal<String> brownEgg = x -> x.contains("egg") && x.contains("brown");
        PredicateLocal<String> notBrownEgg = x -> x.contains("egg") && !x.contains("brown");

        Predicate<String> brownEgg2 = egg.and(brown);
        Predicate<String> brownEgg3 = egg.and(brown.negate());

        System.out.println(egg.test("strong_egg"));
        System.out.println(brownEgg.test("strong_egg_brown"));
        System.out.println(brownEgg2.test("strong_egg_brown"));
        System.out.println(brownEgg3.test("strong_egg_brown"));
    }
}