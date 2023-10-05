import java.util.List;
import java.util.Locale;

/**
 * Lambda is nothing but anonymous function, a function with NO name.
 * In Java, we are used to passing instances of anonymous classes.
 * Classes with one method now don't need to go through ceremony of instantiating, instead enjoy light-weight
 * lambda syntax.
 * Lambda functions have been incorporated in Java 8 to provide preliminary support for functional programming.
 * They are primarily used to implement the abstract function of a functional interface.
 * A functional interface is a class with one, and only one, abstract function.
 * Can send lambda expressions or method references where functional interfaces (an interface with
 * one unimplemented method) are expected.
 * We can assign lambda expressions to variables and reuse them, just like with objects.
 * Syntax:
 *   parameter -> expression;
 *   (parameter1, parameter2) -> expression;
 *   (parameter1, parameter2) -> { code block }
 *
 *   (arguments separated by comma) -> { function body }
 *   () - optional if 1 arg
 *   {} - optional if there is only statement
 *   Explicit argument types are optional, can be inferred. When explicit type is used, even single arg should be
 *     enclosed in (), only optional for single non-explicit-type arg.
 */
class Scratch {
    public static void main(String[] args) {
        System.out.println("Thread: " + Thread.currentThread().getName());

        Runnable runnableAnonymousClass = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread: " + Thread.currentThread().getName() +
                                   " Class: " + this.getClass().getName() +
                                   " I am a runnable anonymous class"
                );
            }
        };

        Runnable runnableLambda = () -> System.out.println(
            "Thread: " + Thread.currentThread().getName() + " I am a runnable lambda"
//            + "Class: " + this.getClass().getName()

        );

        runnableAnonymousClass.run(); // call run in the same thread
        runnableLambda.run(); // call run in the same thread

        new Thread(runnableAnonymousClass).start(); // start a new thread
        new Thread(runnableLambda).start(); // start a new thread

        singleArgumentSingleStatementLambda();
        functionalInterface();
    }

    static void singleArgumentSingleStatementLambda() {
        System.out.println("\nsingleArgumentSingleStatementLambda\n-----------------------------------");
        List<String> names = List.of("giri", "jaya", "bhuvan", "kk", "rthivik");
        names.forEach(name -> System.out.println(name.toUpperCase(Locale.ROOT))); // single arg, single statement lambda
        names.forEach((String name) -> System.out.println(name.toUpperCase(Locale.ROOT))); // single arg, explicit type, single statement lambda
    }

    static void functionalInterface() {
        System.out.println("\nFunctional Interface\n--------------------");
        @FunctionalInterface
        interface StringFunction {
            // abstract method that takes a String and returns a String
            String apply(String str);
        }

        StringFunction greet = (s) -> "Hi " + s;
        StringFunction bye = (s) -> "Bye " + s + "!";
        StringFunction capitalize = (s) -> s.substring(0, 1).toUpperCase() + s.substring(1, s.length()).toLowerCase();

        System.out.println(greet.apply("giri"));
        System.out.println(bye.apply("giri"));
        System.out.println(capitalize.apply("giri"));
    }
}
