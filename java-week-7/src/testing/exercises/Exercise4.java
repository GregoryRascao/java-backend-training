/**
 * Exercise 4:
 * Use @BeforeEach to share setup logic across tests.
 *
 * TODO:
 * 1. Add a field: List<Integer> scores
 * 2. In a @BeforeEach method, initialize it with: 80, 45, 92, 67, 55
 * 3. Implement the following methods:
 *    - average(List<Integer> scores)  → returns the average as a double
 *    - countPassing(List<Integer> scores) → returns how many scores are >= 60
 * 4. Write @Test methods that use the shared list to verify:
 *    - the average of the list
 *    - the number of passing scores
 *    - that adding a new score changes the average
 *
 * Tip: use assertEquals with a delta for double comparisons:
 *   assertEquals(expected, actual, 0.01)
 */

package testing.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class Exercise4
{
    List<Integer> scores;

    @BeforeEach
    void setUp()
    {
        // TODO: initialize scores with 80, 45, 92, 67, 55
    }

    static double average(List<Integer> scores)
    {
        // TODO: implement
        return 0;
    }

    static long countPassing(List<Integer> scores)
    {
        // TODO: implement
        return 0;
    }

    // TODO: write your @Test methods here
}
