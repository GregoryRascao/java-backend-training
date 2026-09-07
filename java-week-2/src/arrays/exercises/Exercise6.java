package arrays.exercises;

/**
 * Exercise 6: Binary Search
 * TODO:
 * 1. Create and sort an array.
 * 2. Ask user for a number.
 * 3. Call binary search.
 * 4. Print result.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = { 8, 3, 10, 1, 5 };

        // Trier le tableau
        Arrays.sort(numbers);

        System.out.println("Please enter a number:");

        if (scanner.hasNextInt()) {
            int numberToFind = scanner.nextInt();

            // Rechercher dans le tableau trié
            int index = Arrays.binarySearch(numbers, numberToFind);

            if (index >= 0) {
                System.out.println("Number found at index: " + index);
            } else {
                System.out.println("Number not found");
            }
        } else {
            System.out.println("Please enter an integer.");
        }
        scanner.close();
    }
}
