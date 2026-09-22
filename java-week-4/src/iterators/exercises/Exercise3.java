package iterators.exercises;

import java.util.*;

/**
 * 1. Create a Set<String> names with several names (e.g. "Ali", "Sara", "Lina", "Amir", "Sami").
 * 2. Use an Iterator to remove all names that start with the letter 'A'.
 * 3. Print the set before and after removal.
 *
 */
public class Exercise3
{
    static void main(String[] args) {
        Set<String> names =  new HashSet<>(Arrays.asList("Ali", "Sara", "Lina", "Amir", "Sami"));

        Iterator<String> iterator = names.iterator();
        iterator.next();

        System.out.println("Before " + names);
        while (iterator.hasNext())
        {
            String name = iterator.next();
            if(name.startsWith("A")){
                iterator.remove();
            }
        }

        System.out.print("after " + names);
    }

}

