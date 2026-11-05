package testing3.ourexamples.week5.examples;

public class VarArgsSumExample
{
    public static int sum(int... numbers)
    {
        int total = 0;
        for (int number : numbers)
        {
            total += number;
        }
        return total;
    }
}