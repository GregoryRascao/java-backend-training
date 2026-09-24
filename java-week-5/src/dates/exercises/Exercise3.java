package dates.exercises;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Exercise 3: Period and Duration Calculations
 * 
 * Scenario: You need to calculate time differences for various situations
 *  Complete the following tasks
 * 
 * 1. Calculate your exact age in years, months, and days using Period
 * 2. Create a method that calculates the number of days between two dates
 * 3. Calculate the working hours in a day (9:00 AM to 5:30 PM) using Duration
 * 4. Add a 30-minute lunch break to calculate actual working time
 * 5. Calculate how many days are left until New Year's Day (January 1, 2027)
 * 6. Create a Period of 1 year, 6 months, and 15 days, then add it to today
 * 7. BONUS: Calculate how many full weeks are between your birthday and today
 */
public class Exercise3 {
    public static void main(String[] args) {
        // TODO: Task 1 - Calculate your age
        LocalDate birthday = LocalDate.of(2000, 1, 1); // Replace with your birthday
        LocalDate today = LocalDate.now();
        
        
        // TODO: Task 2 - Create a method to calculate days between dates
        // Call it with two different dates and print the result
        
        
        // TODO: Task 3 - Calculate working hours
        LocalTime workStart = LocalTime.of(9, 0);
        LocalTime workEnd = LocalTime.of(17, 30);
        
        
        // TODO: Task 4 - Calculate actual working time (subtract 30 min lunch)
        
        
        // TODO: Task 5 - Days until New Year 2027
        
        
        // TODO: Task 6 - Add period to today
        
        
        // TODO: BONUS - Calculate full weeks between birthday and today
        
    }
    
    // TODO: Task 2 - Implement this method
    public static long calculateDaysBetween(LocalDate start, LocalDate end) {
        // Your code here
        return 0;
    }
}
