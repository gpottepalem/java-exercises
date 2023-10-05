class Scratch {
    enum Day {
        MON, TUE, WED, THU, FRI, SAT, SUN
    };

    enum DayType {
        WEEKDAY, WEEKEND
    };

    public static DayType typeOfDay(Day day) {
        return switch(day) {
            case MON ,TUE, WED, THU, FRI -> DayType.WEEKDAY;
            case SAT, SUN -> DayType.WEEKEND;
        };
    }

    static boolean test(int val) {
        return switch(val) {
            case 1, 2, 3, 4 -> true;
            case 5, 6 -> false;
            default -> false;
        };
    }

    public static void main(String[] args) {
        System.out.println(typeOfDay(Day.MON));
        System.out.println(typeOfDay(Day.SAT));

        var val = 5;
        System.out.println(test(val));
        
    }

}