/**
 * 1. Create a BiFunction<Integer, Integer, Integer> that returns the larger value.
 * 2. Apply it to two numbers and print the result.
 */

package streams_lambda.exercises;

import java.util.function.BiFunction;

public class Exercise5
{
    public static void main(String[] args)
    {
        BiFunction<Integer , Integer, Integer> largeValue = (a, b) -> Math.max(a, b);

        int result = largeValue.apply(12, 19);
        System.out.println("result :" + result);
    }
}
