package arraylist.exercises;

import java.util.ArrayList;

/**
 * Exercise 3: Remove Elements
 * TODO:
 * 1. Create an ArrayList with the colors "Nik", "Charlotte", "Gayatri", and "Paul".
 * 2. Remove "Nik" by its value.
 * 3. Remove the first "Gayatri" by its index.
 * 4. Print the resulting list and its size.
 */
public class Exercise2
{
    public static void main(String[] args)
    {
        // TODO: Implement the exercise.
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Nik");
        colors.add("Charlotte");
        colors.add("Gayatri");
        colors.add("Paul");

        System.out.println("Liste before changes :" + colors);
        colors.remove("Nik");
        System.out.println("Liste after :" + colors);
        colors.remove(1);
        System.out.println("Liste after Index: " + colors);
    }
}