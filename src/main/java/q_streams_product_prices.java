//import lombok.AllArgsConstructor;
//import lombok.Data;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Given a list of Products with name, price find the product(s) with higest price.
 */
class Scratch {
    public static void main(String[] args) {
        record Product(String name, Integer price){};

        List<Product> products = List.of(
            new Product("iPhone", 1000),
            new Product("iPad", 500),
            new Product("iPod", 200),
            new Product("AirPod", 400),
            new Product("AppleWatch", 300),
            new Product("MacBook", 1000)
        );

//        List<StudentClass> studentScores1 = List.of(
//            new StudentClass("Glen", 95),
//            new StudentClass("Mike", 90),
//            new StudentClass("Dave", 80),
//            new StudentClass("Mark", 90),
//            new StudentClass("Greg", 95)
//        );
        // Declarative Functional way, focus on what, find the highest scored students
        Map<Integer, List<String>> productsGroupdByPrice = products.stream()
            .sorted(Comparator.comparing(Product::price).reversed())
            .collect(Collectors.groupingBy(
                Product::price,
                LinkedHashMap::new, // preserve order
                Collectors.mapping(Product::name, Collectors.toList())));

        System.out.println(productsGroupdByPrice);

        Optional<Integer> firstKey = productsGroupdByPrice.keySet().stream().findFirst();
        if (firstKey.isPresent()) {
            System.out.println(productsGroupdByPrice.get(firstKey.get()));
        }
    }
}

//@Data
//@AllArgsConstructor
//class StudentClass {
//    private String name;
//    private Integer score;
//}
