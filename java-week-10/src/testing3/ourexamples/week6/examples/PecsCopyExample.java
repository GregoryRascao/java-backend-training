package testing3.ourexamples.week6.examples;

import java.util.List;

public class PecsCopyExample
{
    public static <T> void copyElements(List<? extends T> source, List<? super T> destination)
    {
        for (T item : source)
        {
            destination.add(item);
        }
    }
}