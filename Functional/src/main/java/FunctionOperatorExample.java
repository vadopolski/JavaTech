@FunctionalInterface interface Function<T, R> {
    R apply(T t);
}

@FunctionalInterface interface BiFunction <T, R, U > {
    U apply (T t, R r);
}

@FunctionalInterface interface UnaryOperator<T> extends Function<T, T> {
}

@FunctionalInterface interface BinaryOperator<T> extends BiFunction<T, T, T> {
}

public class FunctionOperatorExample {

    public static void main(String[] args) {

        Function<String, Integer> f1 = String::length;
        Function<String, Integer> f2 = x -> x.length();

        System.out.println(f1.apply("test"));
        System.out.println(f2.apply("test"));

        BiFunction<String, String, String> b1 = String::concat;
        BiFunction<String, String, String> b2 = (y, z) -> y.concat(z);

        System.out.println(b1.apply("test", " test"));
        System.out.println(b2.apply("test", " test"));

        UnaryOperator<String> uo1 = String::toUpperCase;
        UnaryOperator<String> uo2 = x -> x.toUpperCase();

        System.out.println(uo1.apply("test"));
        System.out.println(uo2.apply("test"));

        BinaryOperator<String> bo1 = String::concat;
        BinaryOperator<String> bo2 = (x, y) -> x.concat(y);

        System.out.println(bo1.apply("test", " test"));
        System.out.println(bo2.apply("test", " test"));
    }
}