import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * A Stream is much like an iterator on a collection of objects and provides some nice fluent functions. Using the
 * methods of this interface, we can compose a sequence of calls so that the code reads and flows in the same way we’d
 * state problems, making it easier to read.
 * The method stream() is available on all collections in JDK 8 and it wraps the collection into an instance of Stream.
 *
 * The map() method is quite unlike the forEach() method, which simply runs the block in the context of each element
 * in the collection.
 * The filter() method expects a lambda expression that returns a boolean result. If the lambda expression returns a
 * true, the element in context while executing that lambda expression is added to a result collection; it’s skipped
 * otherwise. The filter() method returns an iterator just like the map() method does, but the similarity ends there.
 * Whereas the map() method returns a collection of the same size as the input collection, the filter() method does not.
 * - Venkat S
 *
 * Collection -> (Stream) -> (Zero or More Intermediate Operations) -> (Terminal Operation)
 */
class Scratch {
    public static void main(String[] args) {
        // Java List allows multiple null objects
        List jvmLanguages1 = Arrays.asList("Java", null, "Groovy", "Kotlin", null);

        List jvmLanguages2 = new ArrayList();
        jvmLanguages2.add("Java");
        jvmLanguages2.add(null);
        jvmLanguages2.add("Groovy");
        jvmLanguages2.add("Kotlin");
        jvmLanguages2.add(null);

        System.out.println("jvmLanguages1:" + jvmLanguages1);
        System.out.println("jvmLanguages2:" + jvmLanguages2);

        List jvmLanguages3 = Stream.of("Java", null, "Groovy", "Kotlin", null).toList();
        System.out.println("jvmLanguages:" + jvmLanguages3);

        // Gotcha-1
        // List.of() doesn't allow nulls, Stream.of() does
        try {
            var jvmLanguages = List.of("Java", null, "Groovy", "Kotlin", null);
        } catch(NullPointerException e) {
            System.out.println("NPE:" + e.getMessage());
        }

        // Gotcha-2
        // Both Stream.of(...).toList() and List.of() return ImmutableCollections that cannot be modified
        try {
            jvmLanguages3.add("Scala");
        } catch (UnsupportedOperationException ex) {
            System.out.println("Return list from Stream.of(...).toList() is: " + jvmLanguages3.getClass().getName());
            System.out.println("Return list from List.of(...) is: " + List.of("Java").getClass().getName());
        }

        List result = jvmLanguages1.stream()
                          .filter(Objects::isNull)
                          .toList();
        System.out.println("Streams retain nulls? " + (Arrays.asList(null, null).equals(result) ? "Yes" : "No"));

        // Gotcha-3
        // Concatenate two lists using streams
        System.out.println(Stream.concat(List.of(1,2,3,4).stream(), List.of(5,6,7,8).stream()).toList());
    }
}