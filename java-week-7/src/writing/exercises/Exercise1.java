/**
 * 1. Ask the user to enter 3 messages.
 * 2. Save them to "messages.txt" with line numbers (e.g., "1: hello").
 * 3. Write an extra summary line: "Total messages: 3".
 */

package writing.exercises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("message.txt"));
            for (int i = 1; i <= 3; i++) {
                System.out.println("Enter a message " + i + " : ");
                String message = scanner.nextLine();

                writer.write(i + ": " + message);
                writer.newLine();
            }

            writer.close();
            System.out.println("All messages submitted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}