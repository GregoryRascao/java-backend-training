/**
 * Example 9: IntStream
 *
 * IntStream is a primitive stream for int values.
 * It avoids boxing overhead and provides numeric helpers.
 */

package streams_lambda.examples;

import java.util.List;
import java.util.stream.IntStream;

public class Example9
{
    public static void main(String[] args)
    {
        int evenSum = IntStream.rangeClosed(1, 20)
                .filter(n -> n % 2 == 0)
                .sum();

        double average = IntStream.of(10, 20, 30, 40, 50)
                .average()
                .orElse(0.0);

        List<Integer> squares = IntStream.rangeClosed(1, 5)
                .map(n -> n * n)
                .boxed()
                .toList();

        System.out.println("Sum of even numbers 1..20: " + evenSum);
        System.out.println("Average: " + average);
        System.out.println("Squares: " + squares);
    }
}
