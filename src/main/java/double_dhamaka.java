import java.math.BigDecimal;

class Scratch {
    public static void main(String[] args) {
        float f = 2.2551f;
        double f1 = f;
        System.out.println(f);
        System.out.println(f1);

        /**
         * https://docs.oracle.com/javase/7/docs/api/java/math/BigDecimal.html#BigDecimal%28double%29
         */
        double d = 0.1;
        Double D = 0.1;
        // BigDecimal constructor that takes double is unpredictable
        System.out.println(new BigDecimal(d)); // Unpredictable, Non-compliant, 0.1000000000000000055511151231257827021181583404541015625
        System.out.println(new BigDecimal(D)); // Unpredictable, Non-compliant, 0.1000000000000000055511151231257827021181583404541015625
        System.out.println(new BigDecimal(D).toPlainString()); // Unpredictable, Non-compliant, 0.1000000000000000055511151231257827021181583404541015625

        System.out.println(BigDecimal.valueOf(d)); // Predictable, Compliant, 0.1
        System.out.println(BigDecimal.valueOf(D)); // Predictable, Compliant, 0.1

        // String constructor is predictable
        System.out.println(new BigDecimal("0.1")); // Compliant, 0.1
        System.out.println(new BigDecimal(D.toString())); // Compliant, 0.1

        d = 0.1234;
        System.out.println(new BigDecimal(d)); // 0.12339999999999999580335696691690827719867229461669921875
        d = -0.9821;
        System.out.println(new BigDecimal(d)); // -0.98209999999999997299937604111619293689727783203125
        d = 22.371444604883134;
        System.out.println(new BigDecimal(d));

        d = -3.0000181;
        System.out.println(d);
        System.out.println(new BigDecimal(d)); //-3.0000181000000001318994691246189177036285400390625
        System.out.println(BigDecimal.valueOf(d)); // -3.0000181
    }
}