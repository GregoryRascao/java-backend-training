# Reading Files in Java (Optional)

This optional module builds on the file-reading material from week 6. Its examples apply those techniques to log analysis and introduce simple manual checks before the JUnit lessons.

## What is Logging?

Most real-world applications write **logs** while they run.

A log is a record of events that happen inside a program.

Logs help developers and system administrators:

- understand what the program is doing
- detect errors
- monitor system behavior
- debug problems after they occur

Example log file:

```
INFO server started
INFO call received
WARN disk usage high
ERROR database connection failed
```

Each line usually begins with a **log level**, which indicates the severity of the message.

Common log levels include:

- **INFO** – normal informational events
- **WARN** – something unexpected happened, but the system continues
- **ERROR** – a failure occurred

In many backend systems, programs write logs continuously and other tools later **read and analyze those logs**.

### Question:
If a production system crashes at 3 AM, how do developers know what happened?

This module includes a small **Log Analyzer** project to simulate that workflow.


## Testing Note

Examples 7 and 8 demonstrate manual `if` checks for file-processing and filtering methods. The testing module uses them as the starting point for explaining why automated tests are useful.

