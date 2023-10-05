import java.util.List;

/**
 * Find max and min numbers in a list of numbers.
 */
class Scratch {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(9, 10, 21, 15, 18, 19, 22, 24, 35, 99, 101, 220, 999);

        System.out.println("Max of : " + numbers + " is: " + declarativeFunctionalWayMax(numbers));
        System.out.println("Min of : " + numbers + " is: " + declarativeFunctionalWayMin(numbers));

        var values = List.of(234.75, 238.75, 247.50);
        System.out.println("Average of : " + values + " is: " + declarativeFunctionalWayAvg(List.of(234.75, 238.75, 247.50)));
        values = List.of(234.75, 238.75, 247.50);
        System.out.println("Average of : " + values + " is: " + declarativeFunctionalWayAvg(List.of(234.75, 238.75, 247.50)));

    }

    static Integer declarativeFunctionalWayMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compare).orElse(null);
    }

    static Integer declarativeFunctionalWayMin(List<Integer> numbers) {
        return numbers.stream().min(Integer::compare).orElse(null);
    }

    static Double declarativeFunctionalWayAvg(List<Double> numbers) {
        return numbers.stream().mapToDouble(Double::doubleValue).average().orElse(Double.NaN);
    }
}
