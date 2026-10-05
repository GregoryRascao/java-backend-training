package streams_lambda.examples;

/*Tasks:
        Produce unique, alphabetically sorted product names
        Compute total price
        Find the highest price using an Optional-safe approach
        Print all results
*/
import java.util.List;

public class Example11 {

    public static void main(String[] args) {
        List<String> products = List.of("Book", "Pen", "Book", "Laptop", "Pencil", "Pen");
        List<Integer> prices = List.of(25, 5, 25, 900, 3, 5);

        List<String> strings = products.stream().sorted().distinct().toList();
        System.out.println(strings);
        int sum = prices.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum: " + sum);
        int i = prices.stream().mapToInt(Integer::intValue).max().orElse(0);
        System.out.println("Max value: " + i);
    }
}
