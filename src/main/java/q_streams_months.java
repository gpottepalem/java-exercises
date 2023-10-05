import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Find nth odd month
 */
class Scratch {
    record Month(String name, int days){}

    public static void main(String[] args) {
        var months = List.of(
            new Month("Jan", 31),
            new Month("Feb", 28),
            new Month("Mar", 31),
            new Month("Apr", 30),
            new Month("May", 31),
            new Month("Jun", 30),
            new Month("Jul", 31),
            new Month("Aug", 31),
            new Month("Sep", 30),
            new Month("Oct", 31),
            new Month("Nov", 30),
            new Month("Dec", 31)
        );

        System.out.println(months);

        System.out.println("Sums months days: " + months.stream().mapToInt(m -> m.days).sum());

        System.out.println(
            "5th month with odd days:" +
            months.stream()
                .filter(m -> m.days % 2 == 1)
                .skip(4)
                .findFirst()
//                .orElse(null)
        );

        System.out.println(
            "Count odd days months:" +
            months.stream()
                .filter(m -> m.days % 2 == 1)
                .count()
        );

        System.out.println(
            "Odd days months:" +
                months.stream()
                    .filter(m -> m.days % 2 == 1)
                    .map(m -> m.name)
                    .toList()
        );

        System.out.println(
            "Sum of days of odd months: " +
                months.stream()
                    .filter(m -> m.days % 2 == 1)
                    .mapToInt(m -> m.days)
                    .sum()
        );

        Map<String, Integer> monthsMap = new LinkedHashMap<>();//new HashMap<>(); // Java 8
        monthsMap.put("Jan", 31);
        monthsMap.put("Feb", 28);
        monthsMap.put("Mar", 31);
        monthsMap.put("Apr", 30);
        monthsMap = Map.of("Jan", 31, "Feb", 28, "Mar", 31, "Apr", 30); // Java 9
        monthsMap.entrySet().forEach(entry -> System.out.println(entry));
        System.out.println(monthsMap);
        // using summingInt
        var oddMonthsSum = monthsMap.entrySet().stream().filter(m-> m.getValue()%2 == 1).collect(Collectors.summingInt(m-> m.getValue()));
        System.out.println("Sum of days of odd months: " + oddMonthsSum);
        oddMonthsSum = monthsMap.entrySet().stream().filter(m-> m.getValue()%2 == 1).mapToInt(m-> m.getValue()).sum();
        System.out.println("Sum of days of odd months: " + oddMonthsSum);
    }

}
