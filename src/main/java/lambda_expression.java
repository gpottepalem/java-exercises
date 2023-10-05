import java.util.function.BiFunction;
import java.util.function.Function;

class Scratch {

    public static void main(String[] args) {
        Function mrPrefix = (s) ->  "Mr. " + s;
        Function jrSuffix = (s) ->  s + " Jr.";
        BiFunction sumUp = (i, j) -> (Integer)i + (Integer)j;

        System.out.println(mrPrefix.apply("Giri"));
        System.out.println(jrSuffix.apply("Giri"));
        System.out.println(sumUp.apply(10, 20));
    }
}

