import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

class Scratch {
    public static void main(String[] args) {
        // Optional cannot be constructed, private constructor, empty() returns an instance holding null value, and get() throws NoSuchElementException
        Optional<String> optional = null;// = Optional.empty();

        try {
            optional.get();
        } catch(Exception ex) {
            assert(ex instanceof NullPointerException);
            System.out.println(ex);
        }

        try {
            optional.ifPresentOrElse( p-> System.out.println("Yes"), ()-> System.out.println("No"));
        } catch(Exception ex) {
            assert(ex instanceof NullPointerException);
            System.out.println(ex);
        }

        try {
            optional = Optional.empty();
            optional.get();
        } catch(Exception ex) {
            assert(ex instanceof NoSuchElementException);
            System.out.println(ex);
        }

        optional = Optional.empty();
        System.out.println("Optional.empty() isPresent(): " + optional.isPresent());
        System.out.println("Optional.empty() isEmpty(): " + optional.isEmpty());

        optional.ifPresent(p-> System.out.println(p)); // otherwise nothing
        optional.ifPresentOrElse( (p)-> System.out.println("Yes"), ()-> System.out.println("No"));

        try {
            Optional.of(null);
        } catch(Exception ex) {
            assert(ex instanceof NullPointerException);
            System.out.println(ex);
        }

        optional = Optional.of("Giri");
        assert(optional.isPresent());
        System.out.println(optional.isPresent());
        optional.ifPresent(System.out::println);

        assert(optional.get().equals("Giri"));
        assert(optional.get().equals("Giri"));
        assert(optional.get().equals("Giri"));

        optional.ifPresentOrElse( p-> System.out.println(p), ()-> System.out.println("No"));

        var result = findName(List.of("A", "B", "C"), "C");
        System.out.println("findName found result: " + result);
        System.out.println("findName found result get: " + result.get());
        System.out.println("findName found result get: " + result.get());
        result.ifPresentOrElse(p -> System.out.println(p), () -> System.out.println("null"));

        result = findName(List.of("A", "B", "C"), "C1");
        System.out.println("findName not found result: " + result);
        result.ifPresentOrElse(p -> System.out.println(p), () -> System.out.println("null"));
    }

    static Optional<String> findName(List<String> names, String name) {
        return names.stream()
            .filter(curName -> curName.equals(name))
            .findFirst();
    }
}