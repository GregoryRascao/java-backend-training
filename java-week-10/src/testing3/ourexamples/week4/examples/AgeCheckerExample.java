package testing3.ourexamples.week4.examples;

public class AgeCheckerExample
{
    static void checkAge(int age) throws InvalidAgeExceptionExample
    {
        if (age < 18)
        {
            throw new InvalidAgeExceptionExample("Age must be 18 or older.");
        }
    }
}

class InvalidAgeExceptionExample extends Exception
{
    public InvalidAgeExceptionExample(String message)
    {
        super(message);
    }
}