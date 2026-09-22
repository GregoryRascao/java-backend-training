package iterators.exercises;

import java.util.*;

/**
 * 1. Create a List<Integer> numbers with at least 8 integers.
 * 2. Use an Iterator to remove all even numbers.
 * 3. Print the list before and after removal.
 *
 */
public class Exercise2
{
    static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        Iterator<Integer> iterator = numbers.iterator();
        iterator.next();

//        numbers.removeIf(number -> number % 2 == 0);
        System.out.println("Before removing " + numbers);
        while (iterator.hasNext())
        {
            Integer number = iterator.next();
            if (number % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.print("after " + numbers);
    }
}
