/**
 * Example 4: Stream mapToInt + sum
 *
 * We transform each number to its square, then add all squares.
 *
 * mapToInt(...) creates an IntStream (primitive stream), which is efficient
 * for numeric operations like sum(), average(), min(), and max().
 * aggregation operations
 * 
 * 
 * Note: You should always ask yourself What is the type after each flexible step?
 */

package streams_lambda.examples;

import java.util.List;

public class Example4
{
    public static void main(String[] args)
    {
        List<Integer> numbers = List.of(2, 3, 4, 5, 6);

        int sumOfSquares = numbers.stream()
            .mapToInt(n -> n * n)               //IntStream
            .sum();

        System.out.println("Sum of squares: " + sumOfSquares);
    }
}
