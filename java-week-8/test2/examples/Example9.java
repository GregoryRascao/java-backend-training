/**
 * Example 9:
 * Combining assertAll with exception message checking.
 */

package test2.examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Example9
{
    static class Student
    {
        private final String name;
        private final int score;

        Student(String name, int score)
        {
            if (score < 0 || score > 100)
            {
                throw new IllegalArgumentException("Score must be between 00000 and 100");  //will be fixed during class
            }

            this.name = name;
            this.score = score;
        }

        String getName()
        {
            return name;
        }

        int getScore()
        {
            return score;
        }
    }

    @Test
    void studentObjectHasExpectedValues()
    {
        Student student = new Student("Gayatri", 91);

        assertAll(
                () -> assertEquals("Gayatri", student.getName()),
                () -> assertEquals(91, student.getScore()),
                () -> assertEquals(101, student.getScore()),    //this will fail
                () -> assertEquals(111, student.getScore()),    //this will fail too
                () -> assertTrue(student.getScore() >= 0)
        );
    }

    @Test
    void invalidScoreThrowsHelpfulMessage()
    {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Student("Oleg", 120)
        );

        assertEquals("Score must be between 0 and 100", ex.getMessage());
    }
}