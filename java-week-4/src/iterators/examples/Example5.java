package iterators.examples;

import java.util.*;

/**
 * Example 2: Iterator with a Set
 *
 * Demonstrates iterating through a HashSet
 * and removing elements conditionally.
 */
public class Example5
{
    public static void main(String[] args)
    {
        Set<Integer> numbers = new HashSet<>(Set.of(5, 12, 8, 20, 15, 3));

        System.out.println("Original set: " + numbers);

        Iterator<Integer> it = numbers.iterator();

        while (it.hasNext())
        {
            Integer num = it.next();
            if (num < 10)
            {
                it.remove(); // safely remove small numbers
            }
        }

        System.out.println("After removing numbers < 10: " + numbers);
    }
}
