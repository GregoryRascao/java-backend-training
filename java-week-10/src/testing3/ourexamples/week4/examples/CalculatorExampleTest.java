package testing3.ourexamples.week4.examples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorExampleTest
{
    private static CalculatorExample sharedCalculator;
    private CalculatorExample calculator;

    @BeforeAll
    static void setUpSuite()
    {
        sharedCalculator = new CalculatorExample();
    }

    @BeforeEach
    void setUp()
    {
        calculator = sharedCalculator;
    }

    @AfterEach
    void tearDown()
    {
        calculator = null;
    }

    @AfterAll
    static void tearDownSuite()
    {
        sharedCalculator = null;
    }

    @Test
    void addWithTwoIntegersReturnsSum()
    {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void addWithTwoDoublesReturnsSum()
    {
        assertEquals(6.0, calculator.add(2.5, 3.5));
    }

    @Test
    void addWithThreeIntegersReturnsSum()
    {
        assertAll(
                () -> assertEquals(6, calculator.add(1, 2, 3)),
                () -> assertEquals(0, calculator.add(-1, 1, 0))
        );
    }
}