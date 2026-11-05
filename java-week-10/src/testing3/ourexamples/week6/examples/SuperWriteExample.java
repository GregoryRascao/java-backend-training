package testing3.ourexamples.week6.examples;

import java.util.List;

public class SuperWriteExample
{
    public static void addDefaults(List<? super Integer> values)
    {
        values.add(10);
        values.add(20);
        values.add(30);
    }
}