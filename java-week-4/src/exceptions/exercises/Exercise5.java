package exceptions.exercises;

import java.util.Scanner;

/**
 * Exercise 5:
 * Ask for a user’s age (simulate with variable).
 * If the age is negative, throw and catch a custom InvalidAgeException.
 */

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter you age..");
        int age = scanner.nextInt();
        try {
            if (age < 5) {
                throw new InvalidAgeException("Age to young");
            }

            System.out.println("You are so old");
        } catch (InvalidAgeException exception) {
            System.out.println("Erreur : " + exception.getMessage());
        }
        scanner.close();
    }
}
