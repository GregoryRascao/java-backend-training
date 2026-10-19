package test2.exercises;

/**
 * Reverse challenge: Try to guess what the code should do
 * Work in pairs
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseChallenge2 {

    @TempDir
    Path tempDir;

    @Test
    void shouldWriteSortedCities() throws IOException {
        Path output = tempDir.resolve("cities.txt");

        /*uncomment this
        saveSortedCities(output, List.of(
                " Ghent ",
                "",
                "Brussels",
                "Antwerp",
                "  bruges "
        ));

         */

        assertEquals(
                List.of("ANTWERP", "BRUGES", "BRUSSELS", "GHENT"),
                Files.readAllLines(output)
        );
    }
}

/**
 * Hints:
 * What to focus on
 *
 * Compare input vs expected output:
 *
 * order is different
 * formatting is different
 * Questions to ask yourself
 * Are empty values included?
 * Is sorting applied?
 * Why is everything uppercase?
 *
 * Important question:
 *  Is the order random or predictable?
 */