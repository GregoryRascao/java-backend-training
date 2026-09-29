/**
 * 1. Create a String array with at least 4 names, including two names of equal length.
 * 2. Use an anonymous Comparator<String> to sort names by length, and alphabetically when two names have the same length.
 * 3. Print the sorted array.
 */

package modern.exercises;

import java.util.Arrays;
import java.util.Comparator;

public class Exercise4 {
    public static void main(String[] args) {
        String[] names = { "jacky", "jean-paul", "Frederic", "Brian", "igor" };

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int lengthComparison = Integer.compare(a.length(), b.length());

                if (lengthComparison != 0) {
                    return lengthComparison;
                }

                return a.compareToIgnoreCase(b);
            }
        };
        Arrays.sort(names, comparator);
        System.out.println(Arrays.toString(names));
    }
}
