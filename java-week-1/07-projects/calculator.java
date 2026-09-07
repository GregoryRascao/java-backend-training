// 📝 Project Ideas
// 1. 📏 Simple Calculator
// Concepts used: Variables, operators, input/output.

// Ask the user to enter two numbers.
// Ask for an operation (+, -, *, /).
// Use an if-else or switch to perform the correct calculation.
// Print the result.
import java.util.Scanner;

public class calculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int number1;
        int number2;
        while (true) {
            System.out.println("Enter Two numbers : ");
            if(scanner.hasNextInt()){
                number1 = scanner.nextInt();
                number2 = scanner.nextInt();
                scanner.nextLine();
                break;
            }else{
                System.out.println("invalid number :");
                scanner.next();
            }
            
        }
        System.out.println("You entered: " + number1 + " " + number2);

        // ask for the operator
        System.out.println("Wich operator did you want ? ");
        String operator = scanner.nextLine();
        int num;
        switch (operator) {
            case "+":
                num = number1 + number2;
                break;
            case "/":
                num = (number1 / number2);
                break;
            case "*":
                num = (number1 * number2);
                break;
            case "-":
                num = (number1 - number2);
                break;
        
            default:
                System.out.println("invalid format :");
                num = 0;
                break;
        }

        System.out.println("this is the result :" + num);

        scanner.close();
    }
}
