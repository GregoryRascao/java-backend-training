# Testing in Java with JUnit 5

This folder builds on the manual testing approach introduced in `reading/examples/Example7.java` and `Example8.java`.

In those examples, we tested logic by writing `if (result == expected)` checks by hand.
That approach works, but it has problems:
- You must run `main()` yourself and read output to know if a test passed.
- There is no clear structure — test code and application code live in the same method.
- It does not scale when you have dozens of methods to verify.

**JUnit 5** solves all of this. It is the standard testing framework for Java.

---

## What is JUnit 5?

JUnit 5 is a library that discovers and runs your test methods automatically.

You annotate methods with `@Test`. JUnit finds them, runs them, and reports which ones passed and which ones failed — without you reading any output manually.

---

## Adding JUnit 5 to your project

In IntelliJ IDEA, you can also add JUnit 5 directly via **File → Project Structure → Libraries**.

There are other ways to install dependencies, for example:

### Maven (`pom.xml`)

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.2</version>
    <scope>test</scope>
</dependency>
```

### Gradle (`build.gradle`)

```groovy
testImplementation 'org.junit.jupiter:junit-jupiter:5.10.2'
```

---

## Structure of a test class

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest
{
    @Test
    void addsTwoNumbers()
    {
        assertEquals(5, Calculator.add(2, 3));
    }
}
```

Key rules:
- The class does **not** need a `main()` method. JUnit discovers and runs `@Test` methods for you.
- Test methods are usually `void` and have no parameters.
- By convention, the class is named after the class it tests, with `Test` appended (`CalculatorTest`).

---
---

## Key assertion methods

All assertion methods are in `org.junit.jupiter.api.Assertions`.

| Method                                      | Passes when...                                  |
|---------------------------------------------|-------------------------------------------------|
| `assertEquals(expected, actual)`            | `expected` equals `actual`                      |
| `assertEquals(expected, actual, delta)`     | two floating-point values are close enough      |
| `assertNotEquals(unexpected, actual)`       | `unexpected` does not equal `actual`            |
| `assertTrue(condition)`                     | `condition` is `true`                           |
| `assertFalse(condition)`                    | `condition` is `false`                          |
| `assertNull(value)`                         | `value` is `null`                               |
| `assertNotNull(value)`                      | `value` is not `null`                           |
| `assertThrows(ExceptionType.class, lambda)` | the lambda throws the expected exception type   |

---

## Typical test method structure

A good test method follows the **Arrange → Act → Assert** pattern:

```java
@Test
void dividesTwoIntegers()
{
    // Arrange
    int a = 10;
    int b = 2;

    // Act
    int result = Calculator.divide(a, b);

    // Assert
    assertEquals(5, result);
}
```

- **Arrange**: set up the input values or objects you need.
- **Act**: call the method you are testing.
- **Assert**: verify the result is what you expected.

---

## What to test

For any method, think about three categories:

1. **Normal cases** — the common, expected inputs.
2. **Boundary values** — 0, empty string, minimum and maximum values.
3. **Error cases** — inputs that should throw an exception.

---

## Naming conventions

Use descriptive method names that read like a sentence:

```
addsTwoPositiveNumbers()
returnsEmptyListWhenInputIsNull()
throwsExceptionWhenDividingByZero()
```

Avoid names like `test1()` or `myTest()`.

---

## Key annotations

| Annotation      | Meaning                                                                |
|-----------------|------------------------------------------------------------------------|
| `@Test`         | Marks a method as a test case. JUnit will run it.                      |
| `@BeforeEach`   | Runs before **every** `@Test` method. Use it to set up shared state.   |
| `@AfterEach`    | Runs after every `@Test` method. Use it to clean up.                   |
| `@BeforeAll`    | Runs once before all tests in the class. Must be `static`.             |

Now we can do examples until Exercise4 and exercises until 4.

## Learning outcomes

By completing this section, you will:
- Understand why automated testing replaces manual `if/else` checks
- Write `@Test` methods with JUnit 5
- Use `assertEquals`, `assertTrue`, `assertFalse`, `assertNotNull`, and `assertThrows`
- Use `@BeforeEach` to share setup logic across multiple tests
- Apply the Arrange → Act → Assert pattern
- Identify normal, boundary, and error cases for any method
