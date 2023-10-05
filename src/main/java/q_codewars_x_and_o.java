/**
 * Check to see if a string has the same amount of 'x's and 'o's. The method must return a boolean and be case insensitive.
 * The string can contain any char.
 *
 * Examples input/output:
 *
 * XO("ooxx") => true
 * XO("xooxx") => false
 * XO("ooxXm") => true
 * XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
 * XO("zzoo") => false
 */
class Scratch {
    public static void main(String[] args) {
        System.out.println(getXO("ooxx"));
        System.out.println(getXO("xooxx"));
        System.out.println(getXO("ooxXm"));
        System.out.println(getXO("zpzpzpp"));
        System.out.println(getXO("zzoo"));
    }

    public static boolean getXO (String str) {
        var xCount = str.chars()
            .mapToObj(c-> (char)c)
            .map(Character::toLowerCase)
            .filter(c-> c == 'x')
            .count();

        var oCount = str.chars()
                         .mapToObj(c-> (char)c)
                         .map(Character::toLowerCase)
                         .filter(c-> c == 'o')
                         .count();
        return xCount == oCount;
    }
}