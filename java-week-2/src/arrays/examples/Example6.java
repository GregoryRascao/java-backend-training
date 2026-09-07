package arrays.examples;

/**
 * Example 6: Binary Search
 * -------------------------
 * Write a program that searches for a specific element in a sorted array using binary search.
 * Binary search divides the search interval in half each time, making it more efficient than linear search.
 * Think of arrays of big sizes, as array goes large, binary search becomes more and more efficient
 * For example it can find a value in 10 steps of a 1000 element array.
 * This efficiency is measured as time complexity.
 */

import java.util.Arrays;

public class Example6 {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 3};
        Arrays.sort(arr); // Binary search requires to be sorted array

        int key = 100;
        int index = Arrays.binarySearch(arr, key);
        System.out.println("if " + key + " were to be in the array, it would be in the index " + ((-1*index)-1));
        boolean isItThere = Arrays.binarySearch(arr, key) >= 0;

        System.out.println("isItThere " + isItThere);

        System.out.println("Sorted array: " + Arrays.toString(arr));

        // index == -1 means not found
        if (index != -1)
            System.out.println("Element found at index " + index);
        else
            System.out.println("Element not found");

    }
}
