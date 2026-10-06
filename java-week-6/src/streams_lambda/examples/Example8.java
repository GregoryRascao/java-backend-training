/**
 * Example 8: UnaryOperator
 *
 * UnaryOperator<T> is a specialization of Function<T, T>:
 * input and output types are the same.
 */

package streams_lambda.examples;

import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Example8
{
    public static void main(String[] args)
    {
        UnaryOperator<String> normalize = text -> text.trim().toUpperCase();

        List<String> rawNames = List.of("  alice", "Bob  ", "  charlie  ");
        List<String> normalizedNames = rawNames.stream()
                .map(normalize)
                .toList();

        UnaryOperator<Integer> square = n -> n * n;
        int squared = square.apply(6);

        System.out.println("Normalized names: " + normalizedNames);
        System.out.println("Square of 6: " + squared);


        double v = DoubleStream.of(2.5, 7.1, 3.9).filter(n -> n > 10).max().orElse(0.0);

        Optional<String> maybeName = List.of("Fatma", "Jon").stream()
                .filter(n -> n.startsWith("Z"))
                .findFirst();
//        maybeName.get();  // Question: Exception or null?

        List<String> names = List.of("Gregory", "Ricardo", "Roberto", "Gomathi", "Charlotte");
        List<Character> characters = names.stream().map(n -> n.charAt(0)).toList();
        List<String> collect = names.stream().collect(Collectors.toList());

        Map<Character, Long> countByInitial = names.stream()
                .collect(Collectors.groupingBy(n -> n.charAt(0), Collectors.counting()));

        Set<Character> keys = countByInitial.keySet();
        Collection<Long> values = countByInitial.values();

    }
}
