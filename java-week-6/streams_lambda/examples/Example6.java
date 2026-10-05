/**
 * Example 6: Grouping and counting with Collectors
 *
 * Collectors.groupingBy(...) groups elements by a key.
 * Here, the key is word length (String::length).
 *
 * Collectors.counting() counts how many items fall into each group.
 * Result type: Map<Integer, Long>
 * - Integer key: word length
 * - Long value: count of words with that length
 */

package streams_lambda.examples;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example6
{
    public static void main(String[] args)
    {
        List<String> words = List.of("ant", "table", "car", "street", "dog", "plane", "cup");

        Map<Integer, Long> countsByLength = words.stream()
            .collect(Collectors.groupingBy(String::length, Collectors.counting()));

        System.out.println(countsByLength);
    }
}
