/**
 * Exercise 8:
 * Practice parameterized tests.
 *
 * TODO:
 * 1. Implement countWords(String text).
 *    - Trim the text
 *    - If it is empty, return 0
 *    - Otherwise count words by splitting on one or more whitespace characters
 * 2. Write a @ParameterizedTest using @CsvSource.
 * 3. Test at least these cases:
 *    - "Brussels is busy" -> 3
 *    - "  Ghent   is beautiful  " -> 3
 *    - "" -> 0
 *    - "Leuven" -> 1
 *
 * Work in pairs
 */

package test2.exercises;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise8
{
    static int countWords(String text)
    {
        // TODO: implement
        return 0;
    }

    // TODO: write your parameterized test here
}

// Common mistakes:
// - forgetting trim()
// - using split(" ") instead of "\\s+"
// - not handling empty input