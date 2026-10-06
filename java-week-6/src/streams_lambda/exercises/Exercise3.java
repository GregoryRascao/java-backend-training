/**
 * 1. Create a List<Integer> with at least six numbers.
 * 2. Sort the list in descending order using a lambda comparator.
 * 3. Print the sorted list.
 */

package streams_lambda.exercises;

import java.util.Comparator;
import java.util.List;

public class Exercise3
{
    public static void main(String[] args)
    {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> sorted = numbers.stream().sorted((a,b) -> b.compareTo(a)).toList();
        System.out.println("sorted Number :" + sorted);
    }
}