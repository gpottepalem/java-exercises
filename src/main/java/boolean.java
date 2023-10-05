class Scratch {
    // Avoid NPE when Boolean object type is used in expression to determine the conditional flow
    public static void main(String[] args) {
        Boolean ok = null;
        System.out.println(ok instanceof Boolean); // null is not Boolean
        System.out.println(new Object().getClass().getSuperclass()); // null
        try {
            if (ok) { // throws NPE
                System.out.println("I am ok!");
            }
        } catch(NullPointerException npe) {
            System.out.println("I told ya!");
        }

        if(Boolean.TRUE.equals(ok)) {
            System.out.println("I am ok :" + ok);
        } else {
            System.out.println("I am not ok :" + ok);
        }

        System.out.println("ok:" + ok + " Boolean.FALSE.equals(ok):" + Boolean.FALSE.equals(ok));
        ok = true;
        System.out.println("ok:" + ok + " Boolean.FALSE.equals(ok):" + Boolean.FALSE.equals(ok));
        System.out.println("ok:" + ok + " Boolean.TRUE.equals(ok):" + Boolean.TRUE.equals(ok));
    }
}