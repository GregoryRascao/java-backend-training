/**
 * Optional Practice
 *
 * 1. Create a List<Integer> that may be empty.
 * 2. Use stream().max(...) to find the highest value.
 * 3. Use Optional safely with:
 *    - orElse(...) to provide a default
 *    - ifPresent(...) to print only if a value exists
 * 4. Repeat with findFirst() after filtering values greater than 100.
 * 5. Do not use Optional.get() directly.
 */

package streams_lambda.exercises;

import java.util.List;
import java.util.Optional;

public class Exercise9
{
    public static void main(String[] args)
    {
        // *1. Create a List<Integer> that may be empty.
        List<Integer> numbers = List.of(42, 89, 175, 230);
        // *2. Use stream().max(...) to find the highest value.
        Optional<Integer> num = numbers.stream().max(Integer::compareTo);
        // OptionalInt num = numbers.stream().mapToInt(Integer:: intValue).max();

        // *3. Use Optional safely with:
        // *    - orElse(...) to provide a default
        // *    - ifPresent(...) to print only if a value exists
        int highest = num.orElse(0);
        System.out.println("Max :" + highest);
        num.ifPresent(v -> System.out.print("Max found " + v));

        // *4. Repeat with findFirst() after filtering values greater than 100.
        Optional<Integer> firstOver100 = numbers.stream().filter(n -> n > 100).findFirst();
        firstOver100.ifPresent(v -> System.out.println("First num " + v));
    }
}
