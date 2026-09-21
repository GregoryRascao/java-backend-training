package exceptions.examples;

public class Example4
{
    public static void main(String[] args)
    {
        try
        {
            checkAge(15); // will throw custom exception
        }
        catch (InvalidAgeException e)
        {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    static void checkAge(int age) throws InvalidAgeException
    {
        if (age < 18)
        {
            throw new InvalidAgeException("Age must be 18 or older.");
        }
    }
}

// Example 4: Creating and using a custom exception
class InvalidAgeException extends Exception
{
    public InvalidAgeException(String message)
    {
        super(message);
    }
}