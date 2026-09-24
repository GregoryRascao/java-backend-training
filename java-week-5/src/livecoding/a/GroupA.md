# Live Coding Exercise -- Group A

This exercise contains two coding tasks and three theory questions.

## Instructions

First, solve the coding questions individually.

When pair work starts, explain your solution to your partner.

Review your partner’s solution and ask questions.

Focus not only on whether the code works, but also on why it was written that way.

## Coding Question 1 -- Reading a Positive Integer

Write a method:

public static int readPositiveInt(Scanner scanner)

### Requirements:

Ask the user:

Enter a positive integer:

The program must:

Reject inputs that are not integers

Reject integers less than or equal to 0

If the input is invalid, ask again.

The method should return the valid positive integer.

### Example interaction:

Enter a positive integer: -3
Must be greater than 0

Enter a positive integer: hello
Invalid input

Enter a positive integer: 7
You entered: 7

In main():

Create a Scanner

Call readPositiveInt(scanner)

Print the returned value

## Coding Question 2 -- Statistics Utility (Varargs)

Create a utility class:

Statistics

Add a static method:

public static double average(int... numbers)

### Requirements:

If no numbers are provided, return 0.

Calculate the average value.

Print the maximum number.

### Example usage:

double avg = Statistics.average(5, 8, 12, 3);

Example output:

Average: 7.0
Max: 12

### Bonus:

Convert the numbers varargs into a List<Integer> and compute the maximum using Collections.max().

## Coding Question 3 “Mini Logger” 
### Interfaces + Polymorphism + Collections + (optional) sealed

Design a tiny logging system.

Create an interface:
```java
interface Logger {
    void log(String message);
}
```
Implement two loggers:

ConsoleLogger → prints: "[CONSOLE] " + message

FileLogger → writes logs into a file named app.log (append mode)

Create a class App with a field:
```java
private final List<Logger> loggers;
```
Constructor receives the list (constructor injection).

Method:
```java
public void run()
```
Inside run():

Log "App started"

Log "Doing work..."

Log "App finished"

In main():

Create both loggers

Put them into a list

Create App and call run()

Why it’s final boss:

### Design

Discuss Interface and DIP

### Bonus:

Make Logger a sealed interface permitting only those two implementations.


# Theory Questions

### Theory 1 -- JVM, JRE, JDK

Explain the difference between:

JVM

JRE

JDK

Which one contains the Java compiler (javac)?

### Theory 2 -- Dependency Inversion Principle (DIP)

What is the Dependency Inversion Principle?

Explain why it is better for classes to depend on interfaces instead of concrete implementations.

Example discussion:

PaymentService → depends on PayPal

vs

PaymentService → depends on PaymentProcessor interface

What is constructor injection (parameter injection)?

### Theory 3 -- Static vs Instance Methods

What is the difference between:

static methods

instance methods

Why can't a static method use the keyword this?