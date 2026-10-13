/**
 * Example 2:
 * Using different assertion methods.
 *
 * assertEquals  → checks that two values are equal
 * assertTrue    → checks that a condition is true
 * assertFalse   → checks that a condition is false
 * assertNotNull → checks that a value is not null
 *
 * Use the assertion that best matches what you are verifying.
 * A test should have one clear reason to fail.
 */

package testing.examples;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Example2
{
    static boolean isEven(int number)
    {
        return number % 2 == 0;
    }

    static String repeat(String text, int times)
    {
        return text.repeat(times);
    }

    @Test
    void fourIsEven()
    {
        assertTrue(isEven(4));
    }

    @Test
    void fiveIsNotEven()
    {
        assertFalse(isEven(5));
    }

    @Test
    void zeroIsEven()
    {
        assertTrue(isEven(0));
    }

    @Test
    void repeatBuildsCorrectString()
    {
        assertEquals("jajaja", repeat("ja", 3));
    }

    @Test
    void repeatReturnsNonNullResult()
    {
        assertNotNull(repeat("hi", 2));
    }
}
