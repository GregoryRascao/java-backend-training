# Annotations, Reflection & Runnable

You have already seen a custom annotation used with reflection. This note explains the main ideas without going deep into reflection.

## 1. What Is an Annotation?

An annotation adds information, or **metadata**, to code. It can be written above a class, method, field or other program element.

```java
@Override
public String toString() {
    return "Service";
}
```

`@Override` tells the compiler that this method is meant to override a method from a parent class. If it does not, the compiler reports an error.

Annotations do not usually perform the work themselves. They describe something that another tool can check or act on. For example:

- `@Override` is checked by the compiler.
- JUnit's `@Test` marks methods that JUnit should run as tests.
- Spring annotations such as `@Service` give Spring information it uses when setting up an application.

Some frameworks process annotations while the program runs; others can process them during compilation or build time. An annotation's meaning depends on the tool or framework that reads it.

## 2. Can We Write Our Own?

Yes. The syntax looks a little different, but a basic annotation is small:

```java
@interface Log {}
```

This declares an annotation named `Log`. We can then write `@Log` above a method. By itself, `@Log` does nothing: we need code, such as our `Runner`, to look for it and decide what it means.

To read an annotation with reflection while the program is running, give it runtime retention and restrict it to methods:

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Log {}
```

These are meta-annotations: annotations that describe our annotation.

- `@Retention(RetentionPolicy.RUNTIME)` keeps it available for runtime reflection.
- `@Target(ElementType.METHOD)` allows it to be placed on methods.

The names are new, but the idea is manageable: **declare the annotation, choose where it can be used, and choose how long it is available.**

## 3. Reflection in the Runner

Reflection lets Java inspect information about classes and methods while the program is running. A `Method` object describes a method. We can check its name or annotations, and we can invoke it.

Here is the example with the runtime setting added. Keep it in `Runner.java` in the `annotations.examples` package:

```java
package annotations.examples;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Target(ElementType.METHOD)
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

        for (Method method : Service.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Log.class)) {
                System.out.println("[LOG] " + LocalDateTime.now());
                System.out.println("Class: " + method.getDeclaringClass().getSimpleName());
                System.out.println("Method: " + method.getName());

                method.invoke(service);
            }
        }
    }
}
```

The `Runner`:

1. Gets the methods declared in `Service`.
2. Checks each method for `@Log`.
3. Prints details and invokes a method if it has the annotation.

`method.invoke(service)` calls the method represented by `method` on the `service` object. In this example it calls `process()`. Writing `service.process()` directly would run that one method, but would not check which methods have `@Log`.

The annotation is only metadata. **The `Runner` supplies the logging behaviour** by checking for `@Log` and printing information. Calling `service.process()` directly prints `Processing...`, but does not print the `[LOG]` details.


## 4. Why Does `isAnnotationPresent` Return False?

Try to make the Runner Example invode the process. Why is it not finding? Take 5-10 minutes to find it.

### Answer

The most common cause in this example is a missing runtime retention setting. If you declare only:

```java
@interface Log {}
```

Java's default retention is `CLASS`, so `Log` is not available to ordinary reflection at runtime. Add these imports and annotations:

```java
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Log {}
```

Then check the following:

- `@Log` is placed on the method you are checking.
- The annotation on the method is the same `Log` type that the `Runner` checks. Look for another `Log` declaration or an unintended import.
- The program has been recompiled and you are running the updated class.

`@Target(ElementType.METHOD)` is useful for catching placement mistakes at compile time, but **`@Retention(RetentionPolicy.RUNTIME)` is the key setting for `isAnnotationPresent`**.


## 6. Exercise — Test the Annotation

Write a JUnit test for the `Service` class above. The test should use reflection to check that:

1. `Service` has a method named `process`.
2. The method has the `@Log` annotation at runtime.
3. The annotation is not present on an unannotated method. Add a public method named `healthCheck` to `Service` for this check.

Use this starting point:

```java
package annotations.examples;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    @Test
    void processMethodHasLogAnnotation() throws NoSuchMethodException {
        Method process = Service.class.getDeclaredMethod("process");

        // TODO: Assert that process has the Log annotation.
    }
}
```

Add a second test for `healthCheck`. Find the method with `getDeclaredMethod(...)` and assert that `Log` is **not** present. Do not call `process()` directly in these tests: the goal is to check the annotation metadata.

**Think about it:** If the first test fails because the annotation is missing at runtime, which annotation setting should you check?

## Learning Outcomes

After this topic, you should be able to:

- Explain that annotations add metadata and need another tool or framework to act on them.
- Recognise how frameworks use annotations.
- Write a simple custom annotation and make it available at runtime.
- Explain how `Runner` finds and invokes annotated methods.
- Describe what `Runnable` represents and how it differs from reflection.
