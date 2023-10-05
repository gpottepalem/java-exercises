import java.math.BigDecimal;
import java.util.List;

/**
 * List of prices.
 * Apply the discount of 10% when the price is > 20
 * Compute the total of discounted prices.
 */
class Scratch {
    public static void main(String[] args) {

        List<Double> pricesDouble = List.of(10.0, 20.0, 30.0, 40.0, 50.0, 60.0);
        
        List<BigDecimal> pricesBigDecimal = List.of(
            BigDecimal.valueOf(10),
            BigDecimal.valueOf(20),
            BigDecimal.valueOf(30), // discount
            BigDecimal.valueOf(40), // discount
            BigDecimal.valueOf(50), // discount
            BigDecimal.valueOf(60)  // discount
            // total eligible for discount: 180, 10% discount 18, sum of discounted prices: 162
        );

        // Traditional
        BigDecimal totalOfDiscountedPricesTraditional = BigDecimal.ZERO; // 10%
        for(BigDecimal price : pricesBigDecimal) {
            if(price.compareTo(BigDecimal.valueOf(20)) > 0) {
                totalOfDiscountedPricesTraditional = totalOfDiscountedPricesTraditional.add(price.multiply(BigDecimal.valueOf(0.9)));
            }
        }
        System.out.println("Total of discounted prices: " + totalOfDiscountedPricesTraditional);

        // Streams reduce
        final BigDecimal totalOfDiscountedPrices =
            pricesBigDecimal.stream()
                .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
        
        // Streams sum
        Double totalOfDiscountedPrices1 =
            pricesBigDecimal.stream()
                .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                .mapToDouble(p -> p.doubleValue())
                .sum();

        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices1);

        Double totalOfDiscountedPrices2 =
            pricesDouble.stream()
                .filter(price -> price.compareTo(20.0) > 0)
                .map(price -> price * .90)
                .mapToDouble(p -> p.doubleValue())
                .sum();
        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices2);
    }

}