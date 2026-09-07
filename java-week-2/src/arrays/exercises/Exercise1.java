package arrays.exercises;

/**
 * Exercise 1: Single-Dimensional Array
 * TODO:
 * 1. Create an array of 5 integers.
 * 2. Traverse and print elements.
 * 3. Find sum of all elements.
 */
public class Exercise1
{
    public static void main(String[] args)
    {
        int[] singleArr = {1, 2, 3, 4, 5};
        int sum = 0;

        for (int i = 0; i < singleArr.length; i++) {
            System.out.println("Traverse elements : " + singleArr[i]);
        }
        for (int i = 0; i < singleArr.length; i++) {
            sum += singleArr[i];
        }
        System.out.println("Sum of elements : " + sum);

    }
}
