package test2.exercises;

/**
 * Test Driven Development practice
 * Implement a method that filters and normalizes email addresses.
 * We assume that we wirst write the tests, than write the code itself
 */


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercise11    //EmailFilterTest
{
    @Test
    void filtersInvalidEmailsAndNormalizesValidOnes()
    {
        List<String> input = List.of(
                "  Alize@example.com ",
                "greg@example.com",
                "invalid-email",
                "carol@domain",
                "  DAVE@EXAMPLE.COM "
        );

        List<String> result = filterValidEmails(input);

        assertEquals(
                List.of("alize@example.com", "greg@example.com", "dave@example.com"),
                result
        );
    }

    @Test
    void returnsEmptyListWhenInputIsEmpty()
    {
        assertEquals(List.of(), filterValidEmails(List.of()));
    }

    @Test
    void ignoresNullOrBlankEmails()
    {
        List<String> input = List.of(" ", "", "   ");

        assertEquals(List.of(), filterValidEmails(input));
    }

    static List<String> filterValidEmails(List<String> emails)
    {
        // TODO: implement
        return List.of();
    }
}
