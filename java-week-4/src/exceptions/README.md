# Errors and Exceptions in Java

Programming in Java (or any other language) involves dealing with different kinds of **errors** that
occur during development and execution. Understanding these errors is key to writing robust, maintainable,
and bug-free applications.

---

## 1. Types of Errors in Java

### ✅ 1.1 Compilation Errors
- Occur during the **compilation phase**.
- Caused by violating the rules of the Java language (syntax errors).
- The compiler detects them **before running the program**.
- Examples:
  - Missing semicolon `;`
  - Using an undeclared variable
  - Mismatched data types in assignments

```java
int x = "Hello";  // ❌ Compilation Error: incompatible types
````

---

### ✅ 1.2 Runtime Errors

* Happen **while the program is running**.
* They cause the program to terminate abnormally if not handled.
* Typically caused by exceptional situations, such as invalid input, memory issues, or illegal operations.
* Examples:

    * Dividing a number by zero
    * Accessing an invalid array index

```java
int a = 5 / 0;  // ❌ Runtime Error: ArithmeticException
```

---

### ✅ 1.3 Logical Errors

* The program **runs successfully** but produces **incorrect or unintended results**.
* Harder to detect since there are no compilation or runtime error messages.
* Usually caused by incorrect algorithm design or flawed logic.
* Examples:

    * Using `>` instead of `<` in a condition
    * Incorrect formula implementation

```java
int marks = 85;
if (marks > 90) 
{
    System.out.println("Passed");  // ❌ Logical Error: wrong condition
}
```

---

## 2. Exceptions in Java

In Java, **exceptions** are events that occur during program execution and disrupt the normal
flow of instructions. Java provides a **robust exception-handling mechanism** using `try-catch-finally` blocks.

---

### ✅ 2.1 Exception Hierarchy

```
Throwable
 ├── Error (serious problems, cannot be handled by the program)
 │     ├── OutOfMemoryError
 │     ├── StackOverflowError
 │     └── VirtualMachineError
 │
 └── Exception (recoverable problems, can be handled)
       ├── Checked Exceptions (must be handled at compile time)
       │     ├── IOException
       │     ├── SQLException
       │     └── FileNotFoundException
       │
       └── Unchecked Exceptions (RuntimeExceptions, detected at runtime)
             ├── ArithmeticException
             ├── NullPointerException
             ├── ArrayIndexOutOfBoundsException
             ├── ClassCastException
             └── NumberFormatException
```

---

### ✅ 2.2 Types of Exceptions

#### 🔹 Checked Exceptions

* Checked at **compile-time**.
* If not handled, the compiler shows an error.
* Examples: `IOException`, `SQLException`.

```java
import java.io.*;

public class CheckedExample 
{
    public static void main(String[] args) 
    {
        try 
        {
            FileReader fr = new FileReader("data.txt");
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("File not found!");
        }
    }
}
```

#### 🔹 Unchecked Exceptions

* Checked at **runtime**, not by the compiler.
* Subclasses of `RuntimeException`.
* Examples: `NullPointerException`, `ArithmeticException`.

```java
public class UncheckedExample 
{
    public static void main(String[] args) 
    {
        int num = 5 / 0; // ArithmeticException
    }
}
```

---

### ✅ 2.3 Exception Handling Keywords

1. **try** → block of code that may throw an exception
2. **catch** → handles the exception
3. **finally** → block that always executes (cleanup, closing files)
4. **throw** → used to **explicitly** throw an exception
5. **throws** → declares exceptions a method can throw

```java
public void readFile(String file) throws IOException 
{
    FileReader fr = new FileReader(file);
}
```

---

### ✅ 2.4 Custom Exceptions

You can create your own exceptions by extending `Exception` or `RuntimeException`.

```java
class InvalidAgeException extends Exception 
{
    public InvalidAgeException(String message) 
    {
        super(message);
    }
}

public class CustomExceptionDemo 
{
    static void checkAge(int age) throws InvalidAgeException 
    {
        if (age < 18) 
        {
            throw new InvalidAgeException("Age must be 18 or above!");
        }
    }

    public static void main(String[] args) 
    {
        try 
        {
            checkAge(16);
        }
        catch (InvalidAgeException e) 
        {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}
```

---

### ✅ 2.5 Best Practices for Exception Handling

* Use **specific exception types** instead of a generic `Exception`.
* Avoid empty `catch` blocks.
* Use `finally` (or **try-with-resources**) for cleanup like closing streams.
* Do not overuse exceptions for normal program flow.
* Create **custom exceptions** for meaningful error handling.
* Always log exceptions for debugging.
* Mind the order of catch blocks, catch the child exception first, then the parent exception.

---

## 3. Common Exceptions in Java

Here are the most frequent exceptions you’ll encounter:

1. **ArithmeticException** – division by zero
2. **NullPointerException** – accessing methods/fields on a null object
3. **ArrayIndexOutOfBoundsException** – invalid array index access
4. **StringIndexOutOfBoundsException** – invalid string index access
5. **ClassCastException** – invalid type casting
6. **NumberFormatException** – invalid string to number conversion
7. **IllegalArgumentException** – invalid method arguments
8. **IllegalStateException** – method invoked at an illegal or inappropriate time
9. **IOException** – input/output operation failure
10. **FileNotFoundException** – trying to access a non-existent file
11. **SQLException** – database access errors
12. **InterruptedException** – thread interruption
13. **UnsupportedOperationException** – operation not supported

---

## 📌 Summary

* **Compilation Errors** → Detected by the compiler, syntax-related.
* **Runtime Errors** → Occur while running the program, often exceptions.
* **Logical Errors** → Program runs but produces wrong output.
* **Exceptions** → Java’s mechanism to handle runtime issues gracefully.
