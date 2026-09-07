/**
 * This program demonstrates the use of if-else statements in Java.
 * ---------------------------------------------------------------
 */


public class IfElse
{
    public static void main(String[] args)
    {
        int number = 10;

        if (number > 0)
        {
            System.out.println("The number is positive.");
        }
        else if (number < 0)
        {
            System.out.println("The number is negative.");
        }
        else
        {
            System.out.println("The number is zero.");
        }

        //Using a boolean inside an if
        boolean myBool = true;
        if(myBool) {
            System.out.println("myBool is correct!");
        }
        else {
            System.out.println("My bool is wrong!");
        }
    }
}
