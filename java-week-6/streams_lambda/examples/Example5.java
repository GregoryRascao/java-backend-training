/**
 * Example 5: Stream filter + toList
 *
 * filter(...) keeps only elements that match a Predicate.
 * Here we keep names that start with 'A' or 'a'.
 *
 * Stream.toList() returns a new list containing the filtered values.
 */

package streams_lambda.examples;

import java.util.List;
import java.util.stream.Stream;

public class Example5
{
    public static void main(String[] args)
    {
        List<String> names = List.of("Alice", "bob", "Anna", "George", "Amelia");

        List<String> filtered = names.stream()
            .filter(name -> name.startsWith("A") || name.startsWith("a"))
            .filter(longEnough -> longEnough.length() > 4)
            .toList();
        Stream<String> stringStream = names.stream()
                .filter(name -> name.startsWith("A") || name.startsWith("a"))
                .filter(longEnough -> longEnough.length() > 4);

        List<String> strings = stringStream.toList();

        System.out.println(filtered);
    }
}
