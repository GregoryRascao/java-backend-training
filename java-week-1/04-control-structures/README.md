# 📝 Java Control Structures

Control structures allow you to control the flow of execution in your Java programs.  
This guide covers  **if, else if, else**, and **switch** statements.

---

## 🔹 1. `if` Statement

The `if` statement executes a block of code **only if a specified condition is true**.

```java
public class Main 
{
    public static void main(String[] args) 
    {
        int age = 20;

        if (age >= 18) {
            System.out.println("You are an adult.");
        }
    }
}

````

✅ Output:

```bash
You are an adult.
```

---

## 🔹 2. `if-else` Statement

The `if-else` statement executes one block if the condition is true,
and another block if the condition is false.

```java
public class Main 
{
    public static void main(String[] args) 
    {
        int number = 10;

        if (number % 2 == 0) 
        {
            System.out.println("Even number");
        } 
        else 
        {
            System.out.println("Odd number");
        }
    }
}

```

✅ Output:

```bash
Even number
```

---

## 🔹 3. `if-else if-else` Statement

Use `else if` when you have **multiple conditions** to check.

```java
public class Main 
{
    public static void main(String[] args) 
    {
        int marks = 75;

        if (marks >= 90) 
        {
            System.out.println("Grade A");
        } 
        else if (marks >= 75) 
        {
            System.out.println("Grade B");
        }
        else if (marks >= 50) 
        {
            System.out.println("Grade C");
        } 
        else 
        {
            System.out.println("Grade F");
        }
    }
}

```

✅ Output:

```bash
Grade B
```

---

## 🔹 4. `switch` Statement

The `switch` statement is used to **choose one block of code to execute from multiple options**.

```java
public class Main 
{
    public static void main(String[] args) 
    {
        int day = 3;
        String dayName;

        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid day";
        }

        System.out.println("Day: " + dayName);
    }
}

```

✅ Output:

```bash
Day: Wednesday
```

**Notes:**

* `break` prevents fall-through to the next case.
* `default` executes when no cases match.

---

## 🔹 Tips for Using Control Structures

* Always use `{}` braces even for single statements — improves readability.
* Conditions in `if` must evaluate to a boolean (`true` or `false`).
* `switch` works with **int, byte, short, char, String, and enum** types.

---

## 🔹 Example: Combining `if` and `switch`

```java
public class Main 
{
    public static void main(String[] args) 
    {
        int score = 85;
        if (score >= 0 && score <= 100) 
        {
            switch (score / 10) 
            {
                case 10:
                case 9:
                    System.out.println("Grade: A");
                    break;
                case 8:
                    System.out.println("Grade: B");
                    break;
                case 7:
                    System.out.println("Grade: C");
                    break;
                case 6:
                    System.out.println("Grade: D");
                    break;
                default:
                    System.out.println("Grade: F");
            }
        } 
        else 
        {
            System.out.println("Invalid score");
        }
    }
}

```

✅ Output:

```bash
Grade: B
```
