/**
 * Example 7: Stream.sorted(...)
 *
 * sorted() does not change the original collection.
 * It creates a new ordered stream.
 */

package streams_lambda.examples;

import java.util.Comparator;
import java.util.List;

public class Example7
{
    public static void main(String[] args)
    {
        List<String> names = List.of("Oleg", "Gayatri", "Mila", "Paul", "Malek");

        List<String> byLengthThenAlphabetical = names.stream()
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .toList();

        System.out.println("Original: " + names);
        System.out.println("Sorted by length: " + byLengthThenAlphabetical);
    }
}
