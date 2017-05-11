import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class MergeExample {

    public static void main(String[] args) {
        BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;

        Map<String, String> stringMap = new HashMap<String, String>();

        stringMap.put("Jenny", "Bus Tour");
        stringMap.put("Tom", "Trum");

        System.out.println(stringMap);

        String jenny = stringMap.merge("Jenny", "SkyRide", mapper);

        System.out.println(jenny);

        String tom = stringMap.merge("Tom", "SkyRide", mapper);

        System.out.println(tom);

        System.out.println(stringMap);

    }
}