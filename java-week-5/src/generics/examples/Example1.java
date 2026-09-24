package generics.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Example 1: Generic Classes Basics
 * 
 * This example demonstrates:
 * - Creating a simple generic class
 * - Using type parameters
 * - Type safety benefits
 */
public class Example1 {
    
    public static void main(String[] args) {
        System.out.println("=== Generic Box Example ===\n");
        
        // Create boxes for different types
        Box<String> stringBox = new Box<>("Hello Generics!");
        Box<Integer> intBox = new Box<>(42);
        Box<Double> doubleBox = new Box<>(3.14);
        
        // Get values - no casting needed!
        String str = stringBox.getValue();
        Integer num = intBox.getValue();
        Double pi = doubleBox.getValue();
        
        System.out.println("String box contains: " + str);
        System.out.println("Integer box contains: " + num);
        System.out.println("Double box contains: " + pi);
        
        // Type safety - this won't compile:
        // stringBox.setValue(123); // Error: expects String, not Integer
        
        System.out.println("\n=== Generic Pair Example ===\n");
        
        // More complex generic class with two type parameters
        Pair<String, Integer> nameAge = new Pair<>("Alice", 25);
        Pair<Integer, String> idName = new Pair<>(101, "Bob");
        
        System.out.println("Name: " + nameAge.getFirst() + ", Age: " + nameAge.getSecond());
        System.out.println("ID: " + idName.getFirst() + ", Name: " + idName.getSecond());
        
        System.out.println("\n=== Without Generics (OLD way) ===\n");
        
        // Old way without generics - not type safe!
        List oldList = new ArrayList(); // Raw type
        oldList.add("String");
        oldList.add(123);
        oldList.add(true);
        
        // Need casting and risk runtime errors
        String s = (String) oldList.get(0); // Works
        // String s2 = (String) oldList.get(1); // Runtime error: ClassCastException!
        
        System.out.println("\n=== With Generics (NEW way) ===\n");
        
        // New way with generics - type safe!
        List<String> newList = new ArrayList<>();
        newList.add("Hello");
        newList.add("World");
        // newList.add(123); // Compile error - won't even run!
        
        String first = newList.get(0); // No casting needed
        System.out.println("First element: " + first);
    }
}

/**
 * A simple generic class that holds a value of type T
 */
class Box<T> {
    private T value;
    
    public Box(T value) {
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }
    
    public void setValue(T value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "Box{" + value + "}";
    }
}

/**
 * A generic class with TWO type parameters
 */
class Pair<K, V> {
    private K first;
    private V second;
    
    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
    
    public K getFirst() {
        return first;
    }
    
    public V getSecond() {
        return second;
    }
    
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
