package collections.exercises;

import java.util.List;
import java.util.ArrayList;

/**
 * Exercise:
 * 1. Create a List<String> shoppingList.
 * 2. Add 5 items.
 * 3. Remove one item.
 * 4. Print the final list.
 */

public class Exercise1 {
    public static void main(String[] args) {
        List<String> shoppingList = new ArrayList<>();
        shoppingList.add("Bread");
        shoppingList.add("Milk");
        shoppingList.add("Eggs");
        shoppingList.add("Apples");
        shoppingList.add("Cheese");

        shoppingList.remove("Eggs");

        System.out.println(shoppingList);
    }
}
