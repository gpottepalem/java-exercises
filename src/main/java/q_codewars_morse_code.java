import java.util.stream.Collectors;

class Scratch {
    public static void main(String[] args) {
        System.out.println(decode("AB"));
    }

    public static String decode(String morseCode) {
        return morseCode.chars()
            .mapToObj(i-> (char)i)
            .map(Scratch::morseCode)
            .collect(Collectors.joining(""));
    }

    public static String morseCode(Character c) {
        return switch (c) {
            case 'A' -> ".-";
            case 'B' -> "-...";
            case 'C' -> "-.-.";
            case 'D' -> "-..";
            case 'E' -> ".";
            case 'F' -> "..-.";
            case 'G' -> "--.";
            case 'H' -> "....";
            case 'I' -> "..";
            case 'J' -> ".---";
            case 'K' -> "-.-";
            case 'L' -> ".-..";
            case 'M' -> "--";
            case 'N' -> "-.";
            case 'O' -> "---";
            case 'P' -> ".--.";
            case 'Q' -> "--.-";
            case 'R' -> ".-.";
            case 'S' -> "...-";
            case 'T' -> "-";
            case 'U' -> "..-";
            case 'V' -> "...-";
            case 'W' -> ".--";
            case 'X' -> "-..-";
            case 'Y' -> "-.--";
            case 'Z' -> "--..";

            case '1' -> ".----";
            case '2' -> "..---";
            case '3' -> "...--";
            case '4' -> "....-";
            case '5' -> ".....";
            case '6' -> "-....";
            case '7' -> "--...";
            case '8' -> "---..";
            case '9' -> "----.";
            case '0' -> "-----";
            default -> throw new IllegalArgumentException("");
        };
    }
}