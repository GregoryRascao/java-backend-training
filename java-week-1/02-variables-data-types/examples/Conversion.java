/**
 * Type Conversion in Java
 * -----------------------
 * This program demonstrates both implicit (widening) and explicit (narrowing)
 * type conversions in Java.
 *
 * 1. Implicit Conversion (Widening):
 *    - Happens automatically when a smaller type is assigned to a larger type.
 *    - byte → short → int → long → float → double
 *
 * 2. Explicit Conversion (Narrowing):
 *    - Must be done manually using casting.
 *    - double → float → long → int → short → byte
 *
 * Demonstrated Conversions:
 * - int → double (widening)
 * - char → int (widening)
 * - double → int (narrowing)
 * - float → byte (narrowing)
 * - long → double (widening, but very large values can lose precision)
 * - double → long (narrowing, removes the decimal part)
 */

public class Conversion 
{
    public static void main(String[] args) 
    {
        // --- Implicit Conversions (Widening) ---
        int intValue = 100;
        double widenedDouble = intValue; // int to double
        char letter = 'A';
        int widenedInt = letter;         // char to int (ASCII/Unicode value)

        System.out.println("=== Implicit (Widening) Conversions ===");
        System.out.println("int (" + intValue + ") is converted to double: " + widenedDouble);
        System.out.println("char ('" + letter + "') is converted to int: " + widenedInt);

        // --- Explicit Conversions (Narrowing) ---
        double doubleValue = -9.78;
        int narrowedInt = (int) doubleValue; // double to int (fraction lost)
        float floatValue = 128.001f;
        byte narrowedByte = (byte) floatValue; // float to byte (overflow possible)

        System.out.println("\n=== Explicit (Narrowing) Conversions ===");
        System.out.println("double (" + doubleValue + ") → int: " + narrowedInt);
        System.out.println("float (" + floatValue + ") → byte: " + narrowedByte);

        // long and double both use 8 bytes (64 bits), but store numbers differently.
        // A long stores whole numbers exactly; a double stores decimal numbers.
        System.out.println("long bytes: " + Long.BYTES);
        System.out.println("double bytes: " + Double.BYTES);

        long wholeNumber = 42L;
        double longAsDouble = wholeNumber; // Widening: Java does this automatically.
        System.out.println("long " + wholeNumber + " as a double: " + longAsDouble);

        double decimalNumber = 42.9;
        // Casting is required because converting to long removes information.
        // The cast truncates toward zero; it does not round.
        long doubleAsLong = (long) decimalNumber;
        System.out.println("double " + decimalNumber + " as a long: " + doubleAsLong);

        //Narrowing conversions may change the value
        long myBigNumber = 100_000;
        short mySmallNumber = (short) myBigNumber;
        System.out.println("Lets see the short number: " + mySmallNumber);


    }
}
