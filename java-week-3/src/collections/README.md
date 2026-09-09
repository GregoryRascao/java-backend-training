# 📚 Java Collections: List, ArrayList, Set, and Map

The **Java Collections Framework (JCF)** provides a rich set of data structures and algorithms for storing and manipulating groups of objects efficiently.

---

## 🔑 1. List

* **Interface** in Java.  
* Represents an **ordered collection** (elements have positions/indexes).  
* Allows **duplicate elements**.  
* Elements can be accessed by index (`list.get(0)`).  

✅ Think of it as a **to-do list**: order matters, and items can repeat.

### Example

```java
import java.util.List;
import java.util.ArrayList;

public class ListExample 
{
    public static void main(String[] args) 
    {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Alice"); // duplicates allowed

        System.out.println(names);        // [Alice, Bob, Alice]
        System.out.println(names.get(0)); // Alice
    }
}
````

---

## 🔑 2. ArrayList

* A **class** that implements the **List** interface.
* Backed by a **resizable array** (grows and shrinks dynamically).
* Most commonly used `List` implementation.
* Provides **fast random access** (efficient `get(index)`).

### Example

```java
import java.util.ArrayList;

public class ArrayListExample 
{
    public static void main(String[] args) 
    {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println(numbers); // [10, 20, 30]

        numbers.remove(1);           // remove element at index 1
        System.out.println(numbers); // [10, 30]
    }
}
```

---

## 🔑 3. Set

* **Interface** in Java.
* Represents a **collection of unique elements**.
* **No duplicates allowed**.
* Does **not guarantee order** (depends on implementation).

✅ Think of it as a **bag of unique student IDs**: each ID must be different.

### Example

```java
import java.util.Set;
import java.util.HashSet;

public class SetExample 
{
    public static void main(String[] args) 
    {
        Set<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Apple"); // ignored (duplicate)

        System.out.println(fruits); // [Apple, Banana] (order not guaranteed)
    }
}
```

---

## 🔑 4. Map

* **Interface** in Java.
* Stores **key-value pairs**.
* Keys must be **unique**, values may be **duplicated**.
* No direct index access → retrieve values using keys.

✅ Think of it as a **dictionary**: word → definition.

### Example

```java
import java.util.Map;
import java.util.HashMap;

public class MapExample {
    public static void main(String[] args) 
    {
        Map<String, Integer> ages = new HashMap<>();

        ages.put("Alice", 25);
        ages.put("Bob", 30);
        ages.put("Alice", 26); // overwrites old value

        System.out.println(ages);            // {Bob=30, Alice=26}
        System.out.println(ages.get("Bob")); // 30
    }
}
```

---

## 📊 Quick Comparison Table

| Feature           | List (interface)          | ArrayList (class) | Set (interface)                         | Map (interface)             |
|-------------------|---------------------------|-------------------|-----------------------------------------|-----------------------------|
| Stores elements   | ✅ Yes                     | ✅ Yes             | ✅ Yes (unique only)                     | ✅ Yes (key-value pairs)     |
| Allows duplicates | ✅ Yes                     | ✅ Yes             | ❌ No                                    | ✅ Values yes, Keys no       |
| Ordered           | ✅ Yes                     | ✅ Yes             | ❌ (HashSet), ✅ (LinkedHashSet, TreeSet) | ❌ Depends on implementation |
| Access by index   | ✅ Yes                     | ✅ Yes             | ❌ No                                    | ❌ No (access by key)        |
| Common classes    | `ArrayList`, `LinkedList` | `ArrayList`       | `HashSet`, `TreeSet`                    | `HashMap`, `TreeMap`        |

---

## 🎯 Learning Outcomes

* `List` / `ArrayList` → use when **order and duplicates** matter.
* `Set` → use when **uniqueness** is required.
* `Map` → use when working with **key-value relationships**.
* Understand which collection to use for different problem scenarios.

---

## 🗂 Collections Framework Hierarchy (Simplified)

```txt
                         Iterable (interface)
                               │
                       ┌───────┴────────┐
                       │                │
                Collection (interface)  Map (interface)
                       │                │
        ┌──────────────┼──────────┐     ├───────────────┐
        │              │          │     │               │
      List            Set       Queue  HashMap       SortedMap
        │              │          │     │               │
┌──────┼─────┐   ┌────┼────┐     │   LinkedHashMap   TreeMap
│      │     │   │    │    │     │   WeakHashMap
ArrayList LinkedList Vector HashSet TreeSet EnumSet   Hashtable
│       │     │
│       │     │
│     Stack LinkedHashSet
│
│
(also implements Queue) ──────> PriorityQueue
└──> ArrayDeque
```
---


* **Immutable collections (Java 9)** → `List.of`, `Map.of`
