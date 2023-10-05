class Scratch {
    public static void main(String[] args) {
        // String format platform specific way to add new line : %n instead of \n
        System.out.print(String.format("Line1%nand Line2%n"));
        System.out.format("%d%n", 1);
        System.out.println("last line");

        System.out.println(allUpper("Giri"));
        System.out.println(allLower("giri"));
    }

    static boolean allUpper(String word) {
        return word.chars().noneMatch(Character::isLowerCase);
    }

    static boolean allLower(String word) {
        return word.chars().noneMatch(Character::isUpperCase);
    }
}
