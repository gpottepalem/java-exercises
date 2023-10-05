import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Scratch {
    record Address(CharSequence street, String town){}
    record Person(String name, List<Address> addresses){}

    static BiFunction<List<Address>, String, Address> findAddress = (addresses, street) ->
        addresses.stream().filter(a-> a.street.equals(street)).findFirst().orElse(null);

    static Function<List<Address>, Address> findStr3 = (addresses) -> findAddress.apply(addresses, "Str3");
    static Function<List<Address>, Address> findStr2 = (addresses) -> findAddress.apply(addresses, "Str2");

    static List<Person> findPeopleLivedInStreet(List<Person> people, String street) {
        // null protected stream
        return Optional.ofNullable(people)
            .orElse(Collections.emptyList())
            .stream()
            .filter(
                p -> (findAddress.apply(p.addresses, street) != null)
            ).toList();
    }
    
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("Per1",
                List.of(
                    new Address("Str1", "Twn1")
                )
            ),
            new Person("Per2",
                List.of(
                    new Address("Str2", "Twn2"),
                    new Address("Str3", "Twn2")
                )
            ),
            new Person("Per3",
                List.of(
                    new Address("Str3", "Twn3")
                )
            ),
            new Person("Per4", List.of())
        );
        
        System.out.println(people.stream().filter(p-> p.name.equals("Per1")).toList());

        // print people living in Str3
        System.out.println(
            people.stream().filter(
                p -> (findStr3.apply(p.addresses) != null)
            ).toList()
        );

        System.out.println(findPeopleLivedInStreet(null, "Str2"));
        System.out.println(findPeopleLivedInStreet(people, "Str2"));

        var personWithNoAddresses = people.stream()
            .filter(person -> person.addresses == null || person.addresses.isEmpty()).findFirst();
        System.out.println(personWithNoAddresses);

        var findFirstGreaterThan = IntStream.rangeClosed(1,10).filter(i-> i > 2).findFirst();
        assert !findFirstGreaterThan.isEmpty();
        assert findFirstGreaterThan.isPresent();

        findFirstGreaterThan = IntStream.rangeClosed(1,10).filter(i-> i > 11).findFirst();
        assert findFirstGreaterThan.isEmpty();
        assert !findFirstGreaterThan.isPresent();

        var l = List.of(1,4,5,3,2,0,6,9,8);
        // find second
        l.stream().filter(i-> i > 4).skip(1).findAny().ifPresent(e -> System.out.println(e));
        System.out.println(l.stream().filter(i-> i > 4).skip(1).findAny());

        BiFunction<List<Integer>, Integer, Optional<Integer>> findNthElementGreaterThan4 =
            (list, i) -> list.stream().filter(e-> e > 4).skip(i -1).findAny();

        System.out.println("findNthElementGreaterThan4:" + findNthElementGreaterThan4.apply(l, 3));
        
        // anyMatch
        String state = "MA-Sharon";
        System.out.println("anyMatch:" +
            Stream.of("MA", "IL")
                .anyMatch(state::startsWith)
        );
        System.out.println("noneMatch:" +
            Stream.of("MA", "IL")
                .noneMatch(state::startsWith)
        );

        System.out.print("findAny:");
        // findAny vs. anyMatch
        var found = Stream.of("MA", "IL", "")
            .filter(name-> name == null || name.isBlank() || name.isEmpty())
            .findAny();
            //.orElse("None");
        if (found.isPresent()) {
            System.out.println("findAny:.get():" + found.get().isBlank());
        }
        found.ifPresentOrElse(
            value -> System.out.println("findAny:Yes"),
            () -> System.out.println("findAny:No")
        );

        System.out.println("anyMatch:" +
            Stream.of("MA", "IL", null)
                .anyMatch(name-> name == null || name.isBlank() || name.isEmpty())
        );
    }
}
