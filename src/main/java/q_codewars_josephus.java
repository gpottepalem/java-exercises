import java.util.List;
import java.util.stream.IntStream;

/**
 * In this kata you have to correctly return who is the "survivor", ie: the last element of a Josephus permutation.
 *
 * Basically you have to assume that n people are put into a circle and that they are eliminated in steps of k elements,
 * like this:
 *
 * n=7, k=3 => means 7 people in a circle
 * one every 3 is eliminated until one remains
 * [1,2,3,4,5,6,7] - initial sequence
 * [1,2,4,5,6,7] => 3 is counted out
 * [1,2,4,5,7] => 6 is counted out
 * [1,4,5,7] => 2 is counted out
 * [1,4,5] => 7 is counted out
 * [1,4] => 5 is counted out
 * [4] => 1 counted out, 4 is the last element - the survivor!
 * The above link about the "base" kata description will give you a more thorough insight about the origin of this kind
 * of permutation, but basically that's all that there is to know to solve this kata.
 *
 * Notes and tips: using the solution to the other kata to check your function may be helpful, but as much larger numbers
 * will be used, using an array/list to compute the number of the survivor may be too slow; you may assume that both n
 * and k will always be >=1.
 */
class Scratch {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 3).map(i -> (3 - (i -1)) * 3).forEach(System.out::println);
        System.out.println(josephusSurvivor(7, 3));
    }

    public static int josephusSurvivor(final int n, final int k) {
        var list = IntStream.rangeClosed(1, n).boxed().toList();//toList();

        while (list.size() > 1) {
            System.out.println(list);
            int times = list.size() / k;
            int reminder = list.size() % k;
            System.out.println("times:" + times);
            if (times > 0) {
                List<Integer> positionsInReverse = IntStream.rangeClosed(1, times)
                                                       .boxed()
                                                       .map(i -> (times - (i - 1)) * k)
                                                       .toList();
                System.out.println("positionsInReverse:" + positionsInReverse);
                positionsInReverse.stream().forEach(i -> list.remove(i.intValue() - reminder));
            } else {
                list.remove(k - list.size() - 1);
            }
            System.out.println(list);
        }
        return list.get(0);
    }
}