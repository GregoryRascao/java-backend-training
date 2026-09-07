# 🖥️ Java Input and Output (I/O)

In Java, **Input and Output (I/O)** refers to the way a program interacts with the **user or external data sources**.
The most common I/O in beginner programs is **console input and output**.

---

## 🔹 1. Printing to the Console

Java provides the `System.out` object for printing messages to the console.

### 1.1 `println`

Prints the message **and moves to a new line**.

```java
public class Main 
{
    public static void main(String[] args) 
    {
        System.out.println("Hello, World!");
        System.out.println("Welcome to Java I/O");
    }
}
```

**Output:**

```bash
Hello, World!
Welcome to Java I/O
```

### 1.2 `print`

Prints the message **without moving to a new line**.

```java
public class Main 
{
    public static void main(String[] args) 
    {
        System.out.print("Hello, ");
        System.out.print("World!");
    }
}
```

**Output:**

```bash
Hello, World!
```

### 1.3 `printf`

Prints formatted output, similar to C's `printf`.

```java
public class Main 
{
    public static void main(String[] args) 
    {
        int age = 25;
        double height = 5.9;
        System.out.printf("Age: %d, Height: %.1f feet%n", age, height);
    }
}
```

**Output:**

```bash
Age: 25, Height: 5.9 feet
```

---

## 🔹 2. Reading Input Safely from the User

The `Scanner` class from `java.util` package is commonly used for console input.
**Best practice:** always validate input before reading it to prevent exceptions.

### 2.1 Importing Scanner

```java
import java.util.Scanner;
```

### 2.2 Creating a Scanner Object

```java
Scanner scanner = new Scanner(System.in);
```

### 2.3 Reading Input with Validation

```java
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        // 1. Reading an integer safely
        int age;
        while (true) 
        {
            System.out.print("Enter your age: ");
            if (scanner.hasNextInt()) 
            {
                age = scanner.nextInt();
                scanner.nextLine(); // consume leftover newline
                break;
            } 
            else 
            {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // discard invalid token
            }
        }

        // 2. Reading a double safely
        double height;
        while (true) 
        {
            System.out.print("Enter your height in meters: ");
            if (scanner.hasNextDouble()) 
            {
                height = scanner.nextDouble();
                scanner.nextLine(); // consume leftover newline
                break;
            } 
            else 
            {
                System.out.println("Invalid input. Please enter a valid decimal number.");
                scanner.next(); // discard invalid token
            }
        }

        // 3. Reading a single word safely
        String firstName;
        while (true) 
        {
            System.out.print("Enter your first name: ");
            if (scanner.hasNext()) 
            {
                firstName = scanner.next();
                scanner.nextLine(); // consume leftover newline
                break;
            } 
            else 
            {
                System.out.println("Invalid input. Please enter a word.");
                scanner.next();
            }
        }

        // 4. Reading a full line safely
        String address;
        System.out.print("Enter your address: ");
        while (!scanner.hasNextLine()) 
        {
            System.out.println("Invalid input. Please enter a line of text:");
            scanner.next(); // discard invalid token
        }
        address = scanner.nextLine();

        System.out.println("\nYou entered:");
        System.out.println("First Name: " + firstName);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Address: " + address);

        scanner.close();
    }
}
```

---

## 🔹 3. Notes and Best Practices

1. Always **import `java.util.Scanner`** when using Scanner.
2. Use `scanner.close()` to **release system resources**.
3. `next()` reads input until a space, `nextLine()` reads the **entire line**.
4. For numeric input, always **validate the type with `hasNextXxx()`** before reading.
5. After reading numbers (`nextInt()` / `nextDouble()`), call `nextLine()` to **consume the leftover newline**.
6. Combine **`print`**, **`println`**, and **`printf`** for formatted, user-friendly messages.

---

## 🔹 4. Example: Safe Simple Calculator

```java
import java.util.Scanner;

public class SafeCalculator 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        double num1, num2;

        while (true) 
        {
            System.out.print("Enter first number: ");
            if (scanner.hasNextDouble()) 
            {
                num1 = scanner.nextDouble();
                scanner.nextLine();
                break;
            } 
            else 
            {
                System.out.println("Invalid input. Enter a valid number.");
                scanner.next();
            }
        }

        while (true) 
        {
            System.out.print("Enter second number: ");
            if (scanner.hasNextDouble()) 
            {
                num2 = scanner.nextDouble();
                scanner.nextLine();
                break;
            } 
            else 
            {
                System.out.println("Invalid input. Enter a valid number.");
                scanner.next();
            }
        }

        double sum = num1 + num2;
        System.out.printf("The sum of %.2f and %.2f is %.2f%n", num1, num2, sum);

        scanner.close();
    }
}
```

**Sample Input:**

```bash
5.5
4.5
```

**Output:**

```bash
The sum of 5.50 and 4.50 is 10.00
```
