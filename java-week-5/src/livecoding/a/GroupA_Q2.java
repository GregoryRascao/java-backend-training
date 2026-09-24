package livecoding.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Statistics
{
    public static double average(int... numbers)
    {
        if (numbers.length == 0)
        {
            return 0.0;
        }

        int sum = 0;
        int max = numbers[0];

        for (int number : numbers)
        {
            sum += number;
            if (number > max)
            {
                max = number;
            }
        }

        System.out.println("Max: " + max);
        return (double) sum / numbers.length;
    }

    public static double averageWithCollections(int... numbers)
    {
        if (numbers.length == 0)
        {
            return 0.0;
        }

        List<Integer> list = new ArrayList<>();
        int sum = 0;

        for (int number : numbers)
        {
            list.add(number);
            sum += number;
        }

        int max = Collections.max(list);
        System.out.println("Max: " + max);
        return (double) sum / numbers.length;
    }
}

public class GroupA_Q2
{
    public static void main(String[] args)
    {
        double avg = Statistics.average(5, 8, 12, 3);
        System.out.println("Average: " + avg);
    }
}
