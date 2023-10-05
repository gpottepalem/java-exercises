import java.util.HashMap;
import java.util.Map;

class Scratch {
    static class Test {
        public Map<String, String> getNames() {
            return names;
        }

        public void setNames(Map<String, String> names) {
            this.names = names;
        }

        Map<String, String> names = new HashMap<>();

    }

    public static void main(String[] args) {
        Test t = new Test();
        t.getNames().put("1", "Abc");
        t.getNames().put("2", "Xyz");
        var what = t.getNames().put("3", "zzz");
        System.out.println(t.getNames());
        System.out.println(what);
    }
}