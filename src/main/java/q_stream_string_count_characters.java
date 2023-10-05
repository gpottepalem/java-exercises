import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Given a String, find each character and the occurrences of it, ignore space, numeric, any special character.
 * e.g.
 * input : "Java"
 * output: J : 1, a: 2, v:1
 */
class Scratch {
    public static void main(String[] args) {
//        String str = "java is getting better and evolving faster now.";
//        String str = "Java 20 released on March, 21st 2023 is the latest Java version";
        String str = "latest java version is 20";

        System.out.println("String: " + str);
        System.out.println("length: " + str.length());

        declarativeFunctionalWay(str);

        imperativeWay(str);
    }

    private static void declarativeFunctionalWay(String str) {
        System.out.println("\nDeclarative Functional way, focus on what:");
        // Declarative Functional way, focus on what
        Map<Character, List<Character>> groupedByCharDeclarative =
            str.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> Character.isAlphabetic(ch))
//                .collect(Collectors.groupingBy(c -> c)); // HashMap
               .collect(Collectors.groupingBy(c -> c, TreeMap::new, Collectors.toList())); // TreeMap

        Map<Character, Long> groupedByCharCountDeclarative =
            str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> Character.isAlphabetic(c))
//                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
                .collect(Collectors.groupingBy(c -> c, TreeMap::new, Collectors.counting()));

        System.out.println("grouped by char      : " + groupedByCharDeclarative);
        System.out.println("grouped by char count: " + groupedByCharCountDeclarative);
        System.out.println("Total alphabets found: " + groupedByCharDeclarative.values().stream().mapToInt(List::size).sum());
    }

    private static void imperativeWay(String str) {
        System.out.println("\nImperative:");

        // Imperative way, focus on what and how
        Map<Character, List<Character>> groupedByCharImperative = new HashMap<>();
        Map<Character, Integer> groupedByCharCountImperative = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isAlphabetic(c)) {
                if (groupedByCharImperative.containsKey(c)) {
                    groupedByCharImperative.get(c).add(c);
                    groupedByCharCountImperative.put(
                        c, new AtomicInteger(groupedByCharCountImperative.get(c)).incrementAndGet()
                    );
                } else {
                    List<Character> l = new ArrayList<>();
                    l.add(c);
                    groupedByCharImperative.put(c, l);
                    groupedByCharCountImperative.put(c, 1);
                }
            }
        }
        System.out.println("grouped by char      : " + groupedByCharImperative);
        System.out.println("grouped by char count: " + groupedByCharCountImperative);
        int count = 0;
        for(Character key : groupedByCharCountImperative.keySet()) {
            count += groupedByCharCountImperative.get(key);
        }
        System.out.println("Total alphabets found: " + count);

        // Imperative way, better
        System.out.println("\nImperative Better:");
        groupedByCharCountImperative = new HashMap<>();
        
        for (int i = 0; i < str.length(); i++) {
            var c = str.charAt(i);
            if(Character.isAlphabetic(c)) {
                groupedByCharCountImperative.put(c, groupedByCharCountImperative.getOrDefault(c, 0)+1);
            }
        }
        System.out.println("grouped by char count: " + groupedByCharCountImperative);
    }

}
