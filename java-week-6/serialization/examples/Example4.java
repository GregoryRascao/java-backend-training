/**
 * Reads a list of Employee objects from a file.
*/

package serialization.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Example4
{
    public static void main(String[] args)
    {

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employees.ser")))
        {
            List<Employee> list = (List<Employee>) in.readObject();

            System.out.println("Deserialized Employee List:");
            for (Employee e : list)
            {
                System.out.println(e.name + " earns $" + e.salary);
            }
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
