/**
 * Example 8:
 * Demonstrates testing a method that filters lines by keyword.
 *
 * This example tests logic using in-memory data instead of a file.
 */

package reading.examples;

import java.util.List;
import java.util.stream.Stream;

public class Example8
{
    public static void main(String[] args)
    {
        List<String> lines = List.of(
                "Java is great",
                "SQL is marvellous",
                "I like JAVA streams",
                "Java and databases rock"
        );

        long result = countKeyword(lines.stream(), "java");

        long expected = 3;

        if (result == expected)
        {
            System.out.println("Test passed");
        }
        else
        {
            System.out.println("Test failed");
            System.out.println("Expected: " + expected + ", got: " + result);
        }
    }

    public static long countKeyword(Stream<String> lines, String keyword)
    {
        return lines
                .filter(line -> line.toLowerCase().contains(keyword.toLowerCase()))
                .count();
    }
}