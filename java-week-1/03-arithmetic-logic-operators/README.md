# 📝 Java Operators Overview

This guide introduces the different types of **operators in Java** with explanations and examples.  
Operators are special symbols used to perform operations on variables and values.

---

## 🔹 1. Arithmetic Operators

Used to perform basic mathematical operations.

| Operator | Description         | Example (`a=10, b=5`) | Result |
|----------|---------------------|-----------------------|--------|
| `+`      | Addition            | `a + b`               | `15`   |
| `-`      | Subtraction         | `a - b`               | `5`    |
| `*`      | Multiplication      | `a * b`               | `50`   |
| `/`      | Division            | `a / b`               | `2`    |
| `%`      | Modulus (Remainder) | `a % b`               | `0`    |

```java
public class Main 
{
    public static void main(String[] args) 
    {
        int a = 10, b = 5;
        System.out.println(a + b); // 15
        System.out.println(a % b); // 0
    }
}

````

---

## 🔹 2. Relational (Comparison) Operators

Used to compare two values. Returns a **boolean** (`true` or `false`).

| Operator | Description           | Example (`a=10, b=5`) | Result |
|----------|-----------------------|-----------------------|--------|
| `==`     | Equal to              | `a == b`              | false  |
| `!=`     | Not equal to          | `a != b`              | true   |
| `>`      | Greater than          | `a > b`               | true   |
| `<`      | Less than             | `a < b`               | false  |
| `>=`     | Greater than or equal | `a >= b`              | true   |
| `<=`     | Less than or equal    | `a <= b`              | false  |

```java
public class Main
{
    public static void main(String[] args)
    {
        int a = 10, b = 5;
        System.out.println(a > b);  // true
        System.out.println(a == b); // false
    }
}

```

---

## 🔹 3. Logical Operators

Used to combine multiple conditions. Works with boolean values.

| Operator | Description  | Example                 | Result |
|----------|--------------|-------------------------|--------|
| `&&`     | LogicalE AND | `(a > b) && (a < 20)`   | true   |
| `\|\|`   | LogicalE OR  | `(a > b) \|\| (b > 20)` | true   |
| `!`      | LogicalE NOT | `!(a > b)`              | false  |

```java
public class Main
{
    public static void main(String[] args)
    {
        int a = 10, b = 5;
        System.out.println((a > b) && (a < 20)); // true
        System.out.println(!(a > b));            // false
    }
}

```

---

## 🔹 4. Assignment Operators

Used to assign values to variables.

| Operator | Example  | Equivalent To |
|----------|----------|---------------|
| `=`      | `a = 10` | `a = 10`      |
| `+=`     | `a += 5` | `a = a + 5`   |
| `-=`     | `a -= 5` | `a = a - 5`   |
| `*=`     | `a *= 2` | `a = a * 2`   |
| `/=`     | `a /= 2` | `a = a / 2`   |
| `%=`     | `a %= 3` | `a = a % 3`   |

```java
public class Main
{
    public static void main(String[] args)
    {
        int a = 10, b = 5;
        a += 5; // a = 15
        a *= 2; // a = 30
    }
}

```

---

## 🔹 5. Unary Operators

Used with a single operand.

| Operator | Description                   | Example (`a=10`) | Result |
|----------|-------------------------------|------------------|--------|
| `+`      | UnaryE plus (positive value)  | `+a`             | 10     |
| `-`      | UnaryE minus (negative value) | `-a`             | -10    |
| `++`     | Increment (adds 1)            | `a++`            | 11     |
| `--`     | Decrement (subtracts 1)       | `a--`            | 9      |
| `!`      | LogicalE NOT                  | `!(a > 0)`       | false  |

```java
public class Main
{
    public static void main(String[] args)
    {
        int x = 10;
        System.out.println(++x); // 11 (pre-increment)
        System.out.println(x--); // 11 then becomes 10
    }
}

```

---

## 🔹 6. Ternary Operator

A shorthand for `if-else`.

```java
public class Main
{
    public static void main(String[] args)
    {
        int age = 20;
        String result = (age >= 18) ? "Adult" : "Minor";
        System.out.println(result); // Adult
    }
}

```
