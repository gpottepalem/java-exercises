import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Scratch {


    public static void main(String[] args) {

        enum TEST {
            A("a"), B("b"), C("c");

            private String s;

            TEST(String s) {
                this.s = s;
            }
        }

        record Person(int id, String name){};

        Double d1 = 3.5;
        Double d2 = 4.0;
        System.out.println(d1 < d2);
        System.out.println(d1.doubleValue() < d2.doubleValue());
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE - 1);
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(Integer.MAX_VALUE/1000/60/60); // hours
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE - 1);
        System.out.println(Long.MAX_VALUE + 1);
        System.out.println(Long.MAX_VALUE/1000/60/60); // hours

        var tests = List.of(TEST.A, TEST.B, TEST.C);
        tests.forEach(test -> System.out.println(test));
        System.out.println(TEST.valueOf("A"));
        System.out.println(TEST.values());
        System.out.println(Arrays.stream(TEST.values()).toList());

        System.out.println(Float.NEGATIVE_INFINITY);
        System.out.println(1.2 < Float.NEGATIVE_INFINITY);
        System.out.println(Double.NEGATIVE_INFINITY);
        System.out.println(1.2 < Double.NEGATIVE_INFINITY);
        System.out.println(-1.0f/0.0d);
        System.out.println(Float.parseFloat("-Infinity"));

        // Map.of
        final var m = Map.of(
            1, new HashMap<String, Person>(),
            2, new HashMap<String, Person>()
        );
        m.get(1).put("test", new Person(1, "test"));
        System.out.println(m);
        int i = 6;
        Integer j = 10;
        System.out.println((double)i/j);

    }
}