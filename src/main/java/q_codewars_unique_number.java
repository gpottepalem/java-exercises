import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * There is an array with some numbers. All numbers are equal except for one. Try to find it!
 *
 * Kata.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
 * Kata.findUniq(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
 * It’s guaranteed that array contains at least 3 numbers.
 *
 * The tests contain some very huge arrays, so think about performance.
 */
class Scratch {
    public static void main(String[] args) {
        System.out.println(findUniq(new double[]{0, 1, 0}));
        System.out.println(findUniq(new double[]{1, 1, 1, 2, 1, 1}));

        System.out.println(findUniq2(new double[]{0, 1, 0}));
        System.out.println(findUniq2(new double[]{1, 1, 1, 2, 1, 1}));
    }

    public static Object findUniq(double[] arr) {
        return Arrays.stream(arr)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .filter(entry-> entry.getValue() == 1)
            .map(Map.Entry::getKey)
            .findFirst()
            .get();
    }

    /**
     * Slower
     */
    public static Object findUniq2(double[] arr) {
        var list = Arrays.stream(arr).boxed().toList();
        return list.stream()
            .filter(l -> Collections.frequency(list, l) == 1)
            .findFirst()
            .get();
    }
}