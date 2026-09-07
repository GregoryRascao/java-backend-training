package arrays.examples;
import java.util.Arrays;

/**
 * Example 4: Array Operations
 * -----------------------------
 * This example demonstrates common array operations such as sorting, copying, searching, and comparing arrays using
 * methods from the java.util.Arrays class.
 *
 */

public class Example4
{
    public static void main(String[] args)
    {
        int[] arr = {5, 2, 8, 1, 3};

        // Sort
        Arrays.sort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));

        // Copy
        int[] copy = Arrays.copyOf(arr, arr.length);
        System.out.println("Copy: " + Arrays.toString(copy));

        // Search
        int index = Arrays.binarySearch(arr, 3);
        System.out.println("Index of 3: " + index);

        // Compare : compare if both array are equal , has same elements
        int[] arr2 = {1, 2, 3, 5, 8};
        System.out.println("Arrays equal? " + Arrays.equals(arr, arr2));

        // To check if two arrays are the same reference
        System.out.println("Same reference? " + (arr == copy));

        int[] another = arr;

        System.out.println(arr);
        System.out.println(another);
        System.out.println(arr == another);

        arr[2] = 10;    //they have the same reference

        System.out.println(another[2]);
        //although we have changed arr[2],
        // since they have the same reference and they point to the same array,
        //another[2] is also 10

    }
}
