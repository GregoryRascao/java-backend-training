package generics.exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 2: Generic Methods and Bounded Types
 * 
 * Tasks:
 * 1. Write a generic method printArray(T[] array) that prints all elements
 *    - Try it with String[], Integer[], and Double[] arrays
 * 
 * 2. Write a generic method reverse(T[] array) that returns a new array
 *    with elements in reverse order
 *    - Try with different array types
 * 
 * 3. Write a method findMin(List<T> numbers) that returns
 *    the smallest number as a double
 *    - Try with List<Integer> and List<Double>
 *    - Use a bounded type parameter: <T extends Number>
 * 
 * 4. Create a generic class Calculator<T extends Number>
 *    - Add add(), subtract(), multiply() methods that work with T
 *    - Return results as double
 *    - Try with Integer and Double
 * 
 * 5. Write a method countGreaterThan(T[] array, T element) that counts
 *    how many elements are greater than the given element
 *    - T must be Comparable
 *    - Try with different types
 */
public class Exercise2 {
    
    public static void main(String[] args) {
        System.out.println("=== Task 1: Print Array ===\n");
        
        // TODO: Call printArray method
        String[] words = {"Hello", "World", "Java"};
        Integer[] numbers = {1, 2, 3, 4, 5};
        
        
        System.out.println("\n=== Task 2: Reverse Array ===\n");
        
        // TODO: Call reverse method
        
        
        System.out.println("\n=== Task 3: Find Minimum ===\n");
        
        // TODO: Call findMin method
        List<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(5);
        integers.add(20);
        integers.add(3);
        
        
        System.out.println("\n=== Task 4: Calculator ===\n");
        
        // TODO: Create and use Calculator instances
        
        
        System.out.println("\n=== Task 5: Count Greater Than ===\n");
        
        // TODO: Call countGreaterThan method
        
    }
    
    // TODO: Task 1 - Implement printArray method
    
    
    // TODO: Task 2 - Implement reverse method
    
    
    // TODO: Task 3 - Implement: <T extends Number> double findMin(List<T> numbers)
    
    
    // TODO: Task 5 - Implement countGreaterThan method
    
}

// TODO: Task 4 - Create Calculator<T extends Number> class here
