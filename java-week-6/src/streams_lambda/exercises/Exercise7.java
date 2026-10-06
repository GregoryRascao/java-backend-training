/**
 * 1. Create a List<String> of names.
 * 2. Use a stream to filter names that start with 'A' or 'a'.
 * 3. Collect the result into a new list.
 * 4. Print the filtered list.
 */

package streams_lambda.exercises;

import java.util.List;

public class Exercise7
{
    public static void main(String[] args)
    {
        List<String> names = List.of("Ni", "ki", "ta", "abba");

        List<String> filterStrings = names.stream().filter(name -> name.startsWith("A")|| name.startsWith("a")).toList();
        System.out.println("filterString :" + filterStrings);
    }
}