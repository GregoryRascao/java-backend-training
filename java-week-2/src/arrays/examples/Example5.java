package arrays.examples;

import java.util.Arrays;

/**
 * Example 5: Linear Search
 * -------------------------
 * Write a program that searches for a specific element in an array using linear search.
 * Linear search checks each element one by one until it finds the target or reaches the end of the array.
 * The array may have more than one matches with your key
 */

public class Example5 {
    public static void main(String[] args) {
        int[] arr = {4, 9, 9, 1, 9};
        int key = 9;
        //int index = -1;
        int[] indexes = new int[2]; //we need only 2 indexes
        int keysIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                indexes[keysIndex] = i;
                keysIndex++;
                if (keysIndex == indexes.length) { //a safety net
                    break;
                    //the idea is when we realize the program is going to crash, thats how  we save it from crashing
                }
            }
        }

        if (keysIndex > 0)
            System.out.println("Element found at indexes " + Arrays.toString(indexes));
        else
            System.out.println("Element not found");
    }
}
