package dates.examples;

import java.time.LocalDate;

/**
 * Example 2: Date Arithmetic - Adding and Subtracting
 *
 * This example demonstrates:
 * - Adding days, weeks, months, years
 * - Subtracting time units
 *
 * Temporal is an interface for objects that represent date or time.
 * It allows adding or subtracting time units like days or months.
 */
public class Example2 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);

        System.out.println("\n--- Adding Time ---");
        System.out.println("5 days later: " + today.plusDays(5));
        System.out.println("2 weeks later: " + today.plusWeeks(2));
        System.out.println("3 months later: " + today.plusMonths(3));
        System.out.println("1 year later: " + today.plusYears(1));

        System.out.println("\n--- Subtracting Time ---");
        System.out.println("10 days ago: " + today.minusDays(10));
        System.out.println("2 weeks ago: " + today.minusWeeks(2));
        System.out.println("6 months ago: " + today.minusMonths(6));
        System.out.println("5 years ago: " + today.minusYears(5));

        System.out.println("\n--- Combining Operations ---");
        LocalDate futureDate = today.plusMonths(6).plusDays(15);
        System.out.println("6 months and 15 days later: " + futureDate);

        System.out.println("\n--- Real-world Example: Project Deadline ---");
        LocalDate projectStart = LocalDate.of(2026, 3, 1);
        System.out.println("Project starts: " + projectStart);

        LocalDate milestone1 = projectStart.plusWeeks(2);
        System.out.println("Milestone 1 (2 weeks): " + milestone1);

        LocalDate milestone2 = projectStart.plusMonths(1);
        System.out.println("Milestone 2 (1 month): " + milestone2);

        LocalDate projectEnd = projectStart.plusMonths(3);
        System.out.println("Project ends: " + projectEnd);
    }
}
