package testing3.ourexamples.week6.examples;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class StreamOperationsExample
{
    public static List<String> normalizeNames(List<String> rawNames)
    {
        UnaryOperator<String> normalize = text -> text.trim().toUpperCase();
        return rawNames.stream()
                .map(normalize)
                .toList();
    }

    public static List<String> uniqueSortedProductNames(List<String> products)
    {
        return products.stream()
                .sorted()
                .distinct()
                .toList();
    }

    public static int totalPrice(List<Integer> prices)
    {
        return prices.stream().mapToInt(Integer::intValue).sum();
    }

    public static Optional<Integer> highestPrice(List<Integer> prices)
    {
        return prices.stream().mapToInt(Integer::intValue).max().stream().boxed().findFirst();
    }

    public static Map<Character, Long> countByInitial(List<String> names)
    {
        return names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0), Collectors.counting()));
    }
}