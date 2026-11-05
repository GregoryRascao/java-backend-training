package testing3.ourexamples.week5.examples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonRecordExampleTest
{
    private static String validName;
    private PersonRecordExample person;

    @BeforeAll
    static void setUpSuite()
    {
        validName = "Ada Lovelace";
    }

    @BeforeEach
    void setUp()
    {
        person = new PersonRecordExample(28, validName);
    }

    @AfterAll
    static void tearDownSuite()
    {
        validName = null;
    }

    @Test
    void recordStoresValuesAndExtractsSurname()
    {
        assertAll(
                () -> assertEquals(28, person.age()),
                () -> assertEquals("Ada Lovelace", person.name()),
                () -> assertEquals("Lovelace", person.getSurname())
        );
    }

    @Test
    void recordRejectsInvalidData()
    {
        IllegalArgumentException blankName = assertThrows(
                IllegalArgumentException.class,
                () -> new PersonRecordExample(20, " ")
        );

        IllegalArgumentException negativeAge = assertThrows(
                IllegalArgumentException.class,
                () -> new PersonRecordExample(-1, "Ada Lovelace")
        );

        assertAll(
                () -> assertEquals("Username cannot be blank", blankName.getMessage()),
                () -> assertEquals("Age cannot be negative", negativeAge.getMessage())
        );
    }
}