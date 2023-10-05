import java.math.BigDecimal;
import java.math.RoundingMode;

class Scratch {
    public static void main(String[] args) {
        BigDecimal big = BigDecimal.valueOf(10.1279);
        System.out.println(big);
        big = big.setScale(2, RoundingMode.HALF_UP);
        System.out.println(big);
        big = BigDecimal.valueOf(4.379);
        System.out.println(big);
    }
}