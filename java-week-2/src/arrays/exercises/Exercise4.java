package arrays.exercises;

/**
 * Exercise 4: Array Operations
 * TODO:
 * 1. Create an array of 6 integers.
 * 2. Sort array.
 * 3. Copy into another array.
 * 4. Search for a value.
 * 5. Compare two arrays.
 */

import java.util.Arrays;
public class Exercise4 {
    public static void main(String[] args)
    {
        int[] sixInterger = {1,2,3,4,5,6};
        Arrays.sort(sixInterger);
        int[] sixInterger2 = Arrays.copyOf(sixInterger, sixInterger.length);
        
        int valueToFind = 4;
        int index = Arrays.binarySearch(sixInterger, valueToFind);
        if (index >=0) {
            System.out.println("Value found at index: " + index);
        }else{
            System.out.println("Value not found");
        }

        boolean areEqual = Arrays.equals(sixInterger, sixInterger2);
        System.out.println("Arrays are equal : " + areEqual);
        
    }
}

