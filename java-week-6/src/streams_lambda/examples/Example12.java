package streams_lambda.examples;

import java.util.List;
import java.util.function.Supplier;

/*
 * Example 12: Closures
 *
 * A lambda can use variables that were declared
 * outside of the lambda.
 *
 * We say that the lambda "captures" the variable.
 *
 * The captured local variable must be final
 * or effectively final.
 */
public class Example12 {

    public static void main(String[] args) {

        int aValue = 10;

        /*
         * 1. Anonymous class
         *
         * The anonymous class can access aValue
         * from the surrounding method.
         */
        Supplier<Double> randomNumber1 = new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random() * aValue;
            }
        };


        /*
         * 2. Local class
         *
         * A class declared inside a method can also
         * access aValue.
         */
        class RandomSupplier implements Supplier<Double> {

            @Override
            public Double get() {
                return Math.random() * aValue;
            }
        }

        Supplier<Double> randomNumber2 = new RandomSupplier();


        /*
         * 3. Lambda
         *
         * The lambda captures aValue from
         * the surrounding scope.
         *
         * This is the most common closure-style example.
         */
        Supplier<Double> randomNumber3 =
                () -> Math.random() * aValue;


        System.out.println(randomNumber1.get());
        System.out.println(randomNumber2.get());
        System.out.println(randomNumber3.get());


        /*
         * Why is this called a closure?
         *
         * The lambda contains:
         *
         *      () -> Math.random() * aValue
         *
         * aValue is NOT declared inside the lambda.
         *
         * But the lambda can still use it because
         * it captures the value from its surrounding scope.
         */


        // -----------------------------------------
        // Effectively final
        // -----------------------------------------

        /*
         * aValue is not declared final:
         *
         *      int aValue = 10;
         *
         * But we never change it.
         *
         * Therefore Java considers it:
         *
         *      effectively final
         */


        /*
         * If we try to change aValue:
         */

        // aValue = 20;

        /*
         * then the lambdas/classes above would no longer compile.
         *
         * Java would give an error similar to:
         *
         * "Variable used in lambda expression should be final
         *  or effectively final"
         */


        // -----------------------------------------
        // Another simple closure example
        // -----------------------------------------

        int multiplier = 10;

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        numbers.stream()
                .map(n -> n * multiplier)
                .forEach(System.out::println);

        /*
         * Here the lambda:
         *
         *      n -> n * multiplier
         *
         * has two kinds of variables:
         *
         * n
         *      -> lambda parameter
         *
         * multiplier
         *      -> variable from the surrounding scope
         *      -> captured variable
         */


        // -----------------------------------------
        // The captured value can still be used later
        // -----------------------------------------

        Supplier<Integer> multiplySomething =
                () -> 5 * multiplier;

        System.out.println(multiplySomething.get()); // 50


        /*
         * Important:
         *
         * Java does NOT allow:
         *
         * multiplier++;
         *
         * inside the lambda.
         */

        // Supplier<Integer> wrong = () -> multiplier++;

        /*
         * because multiplier is a captured local variable
         * and captured local variables must remain
         * effectively final.
         */


        // -----------------------------------------
        // But object contents can change
        // -----------------------------------------

        StringBuilder text = new StringBuilder("Hello");

        Runnable changeText = () -> text.append(" World");

        changeText.run();

        System.out.println(text); // Hello World

        /*
         * This is allowed.
         *
         * The variable "text" still points to the same object.
         * We did not assign a new object to text.
         *
         * We changed the CONTENT of the object.
         */


        /*
         * This would NOT be allowed:
         *
         * text = new StringBuilder("Something else");
         *
         * because then text would no longer be effectively final.
         */


        // -----------------------------------------
        // Main idea
        // -----------------------------------------

        /*
         * Lambda parameter:
         *
         *      n -> n * multiplier
         *      ^
         *      declared inside lambda
         *
         *
         * Captured variable:
         *
         *      n -> n * multiplier
         *               ^
         *               comes from surrounding scope
         *
         *
         * A lambda that captures variables from its
         * surrounding scope is commonly described
         * as a closure.
         */
    }
}
