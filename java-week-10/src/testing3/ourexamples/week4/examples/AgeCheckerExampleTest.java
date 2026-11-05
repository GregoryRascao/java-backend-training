package testing3.ourexamples.week4.examples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AgeCheckerExampleTest
{
    private static AgeCheckerExample ageChecker;

    @BeforeAll
    static void setUpSuite()
    {
        ageChecker = new AgeCheckerExample();
    }

    @BeforeEach
    void setUp()
    {
        ageChecker = new AgeCheckerExample();
    }

    @AfterEach
    void tearDown()
    {
        ageChecker = null;
    }

    @AfterAll
    static void tearDownSuite()
    {
        ageChecker = null;
    }

    @Test
    void checkAgeAllowsAdults()
    {
        assertDoesNotThrow(() -> ageChecker.checkAge(18));
    }

    @Test
    void checkAgeThrowsForUnderageInput()
    {
        InvalidAgeExceptionExample exception = assertThrows(
                InvalidAgeExceptionExample.class,
                () -> ageChecker.checkAge(15)
        );

        assertEquals("Age must be 18 or older.", exception.getMessage());
    }
}