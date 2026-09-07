import java.util.Scanner;

public class DetermineInputType {

    public static void main(String[] args) {

        Scanner scannerObject = new Scanner(System.in);

        // Output examples
        System.out.print("This is printed without a newline. ");
        System.out.println("This is printed with a newline.");
        System.out.printf("Formatted number: %.2f%n", 123.456);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter something: ");

            if (scanner.hasNextInt() ) {
                System.out.println("Integer: " + scanner.nextInt());
                scanner.nextLine();
            }
            else if (scanner.hasNextDouble()) {
                System.out.println("Double: " + scanner.nextDouble());
                scanner.nextLine();
            }
            else {
                String line = scanner.nextLine();
                if(line.equals("quit")) break;
                if (line.contains(" ")) {
                    System.out.println("Line: " + line);
                } else {
                    System.out.println("Word: " + line);
                }
            }
        }

        scannerObject.close();
    }
}
