import java.util.Scanner;

public class InputOuputE2 {

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        // Output examples
        System.out.print("This is printed without a newline. ");
        System.out.println("This is printed with a newline.");
        System.out.printf("Formatted number: %.2f%n", 12.879);

        // Input(using scanner)
        System.out.println("Exercice Input");
        System.out.println("-----Exercice 1-----");
        String line;
        System.out.print("Enter a line of Text: ");
        while (!scanner.hasNextLine()){
            System.out.println("Invalid line of text :");    
            scanner.next();
        } 
        line = scanner.nextLine();
        System.out.println("You entered : " + line);

        // Exercice 2
        System.out.println("----Exercice 2----");
        int number;
        System.out.println("Enter an Integer : ");
        if(!scanner.hasNextInt()){
            System.out.println("Invalid Output");
            System.out.println("Enter an Integer : ");
            scanner.next();
        }
        number = scanner.nextInt();
        System.out.println("You entered: " + number);

        // Exercice 3
        System.out.println("----Exercice 3----");
        double num;
        System.out.println("Please enter a double : ");
        if(!scanner.hasNextDouble()){
            System.out.println("Invalid Output");
            System.out.println("Enter a Double : ");
            scanner.next();
        }
        num = scanner.nextDouble();
        System.out.println("You enter the following double : " + num);


        // Exercice 3
        System.out.println("----Exercice 3----");
        String word;
        System.out.println("Please enter a word : ");
        if(!scanner.hasNext()){
            System.out.println("Invalid Output");
            System.out.println("Enter a word : ");
            scanner.next();
        }
        word = scanner.next();
        System.out.println("You enter the following word : " + word);

        scanner.close();


    }
}
