import java.util.Map;
import java.util.stream.Collectors;

/**
 * Complete the function scramble(str1, str2) that returns true if a portion of str1 characters can be rearranged to
 * match str2, otherwise returns false.
 *
 * Notes:
 * Only lower case letters will be used (a-z). No punctuation or digits will be included.
 * Performance needs to be considered.
 * Examples
 * scramble('rkqodlw', 'world') ==> True
 * scramble('cedewaraaossoqqyt', 'codewars') ==> True
 * scramble('katas', 'steak') ==> False
 */
class Scratch {
    public static void main(String[] args) {
        System.out.println(scramble("rkqodlw", "world"));
        System.out.println(scramble("cedewaraaossoqqyt", "codewars"));
        System.out.println(scramble("katas", "steak"));
        System.out.println(scramble("rkqodlw","world"));
        System.out.println(scramble("cedewaraaossoqqyt","codewars"));
        System.out.println(scramble("katas","steak"));
        System.out.println(scramble("scriptjavx","javascript"));
        System.out.println(scramble("scriptingjava","javascript"));
        System.out.println(scramble("scriptsjava","javascripts"));
        System.out.println(scramble("javscripts","javascript"));
        System.out.println(scramble("aabbcamaomsccdd","commas"));
        System.out.println(scramble("commas","commas"));
        System.out.println(scramble("sammoc","commas"));
    }

    public static boolean scramble(String str1, String str2) {
        Map<Character, Long> rearrangeMatchCheckCharsGroupedByCount = str2.chars()
            .mapToObj(c-> (char)c)
            .collect(Collectors.groupingBy(c-> c, Collectors.counting()));

        Map<Character, Long> portionOfCharsToBeCheckedGroupedByCount = str1.chars()
            .mapToObj(c-> (char)c)
            .collect(Collectors.groupingBy(c-> c, Collectors.counting()));

        return rearrangeMatchCheckCharsGroupedByCount.entrySet().stream()
            .allMatch(entry ->
                portionOfCharsToBeCheckedGroupedByCount.get(entry.getKey()) != null  &&
                portionOfCharsToBeCheckedGroupedByCount.get(entry.getKey()) >= entry.getValue()
            );
    }

}
