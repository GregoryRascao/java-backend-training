package livecoding.a;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;


sealed interface Logger permits ConsoleLogger, FileLogger {
    void log(String message);
}

final class ConsoleLogger implements Logger{
    @Override 
    public void log(String message){
        System.out.println("[CONSOLE] " + message);
    }
}

final class FileLogger implements Logger{
    String nameFile;

    public FileLogger(String nameFile){
        this.nameFile = nameFile;
    }

    @Override 
    public void log(String message){
        try (PrintWriter out = new PrintWriter(new FileWriter(nameFile, true))) {
            out.println("Message" + message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class App {
    private final List<Logger> loggers;

    public App( List<Logger> loggers){
        this.loggers = loggers;
    }

    public void run(){
        System.out.println("App started");
        System.out.println("Doing work...");
        System.out.println("App finished");
    }
}
public class Exercice3 {
    public static void main(String[] args) {
        Logger consoLogger = new ConsoleLogger();
        Logger filelLogger = new FileLogger("app.log");

        App app = new App(List.of(consoLogger, filelLogger ));
        app.run();
    }
}
