# 🔄 Type Conversion in Java

In Java, **type conversion** allows us to assign a value of one data type to another.  
It is a fundamental concept when working with different types of variables and performing calculations.

---

## 📌 Types of Conversion

### 1. Widening Conversion (Implicit Casting)

Also called **type promotion**, this happens automatically when a smaller type is converted to a larger type.  
No data is lost during widening.

**Example:**

```java
public class WideningExample
{
    public static void main(String[] args)
    {
        int num = 10;
        double result = num; // int → double
        System.out.print(result); // Output: 10.0
    }
}
```

✅ Safe, because Java automatically promotes smaller data types to larger ones.
📌 Example conversions:
`byte → short → int → long → float → double`

---

### 2. Narrowing Conversion (Explicit Casting)

Also called **type casting**, this requires manual conversion.
Data may be lost or altered when converting a larger type to a smaller type.

**Example:**

```java
public class NarrowingExample
{
    public static void main(String[] args)
    {
        double value = 9.78;
        int result = (int) value; // double → int
        System.out.print(result); // Output: 9
    }
}
```

⚠️ Be careful: narrowing can cause **loss of precision** or **overflow**.

Overflow happens when you try to store a number that is too large (or too small) for a data type.
The value “wraps around” and produces an incorrect result, because the data type cannot hold it.

---

## 📊 Common Conversions

- `int` → `double` (safe, widening)
- `double` → `int` (requires casting, may lose decimal part)
- `char` → `int` (widening, gets Unicode value)
- `int` → `char` (narrowing, converts to corresponding character)

**Example:**

```java
public class ConversionExamples
{
    public static void main(String[] args)
    {
        char letter = 'A';
        int code = letter; // char → int
        System.out.print(code); // Output: 65

        int num = 66;
        char ch = (char) num; // int → char
        System.out.print(ch); // Output: B
    }
}
```

---

## ⚙️ Type Conversion with Strings

Java provides utility methods to convert between numbers and strings.

**String to Number:**

```java
String str = "100";
int num = Integer.parseInt(str);
double d = Double.parseDouble("3.14");
```

**Number to String:**

```java
int num = 100;
String str = String.valueOf(num); // or Integer.toString(num)
```

---
