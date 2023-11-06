import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

class Scratch {
    public static void main(String[] args) {
        // String format platform specific way to add new line : %n instead of \n
        System.out.print(String.format("Line1%nand Line2%n"));
        System.out.format("%d%n", 1);
        System.out.println("last line");

        System.out.println(allUpper("Giri"));
        System.out.println(allLower("giri"));

        System.out.println(":" + centerText("Giri", 11) + ":");
        System.out.println(getMap("name=John age=30 city=NewYork"));
        System.out.println(capitalizeEachWord("my name is giri."));
    }

    static boolean allUpper(String word) {
        return word.chars().noneMatch(Character::isLowerCase);
    }

    static boolean allLower(String word) {
        return word.chars().noneMatch(Character::isUpperCase);
    }

    /**
     * Formats given string to be centered, the festest way.
     * @param text
     * @param width
     * @return
     */
    static String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        System.out.println("%" + padding + "s%s%" + padding + "s"); // %3s%s%3s
        System.out.println(":" + String.format("%3s%s%3s", "", text, "") + ":"); // %3s%s%3s
        return String.format("%" + padding + "s%s%" + padding + "s", "", text, "");
    }

    /**
     * Returns Map from a given string of key=value pairs separated by space.
     * @param data
     * @return
     */
    static Map getMap(String data) { // e.g "name=John age=30 city=NewYork"
        return Arrays.stream(data.split(" "))
                   .map(kv -> kv.split("="))
                   .filter(kvArray -> kvArray.length == 2)
                   .collect(Collectors.toMap(kv -> kv[0], kv -> kv[1]));
    }

    /**
     * Capitalizesevery word in a given sentence
     * @param sentense
     * @return
     */
    static String capitalizeEachWord(String sentense) {
        if (sentense == null || input.isEmpty()) {
            return null;
        }
        return Arrays.stream(sentense.split("\\s+"))
                   .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                   .collect(Collectors.joining(" "));
    }
}
