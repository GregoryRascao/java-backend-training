/**
 * Primitive Streams Practice
 *
 * 1. Use IntStream.rangeClosed(1, 20) to compute the sum of odd numbers.
 * 2. Use IntStream.of(...) to compute average, min, and max.
 * 3. Convert List<Integer> to IntStream with mapToInt(...) and compute sum.
 * 4. Use IntStream.rangeClosed(...) + map(...) + boxed() to create a List<Integer> of cubes.
 * 5. Add one small LongStream or DoubleStream example and print the result.
 */

package streams_lambda.exercises;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Exercise10
{
    public static void main(String[] args)
    {
        // * Part 1 Use IntStream.rangeClosed(1, 20) to compute the sum of odd numbers.
        int oddNumbers = IntStream.rangeClosed(1, 20).filter(n -> n % 2 != 0).sum();
        System.out.println("OddNumbers :" + oddNumbers);

        // * Part 2 Use IntStream.of(...) to compute average, min, and max.
        int[] values = {4,8,15,16,23,42};
        double average = IntStream.of(values).average().orElse(0);
        int min = IntStream.of(values).min().orElse(0);
        int max = IntStream.of(values).max().orElse(0);
        System.out.println("Average :" + average);
        System.out.println("min :" + min);
        System.out.println("max :" + max);

        // * Part 3 Convert List<Integer> to IntStream with mapToInt(...) and compute sum.
        List<Integer> numbers = List.of(20, 30, 40);
        int listSum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum the list :" + listSum);

        // * Part 4 Use IntStream.rangeClosed(...) + map(...) + boxed() to create a List<Integer> of cubes.
        List<Integer> numbers2 = IntStream.rangeClosed(1, 5).map(n -> n * n * n).boxed().toList();
        System.out.println("Cubes :" + numbers2);

        // * Part 5 Add one small LongStream or DoubleStream example and print the result.
        Long longStream = LongStream.rangeClosed(1, 5).sum();
        System.out.println("LongStream :" + longStream);

    }
}
