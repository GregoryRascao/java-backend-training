package exceptions.examples;

public class Example1
{
    public static void main(String[] args)
    {
        try
        {
            int result = 10 / 0; // risky code
        }
        catch (ArithmeticException e)
        {
            System.out.println("Error: Cannot divide by zero.");
        }
    }
}



