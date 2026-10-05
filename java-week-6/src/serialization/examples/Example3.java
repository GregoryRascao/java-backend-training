/**
 * Serializes multiple objects into one file.
 */

package serialization.examples;

import java.io.*;
import java.util.Arrays;
import java.util.List;

class Employee implements Serializable
{
    String name;
    double salary;

    Employee(String name, double salary)
    {
        this.name = name;
        this.salary = salary;
    }
}

public class Example3
{
    public static void main(String[] args)
    {
        List<Employee> employees = Arrays.asList(
                new Employee("Samira", 50000),
                new Employee("Charlotte", 60000),
                new Employee("Ulpan", 55000)
        );

        String filePath = "resources" + File.separator + "employees.ser";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath)))
        {
            out.writeObject(employees);     //this is serialization
            System.out.println("Employee list serialized successfully!");
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}