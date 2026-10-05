/**
 * Example 2: Lambda Comparator
 *
 * Comparator<T> compares two values and returns:
 * - negative: first comes before second
 * - zero: equal order
 * - positive: first comes after second
 *
 * We sort in descending order by reversing compare arguments.
 *
 * Note on List.of(...): it returns an immutable list.
 * Sorting requires mutation, so we wrap it with new ArrayList<>(...).

 */

package streams_lambda.examples;

import java.util.ArrayList;
import java.util.List;

public class Example2
{
    public static void main(String[] args)
    {
        List<Integer> numbers = new ArrayList<>(List.of(7, 2, 9, 4, 1, 8));
        numbers.sort((a, b) -> Integer.compare(b, a));

        System.out.println(numbers);
    }
}
