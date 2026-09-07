// 📅 Day of the Week Finder

// **Concepts used:** Switch statement, input/output.  

// - Ask the user to enter a number (1–7).  
// - Use a **switch** to print the day of the week (1 = Monday, … 7 = Sunday).  
// - Handle invalid input gracefully.
import java.util.Scanner;

public class dayFinder {
    static public void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Please enter a number between 1 - 7 :");
            
            if(scanner.hasNextInt()){
                int userChoise = scanner.nextInt();

                if (userChoise >= 1 && userChoise <= 7) {
                switch (userChoise) {
                    case 1:
                        System.out.println("The day 1 is the Monday !");
                        break;
                    case 2:
                        System.out.println("The day 2 is the Thuesday !");
                        break;
                    case 3:
                        System.out.println("The day 3 is the Wednesday !");
                        break;
                    case 4:
                        System.out.println("The day 4 is the Thirsday !");
                        break;
                    case 5:
                        System.out.println("The day 5 is the Friday !");
                        break;
                    case 6:
                        System.out.println("The day 6 is the Saturday !");
                        break;
                    case 7:
                        System.out.println("The day 7 is the Sunday !");
                        break;
            
                    default:
                        break;
                }
                return;
                } else {
                    System.out.println("The number must be between 1 and 7.");
                }

            } else {
                System.out.println("Is not an integer, please try again.");
                scanner.next();
            }
            scanner.close();
        }
    }
}
