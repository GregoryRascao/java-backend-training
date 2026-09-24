package dates.examples;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

/**
 * Example 3: Period and Duration
 * 
 * This example demonstrates:
 * - Using Period to measure date differences (years, months, days)
 * - Using Duration to measure time differences (hours, minutes, seconds)
 * - Calculating ages and time intervals
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("=== PERIOD (for dates) ===\n");

        // Period: measures date-based differences
        LocalDate birthDate = LocalDate.of(1995, 5, 15);
        LocalDate today = LocalDate.now();
        
        Period age = Period.between(birthDate, today);
        System.out.println("Birth date: " + birthDate);
        System.out.println("Today: " + today);
        System.out.println("Age: " + age.getYears() + " years, "
                          + age.getMonths() + " months, "
                          + age.getDays() + " days");

        System.out.println("\n--- Creating Periods manually ---");
        Period twoMonths = Period.ofMonths(2);
        Period oneYear = Period.ofYears(1);
        Period threeWeeks = Period.ofWeeks(3);
        Period tenDays = Period.ofDays(10);

        System.out.println("Date after 2 months: " + today.plus(twoMonths));
        System.out.println("Date after 1 year: " + today.plus(oneYear));
        System.out.println("Date after 3 weeks: " + today.plus(threeWeeks));

        System.out.println("\n--- Complex Period ---");
        Period complex = Period.of(2, 6, 15); // 2 years, 6 months, 15 days
        LocalDate futureDate = today.plus(complex);
        System.out.println("Today + 2 years, 6 months, 15 days: " + futureDate);

        System.out.println("\n\n=== DURATION (for time) ===\n");
        
        // Duration: measures time-based differences
        LocalTime startWork = LocalTime.of(9, 0);
        LocalTime endWork = LocalTime.of(17, 30);

        Duration workTime = Duration.between(startWork, endWork);
        System.out.println("Start work: " + startWork);
        System.out.println("End work: " + endWork);
        System.out.println("Work duration: " + workTime.toHours() + " hours and "
                          + (workTime.toMinutes() % 60) + " minutes");
        
        System.out.println("\n--- Creating Durations manually ---");
        Duration twoHours = Duration.ofHours(2);
        Duration thirtyMinutes = Duration.ofMinutes(30);
        Duration fiveSeconds = Duration.ofSeconds(5);
        
        System.out.println("Time after 2 hours: " + LocalTime.now().plus(twoHours));
        System.out.println("Time after 30 minutes: " + LocalTime.now().plus(thirtyMinutes));
        
        System.out.println("\n--- Practical Example: Meeting Duration ---");
        LocalTime meetingStart = LocalTime.of(14, 15);
        Duration meetingLength = Duration.ofMinutes(45);
        LocalTime meetingEnd = meetingStart.plus(meetingLength);

        System.out.println("Meeting starts at: " + meetingStart);
        System.out.println("Meeting duration: " + meetingLength.toMinutes() + " minutes");
        System.out.println("Meeting ends at: " + meetingEnd);
    }
}
