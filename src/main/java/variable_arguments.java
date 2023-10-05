import java.util.Arrays;
import java.util.List;

class Scratch {
    static void varArgs(String... strs) {
        Arrays.stream(strs).forEach(System.out::print);
        System.out.println();
    }

    public static void main(String[] args) {
        varArgs("A ", "B ");
        varArgs("C ", "D ");
        varArgs(List.of("A ", "B ").stream().toArray(String[]::new));

        String[][] listOfArrays = {{"1", "2"}, {"3", "4"}};
        Arrays.stream(listOfArrays).forEach(System.out::println);
    }
}