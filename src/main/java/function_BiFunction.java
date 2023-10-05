import java.util.function.BiFunction;
import java.util.function.BiPredicate;

class Scratch {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> compare = (a, b) -> a.compareTo(b);
        BiFunction<Integer, Integer, Boolean> lessThanOrEqual = (a, b) -> a.compareTo(b) < 1;
        BiPredicate<Integer, Integer> lessThanOrEqualPredicate = (a, b) -> a.compareTo(b) < 1;

        System.out.println(compare.apply(1,2));
        System.out.println(compare.apply(2,2));
        System.out.println(compare.apply(2,1));
        System.out.println("");

        System.out.println(lessThanOrEqual.apply(1,2));
        System.out.println(lessThanOrEqual.apply(2,2));
        System.out.println(lessThanOrEqual.apply(2,1));
        System.out.println("");

        System.out.println(lessThanOrEqualPredicate.test(1,2));
        System.out.println(lessThanOrEqualPredicate.test(2,2));
        System.out.println(lessThanOrEqualPredicate.test(2,1));
    }
}
