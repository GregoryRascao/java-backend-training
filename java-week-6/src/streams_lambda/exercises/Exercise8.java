/**
 * 1. Create a List<String> of words with different lengths.
 * 2. Use Collectors.groupingBy and Collectors.counting to count words by length.
 * 3. Print the resulting Map<Integer, Long>.
 */

package streams_lambda.exercises;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Exercise8 {
    public static void main(String[] args) {
        List<String> words = List.of("Hi", "NullException", "JustAGibberish", "JustAGibberish", "JustAGibberish", "JustAGibberish");
        Map<Integer, Long> grouping = words.stream()
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println("grouping :" + grouping);
    }
}
