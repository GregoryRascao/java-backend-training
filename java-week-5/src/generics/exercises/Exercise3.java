package generics.exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 3: Type Erasure and Runtime Type Safety
 *
 * Tasks:
 * 1. Create two lists:
 *    - List<String> names
 *    - List<Integer> ids
 *    Print whether their runtime class is the same.
 *
 * 2. Write a method
 *    <T> T safeCast(Object value, Class<T> expectedType)
 *    - Return the value cast to T when possible
 *    - Return null when the cast is not valid
 *
 * 3. Create a generic class TypedValue<T> with:
 *    - fields: T value, Class<T> type
 *    - constructor
 *    - getters
 *
 * 4. Write a generic method
 *    <T extends Number> double average(List<T> numbers)
 *    - Return 0 for an empty list
 *
 * 5. Refactor this raw list to a typed list and explain why:
 *    List raw = new ArrayList();
 */
public class Exercise3 {

    public static void main(String[] args) {
        System.out.println("=== Task 1: Type Erasure Check ===\n");
        List<String> names = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();

        // TODO: Print the runtime class of both lists and compare them

        System.out.println("\n=== Task 2: safeCast Method ===\n");
        // TODO: Call safeCast with matching and non-matching types

        System.out.println("\n=== Task 3: TypedValue Class ===\n");
        // TODO: Create TypedValue<String> and TypedValue<Integer> objects

        System.out.println("\n=== Task 4: Average Method ===\n");
        // TODO: Call average with integer and double lists

        System.out.println("\n=== Task 5: Remove Raw Types ===\n");
        // TODO: Replace raw list with a typed list
    }

    // TODO: Task 2 - Implement safeCast


    // TODO: Task 4 - Implement average
}
