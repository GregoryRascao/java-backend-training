/**
 * Serializes a simple object to a file.
 */

package serialization.examples;

import java.io.*;   //* is wildcard, but importing by class name is better than this.

class Student implements Serializable
{
    String name;
    int age;

    Student(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
}

public class Example1
{
    public static void main(String[] args)
    {
        Student malek = new Student("Malek", 22);

        String filename = "resources" + File.separator + "student.ser";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename)))
        {
            out.writeObject(malek);
            System.out.println("Student object serialized successfully!");
        }
        catch (IOException e)
        {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }
}