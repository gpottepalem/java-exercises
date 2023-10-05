class Scratch {
    public static void main(String[] args) {
        // check if primitive literal is long or not based on value
        var notLong = 10 * 100;
        var isLong = 10 * 100L;
        System.out.println( "isLong?: NO - " + ((Object)notLong).getClass().getName());
        System.out.println( "isLong?: YES - " + ((Object)isLong).getClass().getName());
        System.out.println("");

        var notFloat = 1.0;
        var isFloat = 1.0F;
        System.out.println( "isFloat?: NO - " + ((Object)notFloat).getClass().getName());
        System.out.println( "isFloat?: YES - " + ((Object)isFloat).getClass().getName());
    }
    
}