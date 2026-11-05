package testing3.ourexamples.week6.examples;

import java.util.List;

public class ExtendsReadExample
{
    public static double sumNumbers(List<? extends Number> numbers)
    {
        double sum = 0;

        for (Number number : numbers)
        {
            sum += number.doubleValue();
        }

        return sum;
    }
}