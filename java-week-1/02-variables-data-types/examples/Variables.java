/**
 * Example of variable declaration, initialization, and printing in Java.
 * ---------------------------------------------------------------------
 * in Java we always need a class to run our code
 * public is an access modifier, which allows the class to be accessible from other classes
 * class is a keyword to declare a class
 * The name of the class must match the filename (Variables.java)
 * 
 * ---------------------------------------------------------------------
 * The main method is the entry point of any Java application.
 * public is an access modifier, which allows the method to be accessible from other classes
 * static means that the method belongs to the class, rather than an instance of the class
 * void means that the method does not return any value
 * main is the name of the method, it must be exactly "main" for the Java runtime to recognize it as the entry point
 * 
 * String[] args is a parameter that allows the program to accept command-line arguments
 * 
 * ---------------------------------------------------------------------
 * Variable declaration and initialization:
 * int myNumber = 10; declares an integer variable named myNumber and initializes it with the value 10
 * String myText = "Hello, World!"; declares a String variable named myText and initializes it with the value "Hello, World!"
 * double myDecimal = 5.99; declares a double variable named myDecimal and initializes it with the value 5.99
 * boolean myBoolean = true; declares a boolean variable named myBoolean and initializes it with the value true
 */

public class Variables
{
    public static void main(String[] args)
    {
        // Variable declaration and initialization
        int myNumber = 10;
        String myText = "Hello, World!";
        double myDecimal = 5.99;
        boolean myBoolean = true;

        // println variables to the console
        System.out.println("Integer: " + myNumber);
        System.out.println("String: " + myText);
        System.out.println("Double: " + myDecimal);
        System.out.println("Boolean: " + myBoolean);
    }
}
