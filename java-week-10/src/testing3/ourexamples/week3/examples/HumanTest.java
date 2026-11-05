package testing3.ourexamples.week3.examples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HumanTest
{
    private static int validAge;
    private Human currentHuman;

    @BeforeAll
    static void selectValidAge()
    {
        validAge = 25;
    }

    @BeforeEach
    void createHumanForScenario()
    {
        currentHuman = new Human();
    }

    @AfterAll
    static void clearValidAge()
    {
        validAge = 0;
    }

    @Test
    void setAgeStoresPositiveValue()
    {
        currentHuman.setAge(validAge);

        assertEquals(25, currentHuman.getAge());
    }

    @Test
    void negativeAgeDoesNotOverwriteExistingState()
    {
        currentHuman.setAge(18);
        currentHuman.setAge(-3);

        assertEquals(18, currentHuman.getAge());
    }
}