package iterators.examples;


import java.util.*;

/**
 * Example 1: Using for-each loop with a List
 *
 * Demonstrates how to loop through all elements in a list
 * and print them with custom messages.
 */
public class Example1
{
    public static void main(String[] args)
    {
        List<String> cities = new ArrayList<>(List.of("Paris", "London", "Berlin", "Madrid"));

        System.out.println("List of cities:");
        for (String city : cities)
        {
            System.out.println("Visiting: " + city);
        }
    }
}
