package collections.exercises;

import java.util.HashMap;
import java.util.Map;

/**
 1. Create a Map<String, String> phoneBook (name → phone number).
 2. Add 3 entries.
 3. Print all entries.
 4. Retrieve one number by name.
 5. Remove one entry.
 */
public class Exercise3 {
    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();

        phoneBook.put("Paul", "01231030");
        phoneBook.put("Ali", "01232543");
        phoneBook.put("Charlotte", "04365743");

        System.out.println("let's print entries :" + phoneBook);

        String aliNumber = phoneBook.get("Ali");
        System.out.println("Ali's number is :" + aliNumber);

        phoneBook.remove("Ali");
        System.out.println("Phone after delete :" + phoneBook);
    }
}
