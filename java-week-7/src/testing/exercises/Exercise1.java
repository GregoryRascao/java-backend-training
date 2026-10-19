/**
 * Exercise 1:
 * Write a method and test it with JUnit.
 *
 *
 * 1. Implement the method multiply(int a, int b) that returns a * b.
 * 2. Write at least three @Test methods:
 *    - multiplies two positive numbers
 *    - multiplies by zero (result should be 0)
 *    - multiplies a positive and a negative number
 */

package testing.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise1
{
    static int multiply(int a, int b)
    {

        return 0;
    }

    // TODO: write your @Test methods here
    @Test
    void multipliesTwoPositiveNumbers() {
        assertEquals(15, multiply(3, 5));
    }

    @Test
    void multipliesByZero() {
        assertEquals(0, multiply(8, 0));
    }

    @Test
    void multipliesPositiveAndNegativeNumbers() {
        assertEquals(-12, multiply(3, -4));
    }
}