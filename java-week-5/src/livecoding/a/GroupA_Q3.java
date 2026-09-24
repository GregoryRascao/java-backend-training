package livecoding.a;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

sealed interface Logger permits ConsoleLogger, FileLogger
{
    void log(String message);
}

final class ConsoleLogger implements Logger
{
    @Override
    public void log(String message)
    {
        System.out.println("[CONSOLE] " + message);
    }
}

final class FileLogger implements Logger
{
    private final String fileName;

    public FileLogger(String fileName)
    {
        this.fileName = fileName;
    }

    @Override
    public void log(String message)
    {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName, true)))
        {
            out.println("[FILE] " + message);
        }
        catch (IOException exception)
        {
            System.err.println("Failed to write log: " + exception.getMessage());
        }
    }
}

class App
{
    private final List<Logger> loggers;

    public App(List<Logger> loggers)
    {
        this.loggers = loggers;
    }

    public void run()
    {
        logAll("App started");
        logAll("Doing work...");
        logAll("App finished");
    }

    private void logAll(String message)
    {
        for (Logger logger : loggers)
        {
            logger.log(message);
        }
    }
}

public class GroupA_Q3
{
    public static void main(String[] args)
    {
        Logger consoleLogger = new ConsoleLogger();
        Logger fileLogger = new FileLogger("app.log");

        App app = new App(List.of(consoleLogger, fileLogger));
        app.run();
    }
}
