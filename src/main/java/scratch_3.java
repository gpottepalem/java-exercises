
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

class Scratch {
    public static void main(String[] args) {
        List<Integer> itemsToScore = List.of(1,2,3,4,5,6,7,8,9,10);

        var  itemsToScoreMap = itemsToScore.stream()
            .collect(
                Collectors.toMap(
                    itemToScore -> itemToScore + "-",
                    itemToScore -> itemToScore
                )
            );
        System.out.println(itemsToScoreMap);

        var  itemsToScoreMapOrderPreserved = itemsToScore.stream()
            .collect(
                Collectors.toMap(
                    itemToScore -> itemToScore + "-",
                    itemToScore -> itemToScore,
                    (key1, key2) -> key1,
                    LinkedHashMap::new
                )
            );

        System.out.println("Ordered list:" + itemsToScore);
        var itemIdsToScore = itemsToScoreMap.keySet().stream().toList();
        System.out.println("Order not preserved:" + itemIdsToScore);

        var itemIdsToScoreOrderPreserved = itemsToScoreMapOrderPreserved.keySet().stream().toList();
        System.out.println("Order preserved:" + itemIdsToScoreOrderPreserved);
    }
}