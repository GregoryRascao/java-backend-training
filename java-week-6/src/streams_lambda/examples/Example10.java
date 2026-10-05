/**
 * Example 10: Next step over Example3 BiFunction + reduce
 *
 * BiFunction<T, U, R> takes two inputs and returns one result.
 * We use it here for max and addition.
 *
 * We also include two reduce examples:
 * - Sum a shopping cart
 * - Find the longest word
 * Second argument of reduce is a BinaryOperator, it is a specialization of `BiFunction<T, T, T>`
 */

package streams_lambda.examples;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.List;
import java.util.stream.Stream;

public class Example10
{
    public static void main(String[] args)
    {
        // BiFunction and BinaryOperator are very similar.
        // BinaryOperator<T> is just BiFunction<T, T, T>.

        // Pick the larger of two integers with BiFunction.
        BiFunction<Integer, Integer, Integer> maxValue = (a, b) -> a >= b ? a : b;
        int max = maxValue.apply(12, 7);
        System.out.println("Max: " + max);

        // Same behavior expressed with BinaryOperator: both inputs and output are Integer.
        BinaryOperator<Integer> maxOperator = Integer::max;
        int maxWithOperator = maxOperator.apply(12, 7);
        System.out.println("Max (BinaryOperator): " + maxWithOperator);

        // Addition shown in both forms to make the similarity clear.
        BiFunction<Integer, Integer, Integer> addBiFunction = Integer::sum;
        BinaryOperator<Integer> addBinaryOperator = Integer::sum;
        int sumBiFunction = addBiFunction.apply(12, 7);
        int sumBinaryOperator = addBinaryOperator.apply(12, 7);
        System.out.println("Sum (BiFunction): " + sumBiFunction);
        System.out.println("Sum (BinaryOperator): " + sumBinaryOperator);

        // Reduce example 1: subtotal of shopping cart prices.
        List<Double> prices = List.of(19.99, 5.50, 12.49, 3.99);
        double subtotal = prices.stream()
                .reduce(0.0, Double::sum);
        System.out.println("Cart subtotal: " + subtotal);

        // Reduce example 2: longest word in a stream.
        // The single-argument reduce(...) variant expects a BinaryOperator<T>.
        String longestWord = Stream.of("java", "stream", "pipeline", "reduce", "collector")
                .reduce((left, right) -> left.length() >= right.length() ? left : right)
                .orElse("");
        System.out.println("Longest word: " + longestWord);
    }
}
