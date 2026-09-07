package projects;
import java.util.Scanner;

/*
    This is a refactoring project, delete the solution written down.
    Start with drawing a straight pyramid using stars. Get userInput from user.
    Ex:
    userInput=5
    *
    **
    ***
    ****
    *****

    After solving the problem, do these refactors one by one:
    * Put the code in a method if you haven't done it yet,
    * Implement an inverted pyramid
    * Implement a method for returning them instead of printing.
    * Take a look at your names of your variable and method names, are they self-explanatory?
    * Which methods should be private, which should be public?
        think if you need to write this class as a library for someone else.
    * Can you get rid of repeating lines?
 */

public class Pyramid {
    public static void main(String[] args){

        int userInput;
        boolean isStraight = false;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the input: ");
        if (scanner.hasNextInt()) {
            userInput = scanner.nextInt();
            printPyramid(userInput, isStraight);
        }
        else {
            System.out.println("Your input is not an integer.");
        }

        scanner.close();
    }

    public static void printPyramid(int userInput, boolean isStraight) {
        if (isStraight) {
            printPyramid(userInput);
        } else {
            printInvertedPyramid(userInput);
        }
    }

    private static void printInvertedPyramid(int userInput) {
        for (int i = userInput ; i > 0 ; i-- ) {
            for (int j = 0; j < i ; j++ ) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void printPyramid(int userInput) {
        for (int i = 1; i <= userInput;i++ ) {
            for (int j = 0; j < i ; j++ ) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }



}