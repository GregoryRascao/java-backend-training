# Flexible API Design
## Varargs • Anonymous Classes • Builder Pattern

This module covers three powerful Java features that improve flexibility, readability, and API design.

They may look unrelated, but they all help you write:

Cleaner method calls

More flexible behavior

More readable object creation

## Varargs -- Flexible Method Parameters
What Problem Does It Solve?
Question:
Try to create a method that adds 3 given parameters, and then overload it for 4 parameters, and then 5.
Problem is:
Sometimes we don’t know how many arguments a method will receive.

Instead of writing:

```java
sum(1, 2);
sum(1, 2, 3);
sum(1, 2, 3, 4);
```

We use varargs.


```java
public static int sum(int... numbers) {
    int total = 0;
    for (int n : numbers) {
        total += n;
    }
    return total;
}
//Usage
sum(1, 2);
sum(1, 2, 3, 4, 5);
```
Internally, numbers is treated as an array.

Rules

Only one varargs parameter per method

It must be the last parameter

It behaves like an array

```java
public void example(String name, int... scores) // This is correct
```
Mini Exercise

Create a method:

public static String join(String... words)

It should return all words combined into one sentence.

## Anonymous Classes  One-Time Behavior
What Problem Does It Solve?

Sometimes we need an object that conforms to an interface and we need it only once.

Instead of creating a full class file, we can create it inline.

Example

```java
interface Printer {
    void print(String text);
}

```

```java
//We want to create a printer
Printer p = new Printer() {
    @Override
    public void print(String text) {
        System.out.println(text);
    }
};
p.print("Hello");

```

It is also possible with generics too

```java
public interface Comparator<T> {
    ...
}

Comparator<String> comparator = new Comparator<>() {
    @Override
    public int compare(String a, String b) {
        return a.length() - b.length();
    }
};
```
This creates an anonymous class implementing Comparator.

### Note
Anonymous classes were widely used before Java 8.
Later in the course we will learn **Lambda Expressions**, which provide a shorter syntax for many cases where anonymous classes were used.


## Builder Pattern -- Clean and Readable Object Creation
What Problem Does It Solve?

When constructors have too many parameters:

User user = new User("Bora", 35, true, "Belgium", "Developer");

Hard to read. Easy to mix parameters.

```java
Builder Solution
public class User {
    private String name;
    private int age;
    private boolean active;

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.active = builder.active;
    }

    public static class Builder {
        private String name;
        private int age;
        private boolean active;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder active(boolean active) {
            this.active = active;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

```
Usage

```java
User user = new User.Builder()
    .name("Student")
    .age(35)
    .active(true)
.build();

```
Much more readable ✅

When Should You Use Builder?

Many optional parameters

Clean API design

```
This style is called a **Fluent API**.

Each method returns the same object so that method calls can be chained.

```

### Mini Examples

Example of all three concepts:

```java
public static void sendMessage(String message, String... recipients) {
    for (String r : recipients) {
        System.out.println("Sending to " + r);
    }
}
Runnable onComplete = new Runnable() {
    @Override
    public void run() {
        System.out.println("Done!");
    }
};

Notification notification = new Notification.Builder()
.message("Hello")
.priority(1)
.build();

```

## Functional Interfaces

Interfaces that have only one method are called functional interfaces.
```java
@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}
```
We'll use this term later.


Now we have:

Flexible input → varargs

Custom behavior → anonymous class

Clean object creation → builder

### Why These Topics Matter

These concepts appear frequently in:

Java libraries

Frameworks like Spring

Professional backend code

Clean architecture patterns