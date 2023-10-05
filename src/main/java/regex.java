import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://devqa.io/extract-numbers-string-java-regular-expressions/
class Scratch {
    public static void main(String[] args) {

        // extract all numbers from string
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher("string1234more567string890");
        while(matcher.find()) {
            System.out.println(matcher.group());
        }

        // extract nth digit from a string
        pattern = Pattern.compile("[^\\d]*[\\d]+[^\\d]+([\\d]+)");
        matcher = pattern.matcher("string1234more567string890");

        // if an occurrence if a pattern was found in a given string...
        if (matcher.find()) {
            System.out.println(matcher.group(1)); // second matched digits
        }

        // extract number from a tag attribute
        pattern = Pattern.compile("numFound=\"([0-9]+)\"");
        matcher = pattern.matcher("");

        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }

        // extract a string containing digits and characters
        pattern = Pattern.compile("YOUR SET ADDRESS IS\\s+([A-Z0-9]{6})");
        matcher = pattern.matcher("YOUR SET ADDRESS IS 6B1BC0 TEXT");
        if (matcher.find()) {
            System.out.println(matcher.group(1)); // Prints 123456
        }

        // extract key value pairs
        String s = "bookname=cooking&bookid=123456&bookprice=123.45";
        Pattern p = Pattern.compile("(?<=bookid=)\\d+");
        Matcher m = p.matcher(s);
        if (m.find()) {
            System.out.println(m.group());
        }

        String str = "test test test test me me  me me";
        System.out.println(str.replaceAll("me", "ME"));
        System.out.println(str.replace("test", "TEST"));

        str = "1.2.3.";
        System.out.println(str.replaceAll("\\.", "")); // regex way
        System.out.println(str.replace(".", "")); // simpler way

        System.out.println(addExtraImageAttributes("<img alt=\"giri\">giri.jpg</img>blah blah<img alt=\"boo\">boo.jpg</img>"));
    }

    /**
     * Adds extra attributes width="100%" height="auto" to the given label if img tag(s) are found.
     * @return modified label with extra attributes added to img tag
     */
    public static String addExtraImageAttributes(String label) {
        // Gotcha
        // if the first arg is not a real regular expression, replace and replaceAll both do the same.
        // for real regular expression to replaceAll, use replaceAll
//        return label.replaceAll("<img", "<img width=\"100%\" height=\"auto\"");
        return label.replace("<img", "<img width=\"100%\" height=\"auto\"");
    }
}