package arraylist.exercises;

import java.util.ArrayList;

/**
 * Exercise 6: Calculate a Total
 * TODO:
 * 1. Create an ArrayList<Integer> with at least five numbers.
 * 2. Use a loop to calculate their sum.
 * 3. Print the sum and the average as a double.
 * 4. Print the largest number in the list.
 */
public class Exercise5
{
    public static void main(String[] args)
    {
        // TODO: Implement the exercise.
        ArrayList<Integer> intNumbers = new ArrayList<>();
        intNumbers.add(1);
        intNumbers.add(2);
        intNumbers.add(3);
        intNumbers.add(4);
        intNumbers.add(5);

        int sum = 0;
        for (int i = 0; i < intNumbers.size(); i++) {
            sum += intNumbers.get(i);
        }
        System.out.println("Result of sum " + sum);
    }
}