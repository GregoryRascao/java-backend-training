package generics.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Example 3: Type Erasure and Runtime Type Checks
 *
 * This example demonstrates:
 * - Type erasure in generic collections
 * - Why runtime type checks use Class<T>
 * - Safe casting helper with generics
 */
public class Example3 {

    public static void main(String[] args) {
        System.out.println("=== Type Erasure Demo ===\n");

        List<String> names = new ArrayList<>();
        List<Integer> scores = new ArrayList<>();

        System.out.println("names runtime type: " + names.getClass().getName());
        System.out.println("scores runtime type: " + scores.getClass().getName());
        System.out.println("same runtime class: " + (names.getClass() == scores.getClass()));

        System.out.println("\n=== Class Token Demo ===\n");
        System.out.println("safeCast(123, Integer.class): " + safeCast(123, Integer.class));
        System.out.println("safeCast(123, String.class): " + safeCast(123, String.class));

        TypedBox<String> title = new TypedBox<>("Generics", String.class);
        TypedBox<Double> grade = new TypedBox<>(8.5, Double.class);

        System.out.println("\n" + title);
        System.out.println(grade);
    }

    /**
     * Uses a class token to keep runtime type information available.
     */
    public static <T> T safeCast(Object value, Class<T> expectedType) {
        if (expectedType.isInstance(value)) {
            return expectedType.cast(value);
        }
        return null;
    }
}

class TypedBox<T> {
    private final T value;
    private final Class<T> type;

    public TypedBox(T value, Class<T> type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public String toString() {
        return "TypedBox{value=" + value + ", type=" + type.getSimpleName() + "}";
    }
}
