package iterators.exercises;


import java.util.*;

/**
 * 1. Create a List<String> animals containing at least 5 animal names.
 * 2. Use a for-each loop to print each animal in uppercase letters.
 * 3. Add a message like: "Animal name: LION"
 * 4. Use an iterator to remove any animal names that contain the letter 'a'.
 * 5. Print the modified list using a for-each loop.
 */
public class Exercise1
{
    static void main(String[] args) {
        List<String> animals = new ArrayList<>(Arrays.asList("cat", "dog", "turtle", "Bird"));

        for (String animal : animals) {
            System.out.println("Animal name: " + animal.toUpperCase());
        }

        animals.removeIf(animal -> animal.toLowerCase().contains("a"));

        for (String animal : animals) {
            System.out.println("Animal name after removing : " + animal.toUpperCase());
        }

    }
}


