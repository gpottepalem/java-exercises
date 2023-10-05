import java.math.BigDecimal;

class Scratch {
    public static void main(String[] args) {
        String ver = "5.0.0";
        String ver_ = "5-0-0";
        System.out.println(ver_.split("-")[0]);
        System.out.println(ver.split("\\.")[0]);
        System.out.println("5.0.0".replaceAll("\\.", ""));
        System.out.println("5.0.1".replaceAll("\\.", ""));
        System.out.println(Integer.valueOf("5.0.1".replaceAll("\\.", "")));

        System.out.println("new Double(0.1) Deprecated= " + new Double(0.1));
        System.out.println("Double.valueOf(0.1) = " + Double.valueOf(0.1));
        System.out.println("Double.valueOf(0.0123456789) = " + Double.valueOf(0.0123456789));
        System.out.println("0.01 = " + 0.01);

        System.out.println("\n");
        System.out.println("new BigDecimal(0.01)     = " + new BigDecimal(0.01));
        System.out.println("new BigDecimal(1.89)     = " + new BigDecimal(1.89));
        System.out.println("new BigDecimal(1496.88)     = " + new BigDecimal(1496.88));
        System.out.println("new BigDecimal(\"0.01\")   = " + new BigDecimal("0.01"));
        System.out.println("BigDecimal.valueOf(0.01) = " + BigDecimal.valueOf(0.01));
        System.out.println("BigDecimal.valueOf(1.89) = " + BigDecimal.valueOf(1.89));
        System.out.println("BigDecimal.valueOf(1496.88) = " + BigDecimal.valueOf(1496.88));
    }
}