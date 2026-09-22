package iterators.examples;

import java.util.*;

/**
 * Example 6: ListIterator - Bidirectional Traversal
 *
 * We use a ListIterator to modify elements while moving forward,
 * then traverse the same list backwards without creating a new iterator.
 */
public class Example6
{
    public static void main(String[] args)
    {
        List<String> words = new ArrayList<>(List.of("cat", "elephant", "dog", "giraffe", "ant", "monkey"));

        System.out.println("Original list: " + words);

        ListIterator<String> listIterator = words.listIterator();

        // Forward pass: we uppercase words longer than 4 characters
        while (listIterator.hasNext())
        {
            String word = listIterator.next();
            if (word.length() > 4)
            {
                listIterator.set(word.toUpperCase());
            }
        }

        System.out.println("After forward pass: " + words);
        System.out.println("Now we traverse backwards using the same iterator:");

        // Reverse pass: same ListIterator, now moving backwards with previous()
        while (listIterator.hasPrevious())
        {
            String word = listIterator.previous();
            System.out.println(word);
        }

        System.out.println("\nWe don't have to walk forward first: we can start a ListIterator");
        System.out.println("directly at the end by passing the list size, then go backwards right away:");

        // A fresh ListIterator positioned right after the last element
        ListIterator<String> reverseIterator = words.listIterator(words.size());
        while (reverseIterator.hasPrevious())
        {
            System.out.println(reverseIterator.previous());
        }

        // Teaser: later we will learn lambdas, which let us write the same
        // kind of "do something for every element" loop in a single line.
        System.out.println("A teaser of what's coming with lambdas:");
        words.forEach(word -> System.out.println("-> " + word));
    }
}
