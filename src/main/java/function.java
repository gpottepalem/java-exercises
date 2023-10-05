import java.util.function.Function;

class Scratch {
    static Object convert(CharSequence charSequence, Class klas) {
        return switch (klas) {
            case Long.TYPE -> Long.parseLong(charSequence.toString());
            default -> throw new IllegalArgumentException("Not supported");
        };
    }

    public static void main(String[] args) {

        Function<CharSequence, String> charSequenceToString = charSeq -> (charSeq != null) ? charSeq.toString() : null;
//        BiFunction<CharSequence, Object, Object> charSequenceToObject = (charSeq, object) -> {
//            return switch(object) {
//                case Long l -> (charSeq != null) ? Long.parseLong(charSeq.toString()) : null;
//                case String s -> (charSeq != null) ? charSeq.toString() : null;
//            };
//        };
        Class a = Long.TYPE;
        System.out.println("klas:" + a.equals(Long.TYPE));
        System.out.println(charSequenceToString.apply("Test"));
        System.out.println(convert("123", Long.TYPE));
    }
}
