package arraylist.exercises;

import java.util.ArrayList;

/**
 * Exercise 4: Search in a List
 * TODO:
 * 1. Create an ArrayList with "Java", "C#", "CSS", and "Java".
 * 2. Print whether the list contains "Python".
 * 3. Print the first index of "Java".
 * 4. Print the last index of "Java".
 */
public class Exercise3
{
    public static void main(String[] args)
    {
        // TODO: Implement the exercise.
        ArrayList<String> techno = new ArrayList<>();
        techno.add("Java");
        techno.add("C#");
        techno.add("CSS");
        techno.add("Java");

        System.out.println("Contains Python :" + techno.contains("Python"));
        System.out.println("First index of Java :" + techno.indexOf("Java"));
        System.out.println("Last index of Java:" + techno.lastIndexOf("Java"));

    }
}