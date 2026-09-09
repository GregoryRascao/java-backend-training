# Java Caching & Object Pools

Java uses **caching/pooling mechanisms** for some commonly used objects to save memory and improve performance.  
This affects how `==` and `.equals()` behave when comparing objects.

---

## 🔢 Wrapper Class Caches

Several wrapper classes cache frequently used values.  

| Type        | Cached Range                           | Notes                                                 |
|-------------|----------------------------------------|-------------------------------------------------------|
| `Byte`      | All values (-128 to 127)               | Entire range cached                                   |
| `Short`     | -128 to 127                            | Fixed                                                 |
| `Integer`   | -128 to 127 (configurable upper bound) | Controlled by `-Djava.lang.Integer.IntegerCache.high` |
| `Long`      | -128 to 127                            | Fixed                                                 |
| `Character` | 0 to 127                               | Fixed (basic ASCII)                                   |
| `Boolean`   | `true`, `false`                        | Both cached                                           |

### Example (Integer Cache)

```java
public class Main
{
    public static void main(String[] args) 
    {
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b); // true (cached)

        Integer c = 200;
        Integer d = 200;
        System.out.println(c == d); // false (outside cache range)
    }
}
````

---

## 🧵 String Intern Pool

Strings are managed differently: Java maintains a **String Intern Pool**.

* All **string literals** (e.g. `"hello"`) are automatically added to the pool.
* If the same literal appears again, the JVM reuses the existing pooled object.
* Calling `.intern()` manually adds a string to the pool (or returns the pooled reference if it already exists).

### Example (String Pool)

```java
public class Main
{
    public static void main(String[] args) 
    {
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2); // true (same pooled reference)

        String s3 = new String("hello");
        System.out.println(s1 == s3); // false (different objects)
        System.out.println(s1.equals(s3)); // true (same value)

        String s4 = s3.intern();
        System.out.println(s1 == s4); // true (both point to pool)
    }
}
```

---

## ✅ Summary

* **Wrapper Caches**: Fixed numeric ranges (or Booleans/ASCII chars) cached for reuse.
* **String Pool**: Stores string literals and interned strings; can grow dynamically at runtime.

👉 Always use `.equals()` for value comparison.
`==` only checks if two references point to the same object, which may or may not be true depending on caching.
