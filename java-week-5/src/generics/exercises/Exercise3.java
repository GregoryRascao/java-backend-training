package generics.exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 3: Type Erasure and Runtime Type Safety
 *
 * Tasks:
 * 1. Create two lists:
 * - List<String> names
 * - List<Integer> ids
 * Print whether their runtime class is the same.
 *
 * 2. Write a method
 * <T> T safeCast(Object value, Class<T> expectedType)
 * - Return the value cast to T when possible
 * - Return null when the cast is not valid
 *
 * 3. Create a generic class TypedValue<T> with:
 * - fields: T value, Class<T> type
 * - constructor
 * - getters
 *
 * 4. Write a generic method
 * <T extends Number> double average(List<T> numbers)
 * - Return 0 for an empty list
 *
 * 5. Refactor this raw list to a typed list and explain why:
 * List raw = new ArrayList();
 */
public class Exercise3 {

    public static void main(String[] args) {
        System.out.println("=== Task 1: Type Erasure Check ===\n");
        List<String> names = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();

        // Print the runtime class of both lists and compare them
        System.out.println("names class : " + names.getClass());
        System.out.println("ids class : " + ids.getClass());
        System.out.println("Same runtime class: "
                + (names.getClass() == ids.getClass()));

        System.out.println("\n=== Task 2: safeCast Method ===\n");
        // Call safeCast with matching and non-matching types
        String text = safeCast("Hello", String.class);
        Integer number = safeCast("Hello", Integer.class);
        System.out.println("Cast to String: " + text);
        System.out.println("Cast to Integer: " + number);

        System.out.println("\n=== Task 3: TypedValue Class ===\n");
        // Create TypedValue<String> and TypedValue<Integer> objects
        TypedValue<String> title = new TypedValue("Anime Generik", String.class);
        TypedValue<Integer> score = new TypedValue(41, Integer.class);
        System.out.println(title.getValue() + " " + title.getType().getSimpleName());
        System.out.println(score.getValue() + " " + score.getType().getSimpleName());

        System.out.println("\n=== Task 4: Average Method ===\n");
        // Call average with integer and double lists
        List<Integer> integers = List.of(10, 20, 30);
        List<Double> decimals = List.of(1.5, 2.5, 3.5);
        System.out.println("Integer average: " + average(integers));
        System.out.println("Double average: " + average(decimals));

        System.out.println("\n=== Task 5: Remove Raw Types ===\n");
        // ! Replace raw list with a typed list
    }

    // Task 2 - Implement safeCast
    public static <T> T safeCast(Object value, Class<T> expectedType) {
        if (expectedType.isInstance(value)) {
            return expectedType.cast(value);
        }
        return null;
    }

    // Task 4 - Implement average
    public static <T extends Number> double average(List<T> numbers){
        if(numbers.isEmpty()){
            return 0;
        }
        double sum = 0;
        for(T number : numbers){
            sum += number.doubleValue();
        }
        return sum / numbers.size();
    }
}

class TypedValue<T>{
    T value;
    Class<T> type;

    TypedValue(T value, Class<T> type){
        this.value = value;
        this.type = type;

    }
    public T getValue(){
        return value;
    }

    public Class<T> getType(){
        return type;
    }
}