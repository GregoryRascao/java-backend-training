package dates.examples;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Example 1: Basic LocalDate, LocalTime, and LocalDateTime usage
 *
 * java.time library got introduced in Java SE 8. (2014) Before we were using java.util.Date, java.util.Calendar etc.
 * 
 * This example demonstrates:
 * - Creating date/time objects with now()
 * - Creating specific dates with of()
 * - Getting individual components (year, month, day, etc.)
 */
public class Example1 {
    public static void main(String[] args) {
        // LocalDate - Date only (no time)
        LocalDate today = LocalDate.now();
        System.out.println("Today's date: " + today);
        System.out.println("Year: " + today.getYear());
        System.out.println("Month: " + today.getMonth());
        System.out.println("Month value: " + today.getMonthValue());
        System.out.println("Day of month: " + today.getDayOfMonth());
        System.out.println("Day of week: " + today.getDayOfWeek());
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // LocalTime - Time only (no date)
        LocalTime now = LocalTime.now();
        System.out.println("Current time: " + now);
        System.out.println("Hour: " + now.getHour());
        System.out.println("Minute: " + now.getMinute());
        System.out.println("Second: " + now.getSecond());
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // LocalDateTime - Both date and time (no timezone)
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Current date and time: " + dateTime);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Creating specific dates
        LocalDate birthday = LocalDate.of(1995, 6, 15);
        System.out.println("Birthday: " + birthday);
        System.out.println("Is leap year? " + birthday.isLeapYear());
        
        // Creating specific times
        LocalTime meetingTime = LocalTime.of(14, 30, 0);
        System.out.println("Meeting time: " + meetingTime);
        
        // Creating specific date-time
        LocalDateTime appointment = LocalDateTime.of(2026, 3, 3, 10, 30);
        System.out.println("Appointment: " + appointment);
    }
}
