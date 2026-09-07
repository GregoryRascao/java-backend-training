import java.io.Console;

/**
 * Exercises:
 * ----------------------------------------------------------------
 * 1. Create a short variable with any value and assign it to an int (implicit).
 * 2. Create an int variable with a large value and assign it to a long (implicit).
 * 3. Create a long variable and assign it to a float (implicit).
 *
 * 4. Create a double variable and cast it to a float (explicit).
 * 5. Create an int variable and cast it to a short (explicit).
 * 6. Create a long variable and cast it to a byte (explicit).
 *
 * Bonus:
 * 7. Try converting a large int (e.g., 1000) to a byte and observe what happens (overflow).
 * 8. Convert a char (e.g., 'Z') into an int and print its ASCII value.
 * 9. Convert an int into a char and print the resulting character.
 * 10. Create a double with decimals, convert it to int, and explain what happens.
 * ----------------------------------------------------------------
 */

public class ConversionE
{
    public static void main(String[] args)
    {
        // --- Implicit Conversions (Widening) ---
        int intValue = 100;
        double widenedDouble = intValue; // int to double
        char letter = 'A';
        int widenedInt = letter;         // char to int (ASCII/Unicode value)

        System.out.println("=== Implicit (Widening) Conversions ===");
        System.out.println("int (" + intValue + ") → double: " + widenedDouble);
        System.out.println("char ('" + letter + "') → int: " + widenedInt);

        // --- Explicit Conversions (Narrowing) ---
        double doubleValue = 9.78;
        int narrowedInt = (int) doubleValue; // double to int (fraction lost)
        float floatValue = 130.75f;
        byte narrowedByte = (byte) floatValue; // float to byte (overflow possible)

        System.out.println("\n=== Explicit (Narrowing) Conversions ===");
        System.out.println("double (" + doubleValue + ") → int: " + narrowedInt);
        System.out.println("float (" + floatValue + ") → byte: " + narrowedByte);

        // -------------------- Student Exercises --------------------
        // 1. Create a short variable with any value and assign it to an int (implicit)
        short shortValue = 25;
        int intShortValue = shortValue;
        System.out.println("short to int: " + intShortValue);

        // 2. Create an int variable with a large value and assign it to a long (implicit)
        int largeValue = 100000;
        long longLargeValue = largeValue;
        System.out.println("int to long: " + longLargeValue);

        // 3. Create a long variable and assign it to a float (implicit)
        long myVar = 40938;
        float floatMyVar = myVar;
        System.out.println("var to float :" + floatMyVar);

        // 4. Create a double variable and cast it to a float (explicit)
        double myVar2 = 40.99;
        float floatMyVar2 = (float) myVar2;
        System.out.println("double to float :" + floatMyVar2);

        // 5. Create an int variable and cast it to a short (explicit)
        int intVar = 2;
        short shortIntVar = (short) intVar;
        System.out.println("int to var:" + shortIntVar);

        // 6. Create a long variable and cast it to a byte (explicit)
        long longNumber = 502311;
        byte byteLongNumber = (byte) longNumber;
        System.out.println("long to byte :" + byteLongNumber);

        // 7. Try converting a large int (e.g., 1000) to a byte and print the result
        int bigNumber = 1000;
        byte byteResult = (byte) bigNumber;
        System.out.println("int 1000 → byte: " + byteResult);

        // 8. Convert a char (e.g., 'Z') into an int and print its ASCII value
        char character = 'Z';
        int asciiValue = character;
        System.out.println("char 'Z' → int: " + asciiValue);

        // 9. Convert an int into a char and print the resulting character
        int characterCode = 65;
        char convertedChar = (char) characterCode;
        System.out.println("int 65 → char: " + convertedChar);

        // 10. Create a double with decimals, convert it to int, and print the result
        double decimalNumber = 45.99;
        int integerResult = (int) decimalNumber;
        System.out.println("double 45.99 → int: " + integerResult);
    }
}
