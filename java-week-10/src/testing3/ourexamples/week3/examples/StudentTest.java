package testing3.ourexamples.week3.examples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentTest
{
    private static String sharedStudentName;
    private Student enrolledStudent;

    @BeforeAll
    static void keepSharedStudentName()
    {
        sharedStudentName = "Catherine";
    }

    @BeforeEach
    void enrollFreshStudent() throws InvalidAgeException
    {
        enrolledStudent = new Student(sharedStudentName, 20);
    }

    @AfterAll
    static void dropSharedStudentName()
    {
        sharedStudentName = null;
    }

    @Test
    void constructorStoresValidValues() throws InvalidAgeException
    {
        assertAll(
                () -> assertEquals("Catherine", enrolledStudent.getName()),
                () -> assertEquals(20, enrolledStudent.getAge())
        );
    }

    @Test
    void setAgeAcceptsValidRange() throws InvalidAgeException
    {
        enrolledStudent.setAge(21);

        assertEquals(21, enrolledStudent.getAge());
    }

    @Test
    void setAgeRejectsInvalidValue()
    {
        assertThrows(InvalidAgeException.class, () -> enrolledStudent.setAge(130));
    }

    @Test
    void setNameRejectsBlankValue()
    {
        assertThrows(InvalidNameException.class, () -> enrolledStudent.setName("   "));
    }
}