/**
 * Example 3: BiFunction
 *
 * BiFunction<T, U, R> is a functional interface that takes two inputs (T, U)
 * and produces one output (R).
 *
 * In this example:
 * - T = Integer
 * - U = Integer
 * - R = Integer
 *
 * The lambda returns the larger of two numbers.
 * 
 * .map and .reduce uses Function and BiFunction internally, but here we demonstrate BiFunction directly.
 */

package streams_lambda.examples;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class Example3
{
    public static void main(String[] args)
    {
        // Pick the larger of two integers using a BiFunction.
        BiFunction<Integer, Integer, Integer> maxValue = (a, b) -> a >= b ? a : b;
        int result = maxValue.apply(12, 7);

        // Print the computed maximum value.
        System.out.println("Max: " + result);


        String combined = Stream.of("hello", "world", "java", "streams")
                .reduce("Start", (String a, String b) -> a + "-" + b);
        Optional<String> reduce = Stream.of("streams", "and", "lambdas").reduce((a, b) -> a + " " + b);
        String s = reduce.orElse("something else");
        // .reduce function has method overloading
        System.out.println(combined);
        System.out.println(s);
    }
}
