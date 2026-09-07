/**
 * This example demonstrates the use of a switch statement in Java.
 * -----------------------------------------------------------
 */

public class SwitchStatement
{

    // An enum is a type with a fixed list of possible values.
    // A Day variable can contain only one of these seven day names.
    public enum Day { SUNDAY, MONDAY, TUESDAY,
        WEDNESDAY, THURSDAY, FRIDAY, SATURDAY }

    public static void main(String[] args)
    {
        // Store one value from the Day enum in the variable named myday.
        Day myday = Day.MONDAY;

        int dayResult = switch (myday) {
            // A comma lets several values use the same result.
            // -> means "produce this value" in a switch expression.
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY                -> 7;
            case THURSDAY, SATURDAY     -> 8;
            case WEDNESDAY              -> 9;

            // default runs only when no case matches.
            // It is a safety check; all Day values are already handled above.
            default -> throw new IllegalStateException("Invalid day: " + myday);
        };

        System.out.println(dayResult);

    }
}
