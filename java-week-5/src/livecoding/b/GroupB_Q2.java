package livecoding.b;

public class GroupB_Q2
{
    public static int weekAverage(int[] week)
    {
        if (week == null || week.length == 0)
        {
            return 0;
        }

        int sum = 0;
        for (int temperature : week)
        {
            sum += temperature;
        }

        return sum / week.length;
    }

    public static int coldestTemperature(int[][] temps)
    {
        int min = Integer.MAX_VALUE;

        for (int[] week : temps)
        {
            for (int temperature : week)
            {
                if (temperature < min)
                {
                    min = temperature;
                }
            }
        }

        return min;
    }

    public static void main(String[] args)
    {
        int[][] temps = {
            {3, 5, 2, 4},
            {6, 1, 0, 2},
            {4, 4, 3, 5}
        };

        for (int i = 0; i < temps.length; i++)
        {
            System.out.println("Week " + (i + 1) + " average: " + weekAverage(temps[i]));
        }

        System.out.println();
        System.out.println("Coldest temperature: " + coldestTemperature(temps));
    }
}
