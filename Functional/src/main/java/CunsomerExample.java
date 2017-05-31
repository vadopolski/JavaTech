import java.util.HashMap;
import java.util.Map;

@FunctionalInterface interface Cunsomer<T> {
    void apply(T t);
}

@FunctionalInterface interface BiCunsomer<T, U> {
    void apply(T t, U u);
}

public class CunsomerExample {

    public static void main(String[] args) {
        Cunsomer<String> c1 = System.out::println;
        Cunsomer<String> c2 = x -> System.out.println(x);

        c1.apply("Test1 OK");
        c2.apply("Test2 OK");

        Map<String, Integer> map = new HashMap<String, Integer>();

        BiCunsomer<String, Integer> bc1 = map::put;
        BiCunsomer<String, Integer> bc2 = (x,y) -> map.put(x, y);

        bc1.apply("test2", 2);
        bc2.apply("test3", 3);

        System.out.println(map.toString());
    }
}