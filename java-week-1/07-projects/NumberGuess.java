import java.util.Scanner;

public class NumberGuess {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int randomNumber = (int)(Math.random() * 100) + 1;

        int userGuess;
        int userLives = 7;
        while(userLives > 0) {
            System.out.print("You have " + userLives + " lives remaining, enter your guess: ");
            if (scanner.hasNextInt()) {
                userGuess = scanner.nextInt();
                System.out.println(userGuess);
                if(userGuess == randomNumber) {
                    System.out.println("You found it!" + randomNumber);
                    // return;
                    break;
                }
                else if(userGuess > randomNumber) {
                    System.out.println("Your guess is bigger.");
                }
                else {
                    System.out.println("Your guess is smaller.");
                }
                userLives --;
            }
            else
            {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // discard invalid token
            }
        }
        //no if
        System.out.println("You lost, the number was: " + randomNumber);
        scanner.close();
    }
}


