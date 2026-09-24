# Generics in Java (Part 1)

This folder now focuses on foundational generics only. It covers the base needed before moving to advanced variance topics.

---

## Why Use Generics

Generics let you write reusable code with compile-time type safety.

Without generics:

```java
List list = new ArrayList();
list.add("Hello");
list.add(123);
String s = (String) list.get(1); // Runtime ClassCastException
```

With generics:

```java
List<String> list = new ArrayList<>();
list.add("Hello");
String s = list.get(0);
```

---

## 1. Generic Classes

A generic class defines one or more type parameters such as `<T>`.

```java
public class Box<T>
{
    private T value;

    public Box(T value)
    {
        this.value = value;
    }

    public T getValue()
    {
        return value;
    }

    public void setValue(T value)
    {
        this.value = value;
    }
}
```

Common names:
- `T` for Type
- `E` for Element
- `K` for Key
- `V` for Value

---

## 2. Generic Methods

Generic methods are independent from generic classes and define their own type parameters.

```java
public class Utils
{
    public static <T> void printArray(T[] array)
    {
        for (T element : array)
        {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static <T> T getFirst(List<T> items)
    {
        if (items.isEmpty())
        {
            return null;
        }
        return items.get(0);
    }
}
```

---

## 3. Bounded Type Parameters

Use `extends` in a type parameter to restrict accepted types.

```java
public class NumberBox<T extends Number>
{
    private T number;

    public NumberBox(T number)
    {
        this.number = number;
    }

    public double toDouble()
    {
        return number.doubleValue();
    }
}
```

Multiple bounds are also possible:

```java
public class Processor<T extends Comparable<T> & Serializable>
{
}
```

---

## 4. Type Erasure

Java removes generic type details at runtime.

```java
List<String> strings = new ArrayList<>();
List<Integer> ints = new ArrayList<>();

System.out.println(strings.getClass() == ints.getClass()); // true
```

Important limitations:
- Cannot do `new T()`
- Cannot do `new T[10]`
- Cannot use primitives like `List<int>`

---

## 5. Good Practices

- Avoid raw types such as `List list`
- Prefer explicit generic types such as `List<String>`
- Use wrapper types (`Integer`, `Double`) for collections

---

## Learning Outcomes

After this part, you should be able to:
- Explain why generics improve safety
- Create generic classes and methods
- Apply bounded type parameters
- Recognize type erasure limitations

---

## Next Module

Generics unit Will continue next week, it starts from variance syntax and then goes into the remaining advanced topics.
