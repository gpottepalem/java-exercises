class Scratch {
    public static void main(String[] args) {
        try{
            test(2);
        } catch(IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    static void test(Integer a) throws IllegalArgumentException, IllegalAccessException {
        //
    }
}