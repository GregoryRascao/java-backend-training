package livecoding.a;
import java.util.Scanner;
public class Exercice1 {

    public static int readPositiveInt(Scanner scanner){
        while (true) {
            System.out.println("Enter a positive integer: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input");
                scanner.next();
                continue;
            }

            int number = scanner.nextInt();

            if (number <= 0) {
                System.out.println("Must be > 0");
                continue;
            }
            return number;

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = readPositiveInt(scanner);
        System.out.println("you choose :" + number);

        scanner.close();
    }
}
