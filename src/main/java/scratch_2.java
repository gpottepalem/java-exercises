import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

class Scratch {
    static BiFunction<String, String, String> stripProgramPrefix = (var input, var program) ->
        input.contains(program + "_") ? input.replaceFirst(program + "_", "") : input;
    static Function<String, String> stripSuffix = (var input) ->
        input.substring(
            0, input.indexOf("_") == -1 ? input.length() : input.indexOf("_")
        );

    static BiFunction<String, String, String> stripProgramPrefixAndSuffix = (var input, var program) -> {
        var inputStrippedPrefix = input.contains(program + "_") ? input.replaceFirst(program + "_", "") : input;
        return inputStrippedPrefix.contains("_") ?
            inputStrippedPrefix.substring(0, inputStrippedPrefix.indexOf("_")) :
            inputStrippedPrefix;
    };

    public static void main(String[] args) {
        List<String> l = List.of("FLA_123_1", "FLA_234_1", "345", "FLA_456", "FLA_567_1234", "678_1");
        var ll = l.stream()
            .map(item -> stripProgramPrefix.apply(item, "FLA"))
            .map(stripSuffix::apply)
            .toList();

        System.out.println(l);
        System.out.println(ll);

        var lll = l.stream()
            .collect(Collectors.toMap(item-> stripProgramPrefixAndSuffix.apply(item, "FLA"), item-> item));
//            .map(item -> stripProgramPrefix.apply(item, "FLA_"))
//            .map(stripSuffix::apply)
//            .toList();
        System.out.println(lll);
    }
}