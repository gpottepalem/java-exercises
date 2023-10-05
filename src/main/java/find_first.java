import java.util.List;

class Scratch {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4);
        var result = list.stream()
                         .filter(i-> i == 1)
                         .findFirst()
                         .map(i-> "ONE")
                         .orElse(null);
        System.out.println(result);

        result = list.stream()
                         .filter(i-> i == 5)
                         .findFirst()
                         .map(i-> "FIVE")
                         .orElse(null);
        System.out.println(result);
    }
}