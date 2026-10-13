/**
 * Mini Report Pipeline (Mixed Topics)
 *
 * Given a list of transaction amounts:
 * 1. Keep amounts >= 100
 * 2. Remove duplicates
 * 3. Sort ascending
 * 4. Collect into a list and print it
 * 5. Compute total with mapToInt(...).sum()
 * 6. Compute highest amount with max(...).orElse(0)
 * 7. Print all report values clearly.
 */

package streams_lambda.exercises;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise12
{
    public static void main(String[] args)
    {
        // * 1. Keep amounts >= 100
        // * 2. Remove duplicates
        // * 3. Sort ascending
        // * 4. Collect into a list and print it
        List<Integer> amounts = List.of(10, 20, 40, 60, 20, 80, 150, 200);
        List<Integer> reportAmounts = amounts.stream().distinct().sorted().collect(Collectors.toList());

        Stream<Integer> stream = reportAmounts.stream();
        int total = stream.mapToInt(Integer::intValue).sum();
        int highestAmount = stream.max(Integer::compareTo).orElse(0);

        System.out.println("amount :" + amounts);
        System.out.println("total :" + total);
        System.out.println("Highest :" + highestAmount);
    }
}
