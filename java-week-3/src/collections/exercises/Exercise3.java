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
        phoneBook.put("Bora", "123456798");
        phoneBook.put("Kien", "987654321");
        phoneBook.put("Carles", "654321354");


        String myPhoneNumber = phoneBook.get("Bora");

        System.out.println(myPhoneNumber);

        phoneBook.remove("Bora");


        printMap(phoneBook);
    }

    public static void printMap(Map<String, String> basel) {
        System.out.println("Writing with keySet and enhanced loop");
        for(String key : basel.keySet()) {
            System.out.print( basel.get(key) + " ");
        }
        System.out.println();
        System.out.println("Writing with entrySet and enhanced loop");
        for(Map.Entry<String, String> entry : basel.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println("Writing with forEach and lambda function");
        basel.forEach((key, value) -> System.out.println(key + "'s phone number is: " + value));
        System.out.println("Writing with toString method of Map");
        System.out.println(basel);
        System.out.println("Writing the values");
        for (String value : basel.values()) {
            System.out.println("value: " + value);
        }
    }

}
