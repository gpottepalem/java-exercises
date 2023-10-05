import java.util.Arrays;

class Scratch {
    static void extractLinesAndPrint(String multiLineTextBlock, int variant) {
        System.out.printf("Multiline Text Block - Variant %d: \n", variant);
        System.out.printf(multiLineTextBlock);
        System.out.println("Extracted Lines");
        var lines = multiLineTextBlock.split("\n");
        var streamOfLines = Arrays.stream(lines);
        streamOfLines.forEach(System.out::println);
    }

    public static void main(String[] args) {
        String multiLineTextBlock = """
            Line1
            Line2
            Line3
        """;
        extractLinesAndPrint(multiLineTextBlock, 1);

        multiLineTextBlock = """
            Line1
            Line2
            Line3
            """;
        extractLinesAndPrint(multiLineTextBlock, 2);

        multiLineTextBlock = """
            Line1
            Line2
            Line3
           """;
        extractLinesAndPrint(multiLineTextBlock, 3);

        multiLineTextBlock = """
            Line1
            Line2
            Line3""";
        extractLinesAndPrint(multiLineTextBlock, 4);

        multiLineTextBlock = """
            Line1    
            Line2
            Line3
        """.stripIndent(); // doesn't do anything
        extractLinesAndPrint(multiLineTextBlock, 5);

        multiLineTextBlock = """
            Line1    
            Line2
            Line3
                 """;
        extractLinesAndPrint(multiLineTextBlock, 6);

        multiLineTextBlock = """
            Line1    
            Line2
            Line3
            """.indent(3);
        extractLinesAndPrint(multiLineTextBlock, 7);

        multiLineTextBlock = """
            Line1    
            Line2
            Line3
            """.indent(3).stripIndent(); // doesn't do anything
        extractLinesAndPrint(multiLineTextBlock, 8);
    }
}