/**
 * 1. Create a record named Student.
 * 2. Print component values using accessor methods.
 * 3. Print the record object directly.
 * 4. Show equality check between two records.
 */

package modern.examples;

public class Example6
{
    record Student(String name, int age)
    {
    }

    public static void main(String[] args)
    {
        Student firstStudent = new Student("Kien", 24);
        Student secondStudent = new Student("Lin", 24);

        System.out.println("Name: " + firstStudent.name());
        System.out.println("Age: " + firstStudent.age());
        System.out.println("Student: " + firstStudent);
        System.out.println("Equal objects: " + firstStudent.equals(secondStudent));
    }
}
