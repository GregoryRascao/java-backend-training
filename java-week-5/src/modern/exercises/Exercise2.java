/**
 * 1. Create a method: public static String join(String separator, String... words)
 * 2. Join all words using the given separator between them.
 * 3. In main, call the method once with a space separator and once with a comma separator, then print both results.
 */

package modern.exercises;

public class Exercise2
{
    public static String join(String separator, String... words){
        String sentence = "";
        for (String string : words) {
            sentence += string;
        }
        return sentence;
    }
    public static void main(String[] args)
    {
        System.err.println(join(" ", "Bonjour ", "hello ", "Good ", "Morning"));
    }
}
