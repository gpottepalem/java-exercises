import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

class Scratch {

    public static int getRandomInt(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static double roundToSpecifiedNumberOfDecimalPlaces(double doubleValue, int roundDecimalsTo) {
        return (roundDecimalsTo < 0) ?
                   doubleValue :
                   BigDecimal.valueOf(doubleValue)
                       .setScale(roundDecimalsTo, RoundingMode.HALF_UP).doubleValue(); // round to n decimals
    }

    public static double randomDouble(double min, double max, int roundDecimalsTo) {
        double randomDouble = min + (Math.random() * (max - min));
        return roundToSpecifiedNumberOfDecimalPlaces(randomDouble, roundDecimalsTo);
    }
    
    public static void main(String[] args) {
        System.out.println(Math.random()); // double value >= 0.0 < 1.0
        Random random = new Random();
        System.out.println(random.nextDouble());

        System.out.println("random int (-10..10): " + getRandomInt(-10, 10));
        System.out.println("random double (-6.0..6.0) not rounded: " + randomDouble(-6.0, 6.0, -1));
        System.out.println("random double (-6.0..6.0) rounded 0 decimal: " + randomDouble(-6.0, 6.0, 0));
        System.out.println("random double (-6.0..6.0) rounded 1 decimal: " + randomDouble(-6.0, 6.0, 1));
        System.out.println("random double (-6.0..6.0) rounded 2 decimal: " + randomDouble(-6.0, 6.0, 2));
        System.out.println("random double (-6.0..6.0) rounded 3 decimal: " + randomDouble(-6.0, 6.0, 2));
        System.out.println("random double (-6.0..6.0) rounded 4 decimal: " + randomDouble(-6.0, 6.0, 4));
    }
}