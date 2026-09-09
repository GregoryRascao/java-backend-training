package collections.examples;

import java.util.HashMap;
import java.util.Map;

public class MapDemo
{
    public static void main(String[] args)
    {
        Map<String, Integer> ages = new HashMap<>();

        //  Adding key-value pairs
        ages.put("Alice", 25);
        ages.put("Bob", 30);
        ages.put("Charlie", 20);
        System.out.println("All ages: " + ages);

        //  Access value by key
        System.out.println("Alice's age: " + ages.get("Alice"));

        //  Remove by key
        ages.remove("Bob");
        System.out.println("After removing Bob: " + ages);

        //  Update value (put overwrites if key exists)
        ages.put("Alice", 26);
        System.out.println("After updating Alice's age: " + ages);

        //  putIfAbsent (won’t overwrite if key exists)
        ages.putIfAbsent("Charlie", 22);
        ages.putIfAbsent("David", 40);
        System.out.println("After putIfAbsent: " + ages);

        //  Check if map contains a key or value
        System.out.println("Contains key 'Alice'? " + ages.containsKey("Alice"));
        System.out.println("Contains value 40? " + ages.containsValue(40));

        //  Get size
        System.out.println("Map size: " + ages.size());

        //  Iterate through keys
        System.out.println("\nIterating with keySet:");
        for (String name : ages.keySet())
        {
            System.out.println(name + " is " + ages.get(name) + " years old");
        }

        //  Iterate through values
        System.out.println("\nIterating with values:");
        for (Integer age : ages.values())
        {
            System.out.println("Age: " + age);
        }

        //  Iterate through entries
        System.out.println("\nIterating with entrySet:");
        for (Map.Entry<String, Integer> entry : ages.entrySet())
        {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        //  Using forEach (lambda)
        System.out.println("\nIterating with forEach:");
        ages.forEach((name, age) ->
                System.out.println(name + " is " + age + " years old"));

        //  Replace a value
        ages.replace("Charlie", 25);
        System.out.println("After replacing Charlie's age: " + ages);

        //  Compute a value if present
        ages.computeIfPresent("Alice", (k, v) -> v + 1); // increment age
        System.out.println("After computing Alice's new age: " + ages);

        //  Get a value with default if key not found
        System.out.println("David's age (default): " + ages.getOrDefault("David", -1));
        System.out.println("Eve's age (default): " + ages.getOrDefault("Eve", -1));
        System.out.println("Eve's age with get: " + ages.get("Eve"));

        //  Clear the map
        ages.clear();
        System.out.println("After clearing map: " + ages);
        System.out.println("Is map empty? " + ages.isEmpty());
    }
}
