/**
 * Exercises:
 * -----------------------------------------------------------------
 * 1. Create an int variable called age and assign it your age.
 * 2. Create a double variable called temperature and assign it any decimal number.
 * 3. Create a char variable called gradeLetter and assign it a letter (e.g., 'B').
 * 4. Create a boolean variable called isJavaFun and assign it true or false.
 *
 * 5. Create a String variable called favoriteColor and assign it any color.
 * 6. Create an array of type int called numbers with at least 5 values, then print them.
 * 7. Change one of the values inside the array and print the updated array.
 *
 * Bonus:
 * 8. Create a String array with 3 of your favorite foods and print them in a loop.
 * 9. Create two double variables, add them together, and print the result.
 * 10. Use String concatenation to print a sentence like: "My name is John and I am 20 years old."
 * -----------------------------------------------------------------
 */

public class DataTypesE
{
    public static void main(String[] args)
    {
        // --- Primitive Data Types ---
        int myInt = 10;
        double myDouble = 10.5;
        char myChar = 'A';
        boolean myBoolean = true;

        // --- Non-Primitive Data Types ---
        String myString = "Hello, World!";
        int[] grades = {90, 85, 88};

        // --- Displaying the values ---
        System.out.println("=== Primitive Data Types ===");
        System.out.println("Integer: " + myInt);
        System.out.println("Double: " + myDouble);
        System.out.println("Character: " + myChar);
        System.out.println("Boolean: " + myBoolean);

        System.out.println("\n=== Non-Primitive Data Types ===");
        System.out.println("String: " + myString);
        System.out.print("Array of grades: ");
        for (int grade : grades)
        {
            System.out.print(grade + " ");
        }
        System.out.println();

        // -------------------- Student Exercises --------------------
        // 1. Create an int variable called age and assign it your age
        int age = 42;


        // 2. Create a double variable called temperature and assign it any decimal
        double temperature = 21.5;


        // 3. Create a char variable called gradeLetter and assign it a letter
        char gradeLetter = 'A';


        // 4. Create a boolean variable called isJavaFun and assign true or false
        boolean isJavaFun = true;


        // 5. Create a String variable called favoriteColor and assign it a color
        String favoriteColor = "Blue";


        // Display exercises 1 to 5 to 5 ===");

        System.out.println("Age: " + age);
        System.out.println("Temperature: " + temperature);
        System.out.println("Grade letter: " + gradeLetter);
        System.out.println("Is Java fun? " + isJavaFun);
        System.out.println("Favorite color: " + favoriteColor);


        // 6. Create an int array called numbers with at least 5 values,
        // then print them
        int[] numbers = {10, 20, 30, 40, 50};

        

        for (int number : numbers)
        {
            System.out.print(number + " ");
        }

        System.out.println();


        // 7. Change one value inside numbers and print the updated array
        numbers[2] = 99;

        

        for (int number : numbers)
        {
            System.out.print(number + " ");
        }

        System.out.println();


        // 8. Create a String array with 3 favorite foods
        // and print them in a loop
        String[] favoriteFoods = {"Pizza", "Pasta", "Sushi"};

        

        for (String food : favoriteFoods)
        {
            System.out.println(food);
        }


        // 9. Create two double variables, add them together,
        // and print the result
        double number1 = 10.5;
        double number2 = 5.2;

        double result = number1 + number2;

        
        System.out.println(number1 + " + " + number2 + " = " + result);


        // 10. Use String concatenation

        String name = "Gregory";

        System.out.println(
            "My name is " + name + " and I am " + age + " years old."
        );
    }
}
