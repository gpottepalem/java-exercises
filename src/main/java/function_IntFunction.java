import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

class Scratch {
    static int chunk = 11;

    static Function<Integer, Boolean> isEven = i -> i % 2 == 0;
    static IntFunction<Boolean> isEven1 = i -> i % 2 == 0; // same as above

    static BiFunction<Integer, Integer, Boolean> isEvenChunk = (i, chunk) -> isEven1.apply(i / chunk);
//    static BiFunction<Integer, Integer, Boolean> isEvenChunk = (i, chunk) -> isEven.apply(i / chunk);

    public static void main(String[] args) {
        System.out.println(
            IntStream.rangeClosed(1,200)
                .filter(i -> isEvenChunk.apply(i, 10))
                .mapToObj(Integer::valueOf)
                .toList()
        );

        final Predicate<Integer> isEvenFunction = i -> i % 2 == 0;
        System.out.println(isEvenFunction.test(10));

//        IntStream.rangeClosed(1,5).filter((IntPredicate) isEvenFunction).count(); // ClassCastException
        var numbers = List.of(1,2,3,4,5);
        System.out.println(numbers + " even count: " + List.of(1,2,3,4,5).stream().filter(isEvenFunction).count());

        final IntPredicate isEvenIntPredicate = i -> i % 2 == 0;
        var range = IntStream.rangeClosed(1,5);
        System.out.println(range + " even count: " + range.filter(isEvenIntPredicate).count());

        final Predicate<String> startsWithG = name -> name.startsWith("G");
        var names = List.of("Giri", "Boo");
        System.out.println(names + " startsWithG:" + names.stream().filter(startsWithG).count());
    }
}