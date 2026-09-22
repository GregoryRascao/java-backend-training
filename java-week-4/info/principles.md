
# SOLID Principles (S, O, D)

SOLID is a set of design principles that help us write clean, maintainable, and flexible object-oriented code.

More information:

* Wikipedia: [https://en.wikipedia.org/wiki/SOLID](https://en.wikipedia.org/wiki/SOLID)
* Wikipedia overview of SOLID principles

In this week, we focus on:

* **S** — Single Responsibility Principle
* **O** — Open/Closed Principle
* **I** — Interface Segregation Principle
* **D** — Dependency Inversion Principle

---

# 1 S — Single Responsibility Principle (SRP)

> A class should have only ONE reason to change.

A class should do **one job only**.

---

### Bad Example

```java
public class UserService {

    public void saveUser(User user) {
        // save to database
    }

    public void sendEmail(User user) {
        // send email
    }

    public void generateReport() {
        // generate report
    }
}
```

This class:

* Saves users
* Sends emails
* Generates reports

It has multiple responsibilities

---

### Better Design

```java
public class UserService {
    public void saveUser(User user) { }
}

public class EmailService {
    public void sendEmail(User user) { }
}

public class ReportService {
    public void generateReport() { }
}
```

Now each class has one clear responsibility 

---

# 2 O — Open/Closed Principle (OCP)

> Software entities should be open for extension, but closed for modification.

This means:

* We should be able to add new behavior
* Without modifying existing code

---

### Bad Example

```java
public class DiscountService {

    public double calculate(String type, double price) {
        if (type.equals("student")) {
            return price * 0.8;
        } else if (type.equals("senior")) {
            return price * 0.7;
        }
        return price;
    }
}
```

Every time we add a new discount type, we must modify this class!

---

### Better Design (Using Interfaces)

```java
public interface DiscountStrategy {
    double calculate(double price);
}
```

```java
public class StudentDiscount implements DiscountStrategy {
    public double calculate(double price) {
        return price * 0.8;
    }
}
```

```java
public class SeniorDiscount implements DiscountStrategy {
    public double calculate(double price) {
        return price * 0.7;
    }
}
```

Now we can add a new discount by creating a new class.
We do not modify existing code 

---

# I — Interface Segregation Principle (ISP)

> Clients should not be forced to depend on methods they do not use.

This means we should keep our interfaces small and focused, instead of creating one large interface that forces every implementing class to provide methods it doesn't actually need.

---

### Bad Example

```java
public interface AnimalAbilities {
    void fly();
    void swim();
    void run();
    void climb();
}
```

If we implement this interface, we are forced to write a body for every method — even for abilities our animal doesn't have. A `Horse` would be forced to implement `fly()` and `swim()`, even though a horse can't do either.

---

### Better Design (Segregated Interfaces)

```java
public interface Flyable {
    void fly();
}

public interface Swimmable {
    void swim();
}

public interface MyRunnable {
    void run();
}
```

Now each class implements only the abilities it actually has:

```java
public class Duck implements Flyable, Swimmable, MyRunnable {
    public void fly() { }
    public void swim() { }
    public void run() { System.out.println("running DUCK!"); }
}

public class Hawk implements Flyable {
    public void fly() { System.out.println("Hawk flies"); }
}

public class Horse implements MyRunnable {
    public void run() { System.out.println("Horse running"); }
}
```

We can find this exact example in `src/interfaces/examples/zoo`, where `AnimalAbilities` shows the bad, "fat" interface, and `Flyable`, `Swimmable`, and `MyRunnable` show how we segregate it into small, focused interfaces that classes like `Duck`, `Hawk`, and `Horse` combine as needed.

Now:

* Each class only implements the abilities it needs
* We avoid empty or unsupported method bodies
* Our interfaces stay small, focused, and easy to combine

---

# D — Dependency Inversion Principle (DIP)

> High-level modules should not depend on low-level modules.
> Both should depend on abstractions.

In simple words:

Classes should depend on **interfaces**, not concrete classes.

---

### Tight Coupling (Bad)

```java
public class Car {

    private Engine engine = new DieselEngine();

    public void start() {
        engine.run();
    }
}
```

Car directly depends on DieselEngine.
If we change the engine type, we must modify Car

---

### Loose Coupling (Good)

```java
public interface Engine {
    void run();
}
```

```java
public class DieselEngine implements Engine {
    public void run() {
        System.out.println("Diesel engine running");
    }
}
```

```java
public class Car {

    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.run();
    }
}
```

Now:

* Car depends on Engine (interface)
* The engine is injected from outside (Dependency Injection)

This is more flexible and easier to extend

---

# Related Concepts

## Separation of Concerns (SoC)

Different parts of the program should handle different concerns.

Example layers:

* Controller → handles requests
* Service → business logic
* Repository → database access

Each layer has a clear responsibility.

---

## Tight Coupling (Bad)

When classes directly depend on concrete implementations:

* Hard to modify
* Hard to extend
* Hard to test

---

## Loose Coupling (Good)

When classes depend on abstractions (interfaces):

* Easier to extend
* Easier to replace implementations
* More maintainable

Dependency Injection helps us achieve loose coupling.

---

# About Testing (Coming Later)

We will discuss testing in more detail in future weeks.

You will see that:

* Loose coupling
* Dependency Injection
* Interfaces

make unit testing much easier.

For now, focus on understanding:

* Responsibilities
* Abstractions
* Clean design

Testing will make much more sense once we start writing unit tests.

---

# Final Summary

* **S** → One responsibility per class
* **O** → Extend behavior without modifying existing code
* **I** → Keep interfaces small and focused, don't force unused methods on classes
* **D** → Depend on abstractions, not concrete classes
* Separation of Concerns → Keep responsibilities separated
* Tight coupling → Avoid
* Loose coupling → Prefer
