package streams_lambda.exercises;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Report {
    public static void main(String[] args) {
        List<String> products = List.of(
                "Book",
                "Pen",
                "Book",
                "Laptop",
                "Pencil",
                "Pen");

        List<Integer> prices = List.of(25, 5, 25, 900, 3, 5);

        // Task 1
        List<String> uniqueProducts = products.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        // Task 2
        int total = prices.stream()
                .mapToInt(Integer::intValue)
                .sum();

        // Task 3
        Optional<Integer> highestPrice = prices.stream()
                .max(Integer::compareTo);

        // or that way
        // OptionalInt Highest = prices.stream().mapToInt(Integer::intValue).max();

        // Task 4
        double averagePrice = prices.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        // Task 5
        System.out.println("Products : " + uniqueProducts);
        System.out.println("Total : " + total);
        System.out.println("Highest Price : " + highestPrice.orElse(0));
        System.out.println("Medium Price : " + averagePrice);

        // Optional Challenge
        List<String> names = List.of(
                "Alice",
                "Adam",
                "Bob",
                "Bella",
                "Charlie",
                "Chris");

        Map<Character, Long> namesByFirstLetter = names.stream()
                .collect(Collectors.groupingBy(
                        name -> name.charAt(0),
                        TreeMap::new,
                        Collectors.counting()));

        namesByFirstLetter.forEach((letter, count) -> System.out.println(letter + " = " + count));
    }
}
