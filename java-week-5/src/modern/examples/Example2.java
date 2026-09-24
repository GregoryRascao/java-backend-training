/**
 * 1. Create a join method using varargs.
 * 2. Combine words into one sentence.
 */

package modern.examples;

public class Example2
{
    public static String join(String... words)
    {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < words.length; i++)
        {
            builder.append(words[i]);
            if (i < words.length - 1)
            {
                builder.append(" ");
            }
        }

        return builder.toString();
    }

    public static void main(String[] args)
    {
        String sentence = join("Modern", "Java", "is", "readable");
        System.out.println(sentence);
    }
}
