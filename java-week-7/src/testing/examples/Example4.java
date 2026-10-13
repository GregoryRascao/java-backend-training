/**
 * Example 4:
 * Using @BeforeEach to share setup logic across tests.
 *
 * When multiple tests need the same starting state,
 * put that setup in a method annotated with @BeforeEach.
 * JUnit runs it automatically before every single @Test method.
 *
 * This avoids repeating the same setup lines in every test,
 * and ensures each test starts with a fresh, identical state.
 */

package testing.examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class Example4 {
    List<String> names;

    @BeforeEach
    void setUp()
    {
        names = new ArrayList<>();
        names.add("Jonathan");
        names.add("Alisan");
        names.add("Julie");
    }

    @Test
    void listHasThreeElements()
    {
        assertEquals(3, names.size());
    }

    @Test
    void listContainsAlice()
    {
        assertTrue(names.contains("Jonathan"));
    }

    @Test
    void removingElementReducesSize()
    {
        names.remove("Alisan");
        assertEquals(2, names.size());
    }

    @Test
    void listDoesNotContainUnknownName()
    {
        assertFalse(names.contains("Julie"));
    }
}
