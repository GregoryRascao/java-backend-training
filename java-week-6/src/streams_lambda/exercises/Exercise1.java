package streams_lambda.exercises;

import java.util.List;

/**
 * Create a List<Integer>.
 *
 * Using a stream:
 *
 * 1. keep numbers greater than 10
 * 2. multiply each number by 2
 * 3. print the results
 */

public class Exercise1 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 40, 100);
        System.out.println("exercice 1");
        numbers.stream()
                .filter(n -> n > 10)
                .map(n -> n * 2)
                .forEach(System.out::println);
    }

}