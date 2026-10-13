package writing.projects;

/**
 * Simple Logger
 *
 * Write a small logging program.
 *
 * 1. Ask the user to enter a log level (INFO, WARN, ERROR).
 * 2. Ask the user to enter a log message.
 * 3. Append a new line to "app.log" in the following format:
 *
 *    timestamp | level | message
 *
 * Example output in file:
 *
 * 2026-03-14T20:21:03 | INFO  | Server started
 * 2026-03-14T20:21:10 | WARN  | Disk usage high
 * 2026-03-14T20:21:15 | ERROR | Database connection failed
 *
 *
 * Bonus:
 * Use an enum instead of String for the log level.
 */
public class Project1 {
}

/* Hint:



 * - Use FileWriter with append mode
 * - Use LocalDateTime.now()
*/