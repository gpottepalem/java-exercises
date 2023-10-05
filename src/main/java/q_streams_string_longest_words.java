import java.util.Arrays;
import java.util.Comparator;

class Scratch {
    public static void main(String[] args) {
        String str = "Java is getting better and evolving faster now";

        // Declarative Functional way, focus on what
        System.out.println(Arrays.stream(str.split(" ")).toList());
        System.out.println(
            "The longest word: " +
            Arrays.stream(str.split(" "))
            //.collect(Collectors.groupingBy(word -> word.length()))
                .max(Comparator.comparingInt(String::length))
                .get()
        );

        System.out.println(
            "The 2nd longest word: " +
                Arrays.stream(str.split(" "))
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .skip(1)
                    .findFirst()
                    .get()
        );

        System.out.println(
            "The 3rd longest word: " +
            Arrays.stream(str.split(" "))
                .sorted(Comparator.comparingInt(String::length).reversed())
                .skip(2)
                .findFirst()
                .get()
        );

        System.out.println("Traditional way:");
        // Imperative way, focus on what and how
    }
}
