# Modern Java Preview (Sealed Classes & Pattern Matching)

This is a short preview of features commonly mentioned in Java 21 and Java 25 certification prep.

---

## 1. Sealed Classes

```java
public sealed class Shape permits Circle, Rectangle {}

public final class Circle extends Shape {}
public non-sealed class Rectangle extends Shape {}
```

Sealed classes restrict which classes are allowed to extend or implement a type.

Normally, any class could extend a public class.
With sealed classes, the parent class explicitly defines the allowed subclasses using the permits keyword.

Permitted subclasses MUST declare one of the following:

final → cannot be extended further

sealed → can restrict its own subclasses

non-sealed → removes the restriction again

This gives developers more control over inheritance hierarchies.

---

### Example: Traffic Light

A traffic light can only have three possible states:

- Red
- Yellow
- Green

In normal Java inheritance, anyone could create a new subclass:

```java
abstract class TrafficLight {}

class Red extends TrafficLight {}
class Yellow extends TrafficLight {}
class Green extends TrafficLight {}

class Blue extends TrafficLight {} // This should not exist

    // This is unrealistic because a real traffic light only has three valid states.
    // With sealed classes, we can restrict which subclasses are allowed.

public sealed class TrafficLight
        permits Red, Yellow, Green {}

public final class Red extends TrafficLight {}
public final class Yellow extends TrafficLight {}
public final class Green extends TrafficLight {}
```
    Now the hierarchy is fixed:

        TrafficLight
        ├ Red
        ├ Yellow
        └ Green

        No other classes can extend TrafficLight.

        This makes the model safer and more predictable.

---

## 2. Pattern Matching for instanceof

```java
//Traditionally, instanceof required two steps:
if (obj instanceof String) {
    String text = (String) obj;
}


if (obj instanceof String text)
{
    System.out.println(text.length());
}
//Modern Java combines type checking and casting into one step.
```

The variable (text) is called a pattern variable and is only available in the branch where the check succeeds.

---

## Learning Outcomes

Explain the purpose of sealed classes

Recognize pattern matching with instanceof

Understand how modern Java reduces boilerplate casting