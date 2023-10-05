import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Scratch {
    static void iTakeObjectList(List<Object> objects) {
        System.out.println("No. of objects I got: " + objects.size());
    }

    static void iTakeList(List objects) {
        System.out.println("No. of objects I got: " + objects.size());
    }

    public static void main(String[] args) {
        // unmodifiable list
        System.out.println("\nCase-1\n------");
        var unModifiableList = List.of("A", "B", "C");
        System.out.println("List.of() - unModifiableList: " + unModifiableList);

        try {
            unModifiableList.add("D");
        } catch(UnsupportedOperationException ex) {
            System.out.print("List.of()...I didn't tell you. Sorry you cannot add, ");
        }

        try {
            unModifiableList.remove("D");
        } catch(UnsupportedOperationException ex) {
            System.out.print("remove, ");
        }

        try {
            unModifiableList.set(0, "AA");
        } catch(UnsupportedOperationException ex) {
            System.out.println("or modify elements in the list.");
        }
        
        // unmodifiable list
        System.out.println("\nCase-2\n------");
        unModifiableList = Stream.of("A", "B", "C").toList();
        System.out.println("Stream.of() - unModifiableList: " + unModifiableList);

        try {
            unModifiableList.add("D");
        } catch(UnsupportedOperationException ex) {
            System.out.print("Stream.of()...I didn't tell you. Sorry you cannot add, ");
        }

        try {
            unModifiableList.remove("D");
        } catch(UnsupportedOperationException ex) {
            System.out.print("remove, ");
        }

        try {
            unModifiableList.set(0, "AA");
        } catch(UnsupportedOperationException ex) {
            System.out.println("or modify elements in the list.");
        }
        
        // fixed size list, backed by array, changes are reflected in both
        System.out.println("\nCase-3\n------");
        var array = new String[] {"A", "B", "C"};
        var fixedList = Arrays.asList(array);
        System.out.println("Arrays.asList() - fixedList: " + fixedList);

        fixedList.set(0, "AA");

        try {
            fixedList.add("D");
        } catch(UnsupportedOperationException ex) {
            System.out.print("Arrays.asList()...I also didn't tell you. Sorry you cannot add, ");
        }
        try {
            fixedList.remove(0);
        } catch(UnsupportedOperationException ex) {
            System.out.println("remove any elements in the list. ");
        }
        fixedList.set(0, "AA");
        System.out.printf("Arrays.asList()...But you can modify elements in the list: %s. When you modify the backed array is also moddified: [%s]",
            fixedList,
            Arrays.stream(array).collect(Collectors.joining(",")));
        System.out.println();
        fixedList.set(0, "A"); // modify it back
        List<String> stringNames = List.of("A", "B", "C");
        // compiler unhappy
//        iTakeObjectList(stringNames); // incompatible types: java.util.List<java.lang.String> cannot be converted to java.util.List<java.lang.Object>
        iTakeList(stringNames);

        List names = List.of("A", "B", "C");
        iTakeObjectList(names); // compiler happy

        // Stream.concat creates unmodifiable list from unmodifiable lists
        System.out.println("\nCase-4\n------");
        final List finalList = Stream.concat(unModifiableList.stream(), unModifiableList.stream()).toList();
        System.out.println("Stream.concat() final list created by concatenating unmodifiable lists: " + finalList);
        try {
            finalList.add("X");
        } catch(UnsupportedOperationException ex) {
            System.out.print("Stream.concat()...I didn't tell you. Sorry you cannot add, ");
        }
        try {
            finalList.remove("A");
        } catch(UnsupportedOperationException ex) {
            System.out.print("remove, ");
        }

        try {
            unModifiableList.set(0, "AA");
        } catch(UnsupportedOperationException ex) {
            System.out.println("or modify elements in the list.");
        }

        // Stream.concat creates keeps unmodifiable list
        System.out.println("\nCase-5\n------");
        final List finalModifiableList = Stream.concat(unModifiableList.stream(), fixedList.stream()).toList();
        System.out.println("Stream.concat() unmodifiable final list: " + finalList);

        try {
            finalModifiableList.add("D");
        } catch(UnsupportedOperationException ex) {
            System.out.print("Stream.concat()...I didn't tell you. Sorry you cannot add, ");
        }
        System.out.println(finalModifiableList);

        try {
            finalModifiableList.set(4, "AA");
        } catch(UnsupportedOperationException ex) {
            System.out.print("Stream.concat()...I didn't tell you. Sorry you cannot add, ");
        }

        System.out.println(finalModifiableList);
    }
}
