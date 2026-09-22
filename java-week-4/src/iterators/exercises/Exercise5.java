package iterators.exercises;

import java.util.*;

/**
 * 1. Create a List<String> words with at least 6 items.
 * 2. Use a ListIterator to replace words longer than 4 characters with uppercase versions.
 * 3. Traverse the list backwards using the same ListIterator and print each word.
 */
public class Exercise5
{
    static void main(String[] args) {
        List<String> words  = new ArrayList<>(Arrays.asList("hello", "my", "name", "is", "Gregory", "Rascao", "and", "you", "?"));

        ListIterator<String> iterator = words.listIterator();
        System.out.println("Before " + iterator);
        while(iterator.hasNext())
        {
            String word = iterator.next();
            if(word.length() > 4){
                iterator.set(word.toUpperCase());
            }
        }
        System.out.println("After " + words);

        while(iterator.hasPrevious()){
            String word = iterator.previous();
            System.out.println("backwards " + words);
        }
    }
}
