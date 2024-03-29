import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Scratch {
    public static void main(String[] args) {
        var stageRange = IntStream.rangeClosed(0, 2);
        List<String> stagesUpTo = stageRange.mapToObj(i -> "" + i).toList();
        System.out.println(stagesUpTo);

        // immutable lists
        var l = List.of(1, 2);
        try {
            l.add(3); // can't add
        } catch (UnsupportedOperationException e) {
            System.out.println("Immutable can't add:" + l);
        }

        var ll = Arrays.asList(1,2);
        try {
            ll.add(3);
        } catch(UnsupportedOperationException e) {
            System.out.println("Immutable can't add:" + ll);
        }

        var lll = Collections.emptyList();
        try {
            lll.add(1);
        } catch(UnsupportedOperationException e) {
            System.out.println("Immutable can't add:" + lll);
        }

        var yearsRange = IntStream.
                             rangeClosed(2020, 2024)
                             .boxed()
                             .collect(Collectors.toUnmodifiableList());
        System.out.println("years:" + yearsRange + " " + yearsRange.getClass().getName());

        yearsRange = IntStream.
                         rangeClosed(2020, 2024)
                         .boxed()
                         .toList();
        System.out.println("years:" + yearsRange + " " + yearsRange.getClass().getName());

        yearsRange = Stream.concat(
            List.of(2020,2021).stream(),
            List.of(2022).stream()
        ).toList(); //collect(Collectors.toUnmodifiableList());
        System.out.println("years:" + yearsRange + " " + yearsRange.getClass().getName());

        // mutable lists
        var llll = new ArrayList<>(List.of(1,2));
        llll.add(3);
        llll.addAll(List.of(4,5));
        System.out.println(llll);

        System.out.println(Boolean.valueOf(null));
        System.out.println(Boolean.valueOf("flase"));
        System.out.println(Boolean.valueOf("null"));
        String s = null;
        System.out.println(s == null);
        s = String.valueOf("null");
        System.out.println(s == null);
        System.out.println(Boolean.FALSE.toString());
        System.out.println(String.valueOf(Boolean.FALSE));

        List a = null;
        try {
            a.isEmpty();
        } catch(NullPointerException e) {
            // expected
            System.out.println("null list isEmpty:" + e.getMessage());
        }

        a = List.of();
        System.out.println("empty list isEmpty:" + a.isEmpty() + " size:" + a.size());

        List<Integer> years = List.of(2021, 2022, 2023, 2024, 2025, 2026);
        System.out.println(years.stream().skip(years.size() - 2).toList());

        // find index
        List<Integer> listIntegers = List.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println("index indexOf(): " + listIntegers.indexOf(5));
        Optional<Integer> index = Optional.of(
            IntStream.range(0, listIntegers.size())
                .filter(i -> listIntegers.get(i) == 5)
                .findFirst()
                .orElse(-1)
        );
        System.out.println("index streams way: " + index.get());
        for(Integer year : years) {

        }
    }
}
