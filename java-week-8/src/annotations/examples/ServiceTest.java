package annotations.examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

// * processMethodHasLogAnnotation inside ServiceTest, use JUnit

// * write another method named healthCheck

// * write a test for healtchCheck, and test if it does NOT have @Log annotation

class ServiceTest {
    @Test
    void processMethodHasLogAnnotation() throws NoSuchMethodException {
        Method process = Service.class.getDeclaredMethod("process");

        // * Assert that process has the Log annotation.
        assertTrue(process.isAnnotationPresent(Log.class),
                "La méthode process doit avoir l'annotation @Log");

        Assertions.assertTrue(process.isAnnotationPresent(Log.class));
    }
        @Test
    void healthCheckDoesNotHaveLogAnnotation() throws NoSuchMethodException {
        Method healthCheck = Service.class.getDeclaredMethod("healthCheck");

        assertFalse(healthCheck.isAnnotationPresent(Log.class),
                "La méthode healthCheck ne doit pas avoir l'annotation @Log");
         Assertions.assertFalse(healthCheck.isAnnotationPresent(Log.class));

    }
}