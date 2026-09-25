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
public class Exercise1Bis
{
    public static void main(String[] args)
    {
        System.out.println("=== Task 2: Container ===\n");
        // TODO Task 2 - Create Container<String>, Container<Integer>, Container<Boolean> and print their values
        Container<String> stringContainer = new Container<String>("text Exercise 1bis");
        Container<Integer> integerContainer = new Container<Integer>(123);
        Container<Boolean> booleanContainer = new Container<Boolean>(false);

        System.out.println("String : " + stringContainer.getValue());
        System.out.println("Integer : " + integerContainer.getValue());
        System.out.println("Boolean : " + booleanContainer.getValue());


        System.out.println("\n=== Task 4: Pair ===\n");
        //Task 4 - Create Pair<String, Integer>, swap it, and print both pairs
        Pair<Integer, String> pairContainer = new Pair<>(41, "name");
        System.out.println("pair value :" + pairContainer.getValue() + " " + pairContainer.getKey());

        Pair<String, Integer> swapped = pairContainer.swap();

        System.out.println("Swapped Pair: " + swapped);
    }
}

// Task 1 - Create Container<T> class here
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

// Task 3 - Create Pair<K, V> class here
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