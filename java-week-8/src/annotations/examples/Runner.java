package annotations.examples;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

//TODO Find what is missing here
//This example is intentionally incomplete
@interface Log {}

class Service {

    @Log
    public void process() {
        System.out.println("Processing...");
    }
}


public class Runner {
    public static void main(String[] args) throws Exception {

        Service service = new Service();

        for (Method m : Service.class.getDeclaredMethods()) {

            if (m.isAnnotationPresent(Log.class)) {

                System.out.println("[LOG] " + LocalDateTime.now());
                System.out.println("Class: " + m.getDeclaringClass().getSimpleName());
                System.out.println("Method: " + m.getName());

                m.invoke(service);
//                service.process();
            }
        }
    }
}