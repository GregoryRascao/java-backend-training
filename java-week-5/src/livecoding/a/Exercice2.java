package livecoding.a;

public class Exercice2 {
    public class Statistics{
        public static double average(int... numbers){
            if(numbers.length == 0){
                return 0;
            }

            int sum = 0;
            int max = 0;

            for (int number : numbers) {
                sum += number;
                if (number > max) {
                    max = number;
                }
            }
            System.err.println("Maximum :" + max);
            return (double) sum / numbers.length;
        }
    }

    public static void main(String[] args) {
        double averageNumbers = Statistics.average(5, 8, 12, 3);
        System.out.println("Average :" + averageNumbers);
    }

}
