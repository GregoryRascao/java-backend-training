/**
 * Example 1: Lambda + Predicate
 *
 * Predicate<T> is a built-in functional interface that takes one input (T)
 * and returns a boolean. It is commonly used with Stream.filter(...).
 *
 * List.of(...) creates an immutable list (fixed contents).
 * Here we only read/filter values, so immutable is fine.
 */

package streams_lambda.examples;

import java.util.List;
import java.util.function.Predicate;

public class Example1
{
    public static void main(String[] args)
    {
        List<String> words = List.of("lamp", "window", "tree", "mountain", "road", "cloud");
        Predicate<String> lengthAtLeastFive = word -> word.length() >= 5;

        List<String> filtered = words.stream()
            .filter(lengthAtLeastFive)
            .toList();

        words.stream()
                .filter(n -> n.length() >= 5)
                .forEach(item -> System.out.println(item + ", "));

        System.out.println(filtered);
    }
}
