import java.util.List;
import java.util.stream.IntStream;

class Scratch {
    public static void main(String[] args) {
        Integer i = 3;
        int a = 3;
        System.out.println(i == a);
        try {
            i = null;
            int ii = i;
            System.out.println(ii);
        } catch(NullPointerException e) {
            System.out.println(e);
        }

        System.out.println(Integer.MIN_VALUE);
        String str = "-2147483648";
        System.out.println( str.equals(Integer.toString(Integer.MIN_VALUE)) ? "NA" : str);
        str = "1000";
        System.out.println( str.equals(Integer.toString(Integer.MIN_VALUE)) ? "NA" : str);

        intRange();
    }

    static void intRange() {
        int firstYear = 1980;
        int thisYear = 2024;
        List<Integer> allYears = IntStream.rangeClosed(firstYear, thisYear).boxed().toList();
        List<Integer> recentTwoYears = allYears.stream().skip(allYears.size() - 2).toList();
//        var count = supportedYears.count();
//        supportedYears.limit(2);
        //var a = supportedYears.boxed().skip(count - (count -2) ).toList();
        System.out.println(allYears);
        System.out.println(recentTwoYears);
    }
}
