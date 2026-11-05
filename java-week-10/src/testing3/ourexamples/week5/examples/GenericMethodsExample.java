package testing3.ourexamples.week5.examples;

import java.util.List;

public class GenericMethodsExample
{
    public static <T extends Comparable<T>> T findMax(T a, T b, T c)
    {
        T max = a;

        if (b.compareTo(max) > 0)
        {
            max = b;
        }
        if (c.compareTo(max) > 0)
        {
            max = c;
        }

        return max;
    }

    public static <T extends Number> double sumNumbers(List<T> numbers)
    {
        double sum = 0;
        for (Number num : numbers)
        {
            sum += num.doubleValue();
        }
        return sum;
    }

    public static <T extends Number> double average(List<T> numbers)
    {
        if (numbers.isEmpty())
        {
            return 0;
        }
        return sumNumbers(numbers) / numbers.size();
    }
}

class NumberBoxExample<T extends Number>
{
    private T value;

    public NumberBoxExample(T value)
    {
        this.value = value;
    }

    public T getValue()
    {
        return value;
    }

    public double toDouble()
    {
        return value.doubleValue();
    }

    public int toInt()
    {
        return value.intValue();
    }

    public boolean isPositive()
    {
        return value.doubleValue() > 0;
    }

    public boolean isNegative()
    {
        return value.doubleValue() < 0;
    }
}