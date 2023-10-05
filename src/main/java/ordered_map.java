import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * From a given String, count each word and print words and their count ordered by words in alphabetical order.
 */
class Scratch {
    public static void main(String[] args) {
        String str = "java is getting better and is evolving faster now";
        String[] words = str.split(" ");

        Map groupedWordCount = Arrays.stream(words)
                               .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println("grouped unordered word count: " + groupedWordCount);

        Map groupedWordCountOrdered = Arrays.stream(words)
                                      .collect(Collectors.groupingBy(word -> word, TreeMap::new, Collectors.counting()));
        System.out.println("grouped ordered word count  : " + groupedWordCountOrdered);
    }
}