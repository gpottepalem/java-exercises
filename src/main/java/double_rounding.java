import java.math.BigDecimal;
import java.math.RoundingMode;

class Scratch {
    public static void main(String[] args) {
        double b1 = - 1.8497 / 0.6606;
        double b2 = (- 1.9015 / 0.6606) - b1;
        System.out.println(b1);
        System.out.println(b2);
        System.out.println( getDoubleValue(b1));
        System.out.println( getDoubleValue(b2));
        System.out.println( getDoubleValue(0));

        System.out.println( toDouble("0.1234"));
        try {
            System.out.println(toDouble(null));
        } catch(NullPointerException npe) {
            System.out.println("NPE");
        }
    }

    private static double getDoubleValue(double score) {
        return new BigDecimal(Double.toString(score))
            .setScale(4, RoundingMode.HALF_UP)
            .doubleValue();
    }

    private static Double toDouble(String doubleStr) {
        return Double.parseDouble(doubleStr);
    }
}