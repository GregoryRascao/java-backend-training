package collections.examples;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) 
    {
        Set<String> fruits = new HashSet<>();

        //  Adding elements (duplicates are ignored)
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple"); // duplicate ignored
        System.out.println("Fruits: " + fruits);

        //  Remove element
        fruits.remove("Banana");
        System.out.println("After removing Banana: " + fruits);

        //  Check if set contains an element
        System.out.println("Contains Orange? " + fruits.contains("Orange"));
        System.out.println("Contains Mango? " + fruits.contains("Mango"));

        //  Size of the set
        System.out.println("Set size: " + fruits.size());

        //  Iterating with for-each loop
        System.out.print("Iterating with for-each: ");
        for (String fruit : fruits)
        {
            System.out.print(fruit + " ");
        }
        System.out.println();

        //  Iterating with forEach (lambda)
        System.out.print("Iterating with forEach: ");
        fruits.forEach(fruit -> {
            System.out.print(fruit);
            System.out.println(" ");
        }); // lambda expression
        System.out.println();

        //  Convert set to array
        Object[] fruitArray = fruits.toArray();
        System.out.print("Converted to array: ");
        for (Object f : fruitArray)
        {
            System.out.print(f + " ");
        }
        System.out.println();

        //  Example of set operations
        Set<String> tropical = new HashSet<>();
        tropical.add("Mango");
        tropical.add("Orange");
        tropical.add("Pineapple");

        // Union
        Set<String> union = new HashSet<>(fruits);
        union.addAll(tropical);
        System.out.println("Union: " + union);

        // Intersection
        Set<String> intersection = new HashSet<>(fruits);
        intersection.retainAll(tropical);
        System.out.println("Intersection: " + intersection);

        // Difference
        Set<String> difference = new HashSet<>(fruits);
        difference.removeAll(tropical);
        System.out.println("Difference (fruits - tropical): " + difference);

        //  Clear the set
        fruits.clear();
        System.out.println("After clearing: " + fruits);
        System.out.println("Is set empty? " + fruits.isEmpty());
    }
}
