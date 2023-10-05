import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

class Scratch {
    public static void main(String[] args) {
        System.out.println(createPhoneNumber(new int[]{1,2,3,4,5,6,7,8,9,0}));
        System.out.println(createPhoneNumber(new int[]{5,0,8,8,4,6,6,9,3,7}));
        System.out.println(createPhoneNumber(new int[]{1,2,3,4,5,6,7,8,9,10,11}));
    }

    public static String createPhoneNumber(int[] numbers) {
        IntPredicate isSingleDigit = n -> (n >= 0 && n <=9);
        if (numbers.length != 10 && !Arrays.stream(numbers).allMatch(n-> isSingleDigit.test(n))) {
            throw new IllegalArgumentException("Please provide an array with 10 single digits between 0..9");
        }
        return String.format(
            "%s%s%s",
            String.format("(%s)", getDigits(numbers, 0, 3)),
            String.format(" %s", getDigits(numbers, 3, 6)),
            String.format("-%s", getDigits(numbers, 6, 10))
        );
    }

    private static String getDigits(int[] digits, int from, int to) {
        return Arrays.stream(digits)
                   .skip(from)
                   .limit(to - from)
                   .mapToObj(n-> Integer.valueOf(n).toString())
                   .collect(Collectors.joining(""));
    }
}