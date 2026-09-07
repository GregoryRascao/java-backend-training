# 🌀 Java Loops

Loops in Java allow you to **repeat a block of code multiple times** without writing it again.  
They are essential for automating repetitive tasks.

---

## 🔹 1. `for` Loop

**Example:**

```java
public class Main 
{
    public static void main(String[] args) 
    {
        for (int i = 1; i <= 5; i++) 
        {
            System.out.println("i = " + i);
        }
    }
}
````

✅ Output:

```bash
i = 1
i = 2
i = 3
i = 4
i = 5
```

---

## 🔹 2. `while` Loop

**Example:**

```java
public class Main 
{
    public static void main(String[] args) 
    {
        int i = 1;
        while (i <= 5) 
        {
            System.out.println("i = " + i);
            i++;
        }
    }
}
```

✅ Output:

```bash
i = 1
i = 2
i = 3
i = 4
i = 5
```

---

## 🔹 3. `do-while` Loop

**Example:**

```java
public class Main 
{
    public static void main(String[] args) 
    {
        int i = 1;
        do 
        {
            System.out.println("i = " + i);
            i++;
        } while (i <= 5);
    }
}
```

✅ Output:

```bash
i = 1
i = 2
i = 3
i = 4
i = 5
```

---

## 🔹 4. `for-each` Loop (Enhanced for Loop)

**Example:**

```java
public class Main 
{
    public static void main(String[] args) 
    {
        int[] numbers = {10, 20, 30, 40};
        for (int num : numbers) 
        {
            System.out.println(num);
        }
    }
}
```

✅ Output:

```bash
10
20
30
40
```

---

## 🔹 5. Nested Loops

**Example:**

```java
public class Main 
{
    public static void main(String[] args) 
    {
        for (int i = 1; i <= 3; i++) 
        {
            for (int j = 1; j <= 2; j++) 
            {
                System.out.println("i = " + i + ", j = " + j);
            }
        }
    }
}
```

✅ Output:

```bash
i = 1, j = 1
i = 1, j = 2
i = 2, j = 1
i = 2, j = 2
i = 3, j = 1
i = 3, j = 2
```

---

## 🔹 6. `break` and `continue`

**Example:**

```java
public class Main 
{
    public static void main(String[] args) 
    {
        for (int i = 1; i <= 5; i++) 
        {
            if (i == 3) continue; // skip 3
            if (i == 5) break;    // stop at 5
            System.out.println(i);
        }
    }
}
```

✅ Output:

```bash
1
2
4
```
