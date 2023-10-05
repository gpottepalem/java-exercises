import java.util.stream.IntStream;

class Scratch {

    private static void printElement(int n) {
        if (n == 6) {
            throw new IllegalArgumentException("Don't like to print: " + n);
        }
        System.out.println(n);
    }

    public static void main(String[] args) {
        var numbers = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8);
        numbers
            .filter(n-> n % 2 == 0)
            //.forEach(Scratch::printElement)
            .forEach(n-> {
                if (n == 2) {
                    throw new IllegalArgumentException("Don't want to print: " + n);
                }
                Scratch.printElement(n);
            });
    }


}