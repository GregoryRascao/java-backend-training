# Live Coding Exercise -- Group B

This exercise contains two coding tasks and three theory questions.

## Instructions

First, solve the coding questions individually.

During the pair session, ask your partner to solve one of your questions.

Observe how they approach the problem and discuss the solution together.

Focus not only on getting the correct result, but also on code structure and design decisions.

## Coding Question 1 -- Composition (Car and Engine)

Create two classes:

Engine, Car

## Engine

Fields:
```java
horsePower
```
Method:

start()

When start() is called, print:

Engine started

## Car

Fields:
```java
brand
```
Engine engine

Method:

drive()

## Requirements:

A Car has an Engine (composition).

When drive() is called:

The engine should start

Then print:
```java
Car is driving
```
In main()

Create an Engine

Pass the engine to a Car

Call drive()

Example output:
```java
Engine started
Car is driving
```
Discussion point:

Why is this example composition instead of inheritance?

## Coding Question 2 -- Multi-Dimensional Arrays

You are given a 2D array representing weekly temperatures:
```java
int[][] temps = {
{3, 5, 2, 4},   // Week 1
{6, 1, 0, 2},   // Week 2
{4, 4, 3, 5}    // Week 3
};
```
Task 1

Write a method:
```java
public static int weekAverage(int[] week)
```
Return the average temperature of a single week.

Task 2

Write another method:
```java
public static int coldestTemperature(int[][] temps)
```
This method should return the lowest temperature in the entire 2D array.

In main()

Print the average temperature for each week

Print the coldest temperature overall

Example output:
```java
Week 1 average: 3
Week 2 average: 2
Week 3 average: 4

Coldest temperature: 0
```
## Coding Question 3 Notification System (This one is without hints)

Design a small notification system.

Your system should be able to send notifications through different communication channels.

### Requirements

Define a common abstraction that represents something capable of sending a notification message.

Implement at least two different types of notification senders:

One that sends notifications by email

One that sends notifications by SMS

Create a class called NotificationService.

NotificationService should be able to send the same message through all available notification senders.

The service should not depend on a specific sender implementation.

Write a method:
```java
notifyAllUsers(String message)
```
that sends the message through every available notification sender.

In main():

Create the notification senders

Register them in the service

Send a message:

"System update tonight"
Example Output
```java
Sending EMAIL: System update tonight
Sending SMS: System update tonight
```
# Theory Questions
## Theory 1 -- Encapsulation vs Abstraction

Explain the difference between:

Encapsulation

Abstraction

### Hints:

Encapsulation:

Hiding internal data

Controlling access using private fields and methods

Abstraction:

Hiding implementation details

Showing only essential behavior through interfaces or abstract classes

Give a simple Java example for both.

## Theory 2 -- final and Immutability

What does the keyword final mean for:

a variable?

a field?

a reference to an object?

Example:
```java
final List<String> list = new ArrayList<>();
```
Why can we still add elements to the list?

Explain the difference between final reference and immutable object.

## Theory 3 -- protected Access Modifier

What does protected mean in Java?

Compare the following access levels:

private
protected
public

When would you choose protected instead of private?

Give a small example involving inheritance.