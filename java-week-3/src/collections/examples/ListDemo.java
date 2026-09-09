package collections.examples;

import java.util.ArrayList;
import java.util.List;

public class ListDemo
{
    public static void main(String[] args)
    {
        List<String> names = new ArrayList<>();

        //  Adding elements
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("Alice"); // duplicates allowed
        System.out.println("All names: " + names);

        //  Access by index
        System.out.println("First name: " + names.get(0));

        //  Remove by value
        names.remove("Bob");
        System.out.println("After removing Bob: " + names);

        //  Remove by index
        names.remove(0); // removes "Alice"
        System.out.println("After removing index 0: " + names);

        //  Insert element at specific index
        names.add(1, "David");
        System.out.println("After inserting David at index 1: " + names);

        //  Replace element at index (set)
        names.set(0, "Eve");
        System.out.println("After replacing first element with Eve: " + names);

        //  Check if list contains an element
        System.out.println("Contains Charlie? " + names.contains("Charlie"));
        System.out.println("Contains Bob? " + names.contains("Bob"));

        //  Get the size of the list
        System.out.println("Size of list: " + names.size());

        //  Iterate using for-each loop
        System.out.print("Iterating (for-each): ");
        for (String name : names)
        {
            System.out.print(name + " ");
        }
        System.out.println();

        //  Iterate using forEach (lambda)
        System.out.print("Iterating (lambda): ");
        names.forEach(n -> System.out.print(n + " "));
        System.out.println();
        names.add(0, "Alice");
        //  Find index of an element
        System.out.println("Index of Alice: " + names.indexOf("Alice"));
        System.out.println("Last index of Alice: " + names.lastIndexOf("Alice"));

        //  Convert to array
        Object[] array = names.toArray();
        System.out.print("Converted to array: ");
        for (Object obj : array)
        {
            System.out.print(obj + " ");
        }
        System.out.println();

        //  Clear the list
        names.clear();
        System.out.println("After clearing list: " + names);
        System.out.println("Is list empty? " + names.isEmpty());
    }
}
