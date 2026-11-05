package testing3.ourexamples.week5.examples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VarArgsSumExampleTest
{
    private static int[] sharedNumbers;
    private int[] numbers;

    @BeforeAll
    static void setUpSuite()
    {
        sharedNumbers = new int[]{1, 2, 3, 4};
    }

    @BeforeEach
    void setUp()
    {
        numbers = sharedNumbers.clone();
    }

    @AfterAll
    static void tearDownSuite()
    {
        sharedNumbers = null;
    }

    @Test
    void sumReturnsTotalForMultipleNumbers()
    {
        assertEquals(10, VarArgsSumExample.sum(numbers));
    }

    @Test
    void sumHandlesNoArgumentsAndNegativeValues()
    {
        assertAll(
                () -> assertEquals(0, VarArgsSumExample.sum()),
                () -> assertEquals(2, VarArgsSumExample.sum(5, -3, 0))
        );
    }
}