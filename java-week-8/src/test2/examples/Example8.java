/**
 * Example 8:
 * Using parameterized tests to run the same idea with different inputs.
 */

package test2.examples;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example8
{
    static int countVowels(String text)
    {
        return text.replaceAll("(?i)[^aeiou]", "").length();
    }

    @ParameterizedTest
    @CsvSource({
            "BrUssels,2",
            "Antwerp,2",
            "Ghent,1",
            "Leuven,3"
    })
    void countsVowelsWithDifferentInputs(String text, int expected)
    {
        assertEquals(expected, countVowels(text));
    }
}