/**
 * Demonstrates the use of 'transient' to skip serialization of sensitive fields.
 */

package serialization.examples;
import java.io.*;

class Account implements Serializable
{
    String username;
    transient String password; // not serialized

    Account(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
}

public class Example5
{
    public static void main(String[] args)
    {
        String filePath = "resources" + File.separator + "account.ser";
        Account acc = new Account("user1", "mySecretPassword");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath)))
        {
            out.writeObject(acc);
            System.out.println("Account serialized!");
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }

        // Deserialize
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream( filePath)))
        {
            Account restored = (Account) in.readObject();
            System.out.println("Deserialized Account:");
            System.out.println("Username: " + restored.username);
            System.out.println("Password: " + restored.password); // will be null
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}