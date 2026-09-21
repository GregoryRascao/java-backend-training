package exceptions.exercises;

/**
 *  Exercise 4:
 *  Parse a string into an integer.
 *  If the string is not a number (e.g., "abc"),
 *  catch NumberFormatException.
 *  How would you let the user know about the exception
 *  On an exception, would you give a value as default?
 */

public class Exercise4 {
    public static void main(String[] args) {
        String text = "abc";
        int number;

        try {
            number = Integer.parseInt(text);
            System.out.println("conversion :" + number);
        } catch (NumberFormatException e) {
            System.out.println("Error : \"" + text + "\" is not a valid number.");

            number = 0;
            System.out.println("Default value :" + number);
        }
    }
}




