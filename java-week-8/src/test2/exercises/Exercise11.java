package test2.exercises;

/**
 * Work in pairs
 * Test Driven Development practice
 * Implement a method that filters and normalizes email addresses.
 * Discuss what is a valid email address
 * We assume that we wirst write the tests, then write the code itself.
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

        //TODO why is it faulty, try to find and fix either test or the code
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
        // TODO: implement try to write regular expressions
        return List.of();
    }
}
