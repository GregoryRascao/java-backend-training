/**
 * Example 1:
 * The simplest possible JUnit test.
 *
 * Compare this to reading/examples/Example7.java.
 * That example used a manual if/else check to verify a result.
 * Here we use @Test and assertEquals instead — no output to read by hand.
 *
 * @Test         → JUnit will discover and run this method automatically.
 * assertEquals  → fails the test if the two values are not equal.
 *
 * Run this class in IntelliJ with the green play button next to the class name.
 * A green tick means the test passed. A red cross means it failed.
 */

package testing.examples;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example1 {

    static int add(int a, int b)
    {
        return a + b;
    }

    @Test
    void addsTwoPositiveNumbers()
    {
        assertEquals(5, add(2, 3));
    }

    @Test
    void addsNegativeNumber()
    {
        assertEquals(1, add(3, -2));
    }

    @Test
    void addingZeroReturnsOriginal()
    {
        assertEquals(7, add(7, 0));
    }
}
