package arrays.exercises;

import java.util.Scanner;

/**
 * Exercise 5: Linear Search
 * TODO:
 * 1. Create an array of integers.
 * 2. Ask user for a number.
 * 3. Call linear search.
 * 4. Print index if found or "Not found".
 */
public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] linearInterger = { 1, 2, 5, 8, 10 };

        System.out.println("Please enter a number: ");

        if (scanner.hasNextInt()) {
            int numberToFind = scanner.nextInt();
            int foundIndex = -1;

            for (int i = 0; i < linearInterger.length; i++) {
                if (linearInterger[i] == numberToFind) {
                    foundIndex = i;
                    break;
                }
            }

            if (foundIndex != -1) {
                System.out.println("Number found at index: " + foundIndex);
            } else {
                System.out.println("Not found");
            }
        } else {
            System.out.println("Please enter an integer.");
        }
        scanner.close();

    }
}
