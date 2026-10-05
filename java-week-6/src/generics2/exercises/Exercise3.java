package generics2.exercises;

/**
 * Exercise 3 — Data Processor
 *
 * Write a method:
 *
 * public static double sum(List<? extends Number> numbers)
 *
 * Then create another method:
 *
 * public static void printAll(List<?> list)
 */
public class Exercise3 {
    public static double sum(List<? extends Number> numbers){
        double total = 0.0;
        for (Number number : numbers) {
            total += number.doubleValue();
        }
        return total;
    }
    public static void printAll(List<?> list){
        for (Object item : list) {
            System.out.println(item);
        }
    }
}
