package generics.examples;

import java.util.Arrays;
import java.util.List;

/**
 * Example 2: Generic Methods and Bounded Types
 * 
 * This example demonstrates:
 * - Writing generic methods
 * - Using bounded type parameters (extends)
 * - Working with Number and its subclasses
 */
public class Example2 {
    
    public static void main(String[] args) {
        System.out.println("=== Generic Methods ===\n");
        
        // Generic method works with any type
        Integer[] numbers = {1, 2, 3, 4, 5};
        String[] words = {"Hello", "Generic", "World"};
        Double[] decimals = {1.1, 2.2, 3.3};
        
        System.out.print("Numbers: ");
        printArray(numbers);
        
        System.out.print("Words: ");
        printArray(words);
        
        System.out.print("Decimals: ");
        printArray(decimals);
        
        System.out.println("\n=== Finding Maximum ===\n");
        
        // Generic method with Comparable bound
        System.out.println("Max of 3, 7, 2: " + findMax(3, 7, 2));
        System.out.println("Max of 'apple', 'zebra', 'banana': " 
                          + findMax("apple", "zebra", "banana"));
        System.out.println("Max of 5.5, 2.3, 8.7: " + findMax(5.5, 2.3, 8.7));
        
        System.out.println("\n=== Bounded Type Parameters ===\n");
        
        // NumberBox only accepts Number subclasses
        NumberBox<Integer> intBox = new NumberBox<>(42);
        NumberBox<Double> doubleBox = new NumberBox<>(3.14);
        
        System.out.println("Integer box value: " + intBox.getValue());
        System.out.println("As double: " + intBox.toDouble());
        System.out.println("Is positive: " + intBox.isPositive());
        
        System.out.println("\nDouble box value: " + doubleBox.getValue());
        System.out.println("As double: " + doubleBox.toDouble());
        System.out.println("Is positive: " + doubleBox.isPositive());
        
        // This won't compile - String is not a Number:
        // NumberBox<String> stringBox = new NumberBox<>("Hi");
        
        System.out.println("\n=== Working with Lists of Numbers ===\n");
        
        List<Integer> integers = Arrays.asList(10, 20, 30, 40);
        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5);
        
        System.out.println("Sum of integers: " + sumNumbers(integers));
        System.out.println("Sum of doubles: " + sumNumbers(doubles));
        System.out.println("Average of integers: " + average(integers));
        System.out.println("Average of doubles: " + average(doubles));
    }
    
    /**
     * Generic method to print any array
     */
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    /**
     * Generic method with Comparable bound
     * T must implement Comparable interface
     */
    public static <T extends Comparable<T>> T findMax(T a, T b, T c) {
        T max = a;
        
        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        
        return max;
    }
    
    /**
     * Method that works with any List of Number subclasses
     */
    public static <T extends Number> double sumNumbers(List<T> numbers) {
        double sum = 0;
        for (Number num : numbers) {
            sum += num.doubleValue();
        }
        return sum;
    }
    
    /**
     * Calculate average of numbers
     */
    public static <T extends Number> double average(List<T> numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        return sumNumbers(numbers) / numbers.size();
    }
}

/**
 * Generic class with bounded type parameter
 * T must be Number or a subclass of Number
 */
class NumberBox<T extends Number> {
    private T value;
    
    public NumberBox(T value) {
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }
    
    // Can call Number methods because T extends Number
    public double toDouble() {
        return value.doubleValue();
    }
    
    public int toInt() {
        return value.intValue();
    }
    
    public boolean isPositive() {
        return value.doubleValue() > 0;
    }
    
    public boolean isNegative() {
        return value.doubleValue() < 0;
    }
    
    @Override
    public String toString() {
        return "NumberBox{" + value + "}";
    }
}
