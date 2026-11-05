package testing3.ourexamples.week5.examples;

public class JoinWordsExample
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
}