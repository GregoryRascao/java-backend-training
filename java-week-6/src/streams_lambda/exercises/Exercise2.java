/**
 * 1. Create a List<String> with at least five words.
 * 2. Create a Predicate<String> that returns true for words of length >= 5.
 * 3. Use the predicate with a stream filter to create a new list.
 * 4. Print the filtered list.
 */

package streams_lambda.exercises;

import java.util.List;
import java.util.function.Predicate;

public class Exercise2
{
    public static void main(String[] args)
    {
        List<String> words = List.of("Hello", "My", "name", "is", "Grégory");

        Predicate<String> lgtByfive = n -> n.length() >= 5;

        List<String> filterWords = words.stream().filter(lgtByfive).toList();

        System.out.println("filter word " + filterWords);
    }
}