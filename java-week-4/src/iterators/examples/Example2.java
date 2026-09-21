package iterators.examples;

import java.util.*;

/**
 * Example 2: Using for-each loop with a Set
 *
 * Demonstrates iterating through a HashSet
 * (order is not guaranteed).
 */
public class Example2
{
    public static void main(String[] args)
    {
        Set<String> countries = new HashSet<>(Set.of("France", "Germany", "Italy", "Spain"));

        System.out.println("Countries in the set:");
        for (String country : countries) {
            System.out.println("Country: " + country);
        }
    }
}
