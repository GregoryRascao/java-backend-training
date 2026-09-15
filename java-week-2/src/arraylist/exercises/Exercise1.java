package arraylist.exercises;

import java.util.ArrayList;

/**
 * Exercise 2: Read and Change Elements
 * TODO:
 * 1. Create an ArrayList with the names "Samira", "Mina", and "Greg".
 * 2. Print the first name using get().
 * 3. Print the complete list.
 * 4. Replace "Mina" with "Mila" using set().
 * 5. Print the list after the change.
 */
public class Exercise1
{
    public static void main(String[] args)
    {
        ArrayList<String> names = new ArrayList<>();
        names.add("Samira");
        names.add("Mina");
        names.add("Greg");

        System.out.println("First name: " + names.get(0));
        System.out.println("List before change: " + names);

        names.set(1, "Mila");

        System.out.println("List after change: " + names);
    }
}