/**
 * 1. Ask the user for 5 grocery items.
 * 2. Remove duplicates and sort alphabetically using streams.
 * 3. Write the cleaned list to "shopping_list.txt".
 * 4. Print how many unique items were saved.
 */

package writing.exercises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise3
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<String> items = new ArrayList<>();

        for (int i = 1; i < 5; i++) {
            System.out.println("Grocery items " + i + ": ");
            String item =  scanner.nextLine().trim();

            if (!item.isEmpty()) {
                items.add(item);
            }
        }

        List<String> cleanedList = items.stream().map(String::trim).map(String::toLowerCase).distinct().sorted().collect(Collectors.toList());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("shopping.txt"))){
            for (String item : cleanedList) {
                writer.write(item);
                writer.newLine();
                System.out.println("List saved!" + cleanedList.size());
            }
        } catch (Exception e) {
           System.out.println("Error :" + e.getMessage());
        } finally{
            scanner.close();
        }
    }

}
