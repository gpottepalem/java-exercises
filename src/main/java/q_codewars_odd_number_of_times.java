import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

class Scratch {
    public static void main(String[] args) {
        System.out.println(findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
        System.out.println(findIt(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5}));
        System.out.println(findIt(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}));
        System.out.println(findIt(new int[]{10}));
        System.out.println(findIt(new int[]{1,1,1,1,1,1,10,1,1,1,1}));
        System.out.println(findIt(new int[]{5,4,3,2,1,5,4,3,2,10,10}));
    }

    public static int findIt(int[] a) {
        Map<Integer, Long> b = Arrays.stream(a)
            .mapToObj(Integer::valueOf)
            .collect(Collectors.groupingBy(n-> n, Collectors.counting()));
        return b.entrySet().stream()
                   .filter(e-> e.getValue() % 2 == 1)
                   .findFirst()
                   .get()
                   .getKey();
    }
}
