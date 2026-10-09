package streams_lambda.exercises;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
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

        // Task 1 : valeurs uniques, triées par ordre alphabétique
        List<String> uniqueProducts = products.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        // Task 2 : total des prix
        int total = prices.stream()
                .mapToInt(Integer::intValue)
                .sum();

        // Task 3 : maximum, représenté par OptionalInt pour gérer une liste vide
        Optional<Integer> highestPrice = prices.stream()
                .max(Integer::compareTo);

        // or that way
        OptionalInt hPrice = prices.stream().mapToInt(Integer::intValue).max();

        // Task 4 : moyenne ; 0.0 est utilisé si la liste est vide
        double averagePrice = prices.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        // Task 5 : afficher les résultats
        System.out.println("Produits : " + uniqueProducts);
        System.out.println("Total : " + total);
        System.out.println("Prix le plus élevé : " + highestPrice.orElse(0));
        System.out.println("Prix moyen : " + averagePrice);

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

        namesByFirstLetter.forEach((letter, count) -> System.out.println(letter + " → " + count));
    }
}
