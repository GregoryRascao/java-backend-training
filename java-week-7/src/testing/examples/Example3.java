/**
 * Example 3:
 * Testing edge cases and expected exceptions.
 *
 * Good tests do not only check normal inputs.
 * They also cover:
 *   - boundary values (0, empty string, negative numbers)
 *   - inputs that should cause the method to throw an exception
 *
 * assertThrows(ExceptionType.class, () -> ...)
 *   → passes if the lambda throws the expected exception
 *   → fails if no exception is thrown, or if a different exception is thrown
 */

package testing.examples;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Example3 {

    static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    // Normal case
    @Test
    void dividesTwoPositiveNumbers() {
        assertEquals(4, divide(8, 2));
    }

    // Boundary value
    @Test
    void zeroNumeratorReturnsZero() {
        assertEquals(0, divide(0, 5));
    }

    // Negative input
    @Test
    void dividesNegativeNumber() {
        assertEquals(-3, divide(-9, 3));
    }

    // Error case
    @Test
    void divideByZeroThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> divide(10, 0));
    }

}
