import java.util.Map;

class Scratch {
    public static void main(String[] args) {
        Map immutableMax10 = Map.of(
            "a", 1,
            "b", 2,
            "c", 3,
            "d", 4,
            "e", 5,
            "f", 6,
            "g", 7,
            "h", 8,
            "i", 9,
            "j", 10
        );
        System.out.println("I won't tell you it's immutable from the method signature. You need to examine me: " + immutableMax10.getClass().getName());
        try {
            immutableMax10.put("j", 11);
            System.out.println(immutableMax10);
        } catch (UnsupportedOperationException ex) {
            System.out.println("I am immutable. Wouldn't let you ADD any more element(s), won't tell you anything specific in the exception I throw when you try to do it: " + ex.getMessage());
        }
        try {
            immutableMax10.replace("i", 10);
            System.out.println(immutableMax10);
        } catch (UnsupportedOperationException ex) {
            System.out.println("I am immutable. Wouldn't let you MODIFY any element, won't tell you anything specific in the exception I throw when you try to do it: " + ex.getMessage());
        }
        try {
            immutableMax10.remove("even-non-existing");
            System.out.println(immutableMax10);
        } catch (UnsupportedOperationException ex) {
            System.out.println("I am immutable. Wouldn't let you even try to REMOVE any element, won't tell you anything specific in the exception I throw when you try to do it: " + ex.getMessage());
        }
    }
}
