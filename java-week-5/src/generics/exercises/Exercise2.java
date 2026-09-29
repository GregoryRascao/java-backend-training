package generics.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise 2: Generic Methods and Bounded Types
 * 
 * Tasks:
 * 1. Write a generic method printArray(T[] array) that prints all elements
 * - Try it with String[], Integer[], and Double[] arrays
 * 
 * 2. Write a generic method reverse(T[] array) that returns a new array
 * with elements in reverse order
 * - Try with different array types
 * 
 * 3. Write a method findMin(List<T> numbers) that returns
 * the smallest number as a double
 * - Try with List<Integer> and List<Double>
 * - Use a bounded type parameter: <T extends Number>
 * 
 * 4. Create a generic class Calculator<T extends Number>
 * - Add add(), subtract(), multiply() methods that work with T
 * - Return results as double
 * - Try with Integer and Double
 * 
 * 5. Write a method countGreaterThan(T[] array, T element) that counts
 * how many elements are greater than the given element
 * - T must be Comparable
 * - Try with different types
 */
public class Exercise2 {

    public static void main(String[] args) {
        System.out.println("=== Task 1: Print Array ===\n");

        // Call printArray method
        String[] words = { "Hello", "World", "Java" };
        Integer[] numbers = { 1, 2, 3, 4, 5 };
        printArray(words);
        printArray(numbers);

        // Call reverse method
        System.out.println("\n=== Task 2: Reverse Array ===\n");
        Integer[] reversedNumbers = reverse(numbers);
        printArray(reversedNumbers);

        // Call findMin method
        System.out.println("\n=== Task 3: Find Minimum ===\n");

        List<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(5);
        integers.add(20);
        integers.add(3);
        System.out.println("Minimum integer :" + findMin(integers));

        System.out.println("\n=== Task 4: Calculator ===\n");
        // Create and use Calculator instances
        Calculator<Integer> integerCalcul = new Calculator(12, 2);
        System.out.println("Calculate this :" + integerCalcul.add());

        System.out.println("\n=== Task 5: Count Greater Than ===\n");
        // Call countGreaterThan method
        System.out.println(countGreaterThan(numbers, 9));
        System.out.println(countGreaterThan(words, "kikoulapraline"));

    }

    // Task 1 - Implement printArray method
    public static <T> void printArray(T[] array) {
        for (T t : array) {
            System.out.println(t);
        }
    }

    // Task 2 - Implement reverse method
    public static <T> T[] reverse(T[] array) {
        T[] reversed = Arrays.copyOf(array, array.length);
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;

    }

    // Task 3 - Implement: <T extends Number> double findMin(List<T> numbers)
    public static <T extends Number> double findMin(List<T> numbers) {
        double minimum = numbers.get(0).doubleValue();
        for (T t : numbers) {
            minimum = Math.min(minimum, t.doubleValue());
        }

        return minimum;
    }

    // Task 5 - Implement countGreaterThan method
    public static <T extends Comparable<T>> int countGreaterThan(T[] array, T element) {
        int count = 0;

        for (T value : array) {
            if (value.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }
}

// Task 4 - Create Calculator<T extends Number> class here
class Calculator<T extends Number> {
    T first;
    T second;

    public Calculator(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public double add() {
        return first.doubleValue() + second.doubleValue();
    }

    public double remove() {
        return first.doubleValue() - second.doubleValue();
    }

    public double multiply() {
        return first.doubleValue() * second.doubleValue();
    }

    public double divide() {
        return first.doubleValue() / second.doubleValue();
    }

}
