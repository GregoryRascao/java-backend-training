// ### 4. 🧮 Multiplication Table Generator

// **Concepts used:** Loops, input/output.  

// - Ask the user for a number.  
// - Print its multiplication table (1–10) using a **for loop**.  
// - Example for input `5`:  

// ```bash
// 5 x 1 = 5
// 5 x 2 = 10
// ...
// 5 x 10 = 50
import java.util.Scanner;
public class Multiplicator {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int  userInput;
    System.out.println("Type your multiplication number");
    do {
        userInput = scanner.nextInt();

        System.out.println("Type your next mutiplication number :");

        System.out.println("To exit, type 0.");
    
        
        System.out.println("We print the multiplication table here !");
        printMultiplicationTable(userInput);
        scanner.nextLine();


    } while (scanner.hasNextInt() || userInput != 0);
    scanner.close();

}
    public static void printMultiplicationTable(int userInput){
        for (int counter = 0; counter <= 10; counter++) {
            // System.out.println(userInput + " x " + counter + " = " + counter * userInput);
            System.out.printf("%d x %2d = %2d%n", userInput, counter, (counter*userInput));
        }
    }
}
