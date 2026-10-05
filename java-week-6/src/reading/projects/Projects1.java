package reading.projects;

/**
 * Log Analyzer
 *
 * A small program that reads a log file and counts how many
 * log entries belong to each severity level.
 *
 * The program analyzes the beginning of each line and checks
 * whether it starts with one of the following log levels:
 *
 * INFO
 * WARN
 * ERROR
 *
 * Example input:
 *
 * INFO server ready
 * INFO server started
 * INFO call received
 * WARN exception thrown and caught during execution
 * WARN disk almost full
 * ERROR database connection failed
 *
 * Expected output:
 *
 * INFO: 3
 * WARN: 2
 * ERROR: 1
 *
 */
public class Projects1 {
}

/**
 * Hint:
 * - Read the file line by line
 * - Detect the log level at the beginning of each line
 * - Count occurrences using a Map<String, Integer>
*/