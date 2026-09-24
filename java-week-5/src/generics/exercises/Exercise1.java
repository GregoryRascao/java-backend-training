package generics.exercises;

/**
 * Exercise 1: Basic Generic Classes
 * 
 * Tasks:
 * 1. Create a generic class Container<T> that holds a single value
 *    - Add a constructor that takes a value
 *    - Add getValue() and setValue() methods
 *    - Add an isEmpty() method that returns true if value is null
 * 
 * 2. In main(), create instances for different types:
 *    - Container<String> with value "Hello"
 *    - Container<Integer> with value 100
 *    - Container<Boolean> with value true
 *    - Print all values
 * 
 * 3. Create a generic class Pair<K, V> with two values
 *    - Add getKey() and getValue() methods
 *    - Add a swap() method that returns a new Pair<V, K> with swapped values
 * 
 * 4. Try Pair with:
 *    - Pair<String, Integer> for ("age", 25)
 *    - Swap it and print both pairs
 */
public class Exercise1
{
    public static void main(String[] args)
    {

        Container<String> stringContainer = new Container<>("Hello");
        Container<Integer> intContainer = new Container<>(100);
        Container<Boolean> boolContainer = new Container<>(true);

        System.out.println("String value: " + stringContainer.getValue());
        System.out.println("Integer value: " + intContainer.getValue());
        System.out.println("Boolean value: " + boolContainer.getValue());


        Pair<String, Integer> agePair = new Pair<>("age", 25);

        System.out.println("Original Pair: " +
                agePair.getKey() + " = " + agePair.getValue());

        Pair<Integer, String> swapped = agePair.swap();

        System.out.println("Swapped Pair: " + swapped);
    }
}

class Container<T> {

    private T value;

    public Container(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return value == null;
    }
}

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Pair<V, K> swap() {
        return new Pair<>(value, key);
    }

    @Override
    public String toString() {
        return "K: " + this.key + ", V: " + this.value;
    }
}