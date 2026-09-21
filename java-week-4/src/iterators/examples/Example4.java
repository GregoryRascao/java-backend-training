package iterators.examples;

import java.util.*;

/**
 * Example 1: Basic Iterator with a List
 *
 * Demonstrates using hasNext(), next(), and remove()
 * to safely traverse and modify a collection.
 */
public class Example4
{
    public static void main(String[] args)
    {
        List<String> animals = new ArrayList<>(List.of("Cat", "Dog", "Elephant", "Lion", "Deer"));

        System.out.println("Original list: " + animals);

        Iterator<String> iterator = animals.iterator();

        while (iterator.hasNext())
        {
            String animal = iterator.next();
            if (animal.startsWith("D"))
            {
                iterator.remove(); // safe removal
            }
        }

        System.out.println("After removing animals starting with 'D': " + animals);
    }
}
