/**
 * 1. Append a new line to "daily_log.txt" each time the program runs.
 * 2. The line should follow CSV format: timestamp,level,message.
 * 3. Ask the user for level (INFO/WARN/ERROR) and message before writing.
 */

package writing.exercises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercise2
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter level (INFO/WARN/ERROR): ");
        String level = scanner.nextLine().trim().toUpperCase();

        System.out.println("Enter message: ");
        String message = scanner.nextLine();

        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("daily_log.txt", true));
            writer.write(level + ": " + message + ". " + timeStamp);
            writer.newLine();
            writer.close();

            System.out.println("All set");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            scanner.close();
        }

    }
}
