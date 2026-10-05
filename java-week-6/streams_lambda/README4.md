# Streams – Some Topics from Class

This document contains a few additional concepts that frequently appear when working with **Streams, Collections, and data processing in Java**.

These topics help developers write more expressive code and understand the **performance implications** of their choices.

---

# 1. `toList()` vs `collect(Collectors.toList())`

Both of the following produce a `List` from a stream:

```java
List<String> result = names.stream()
        .map(String::toUpperCase)
        .toList();
```

and

```java
List<String> result = names.stream()
        .map(String::toUpperCase)
        .collect(Collectors.toList());
```

### Differences

| Method                         | Notes                                         |
| ------------------------------ | --------------------------------------------- |
| `toList()`                     | Introduced in Java 16. Shorter and simpler.   |
| `collect(Collectors.toList())` | Older approach used in earlier Java versions. |

### Important detail

`toList()` returns an **unmodifiable list**.

```java
List<String> list = names.stream().toList();
list.add("test"); // may throw UnsupportedOperationException
```

`Collectors.toList()` usually returns a **mutable list**.

In modern Java code, `toList()` is usually preferred unless mutability is required.

---

# 2. `groupingBy`

`groupingBy` is one of the most powerful collectors in the Stream API.

It groups elements according to a key.

Example:

```java
Map<String, List<String>> byFirstLetter =
        names.stream()
             .collect(Collectors.groupingBy(name -> name.substring(0,1)));
```

Example result:

```
A → [Alice, Adam]
B → [Bob]
C → [Charlie]
```

Another common example:

```java
Map<String, Long> counts =
        words.stream()
             .collect(Collectors.groupingBy(
                     w -> w,
                     Collectors.counting()
             ));
```

Result:

```
java → 3
stream → 2
code → 1
```

This technique is often used for:

* frequency counting
* categorization
* statistics generation

---

# 3. `summaryStatistics()`

When working with numeric streams, Java provides a convenient utility:

```java
IntSummaryStatistics stats =
        numbers.stream()
               .mapToInt(Integer::intValue)
               .summaryStatistics();
```

From the `stats` object we can retrieve multiple metrics:

```java
stats.getCount();
stats.getSum();
stats.getMin();
stats.getMax();
stats.getAverage();
```

Example output:

```
count = 5
sum = 42
min = 2
max = 17
average = 8.4
```

This avoids writing multiple loops or calculations manually.

---

# 4. Other Common Collections

Streams often interact with Java collections.

Some commonly used collections include:

| Collection       | Description                                  | Order Maintained        
|------------------|----------------------------------------------|-------------------------
| `ArrayList`      | Resizable array-based list                   | ✔ Yes (insertion order) 
| `LinkedList`     | List implemented with linked nodes           | ✔ Yes (insertion order) 
| `HashSet`        | Set with fast lookup (no duplicates)         | ❌ No guaranteed order   
| `LinkedHashSet`  | HashSet that preserves insertion order       | ✔ Yes (insertion order) 
| `TreeSet`        | Sorted set                                   | ✔ Yes (sorted order)    
| `HashMap`        | Key-value store with fast lookup             | ❌ No guaranteed order   
| `LinkedHashMap`  | HashMap that preserves insertion order       | ✔ Yes (insertion order) 
| `TreeMap`        | Sorted key-value map                         | ✔ Yes (sorted by key) 

Choosing the right collection can have a **significant impact on performance**.

### Choosing the Right Collection

Java collections often follow this pattern:

- **Hash-based collections** (`HashSet`, `HashMap`)  
  → fastest lookup, but no order guarantee

- **Linked hash collections** (`LinkedHashSet`, `LinkedHashMap`)  
  → fast lookup and preserves insertion order

- **Tree-based collections** (`TreeSet`, `TreeMap`)  
  → elements are always kept sorted

### Note:

- **Hash-based collections** (`HashSet`, `HashMap`) → fastest lookup but no guaranteed order
- **LinkedHash collections** (`LinkedHashSet`, `LinkedHashMap`) → preserve insertion order
- **Tree-based collections** (`TreeSet`, `TreeMap`) → keep elements sorted

---

# 5. Big-O Notation (Performance Awareness)

Big-O notation describes how the **runtime of an algorithm grows** as the input size increases.

Some common examples:

| Operation                    | Complexity     |
| ---------------------------- | -------------- |
| Access element in array/list | `O(1)`         |
| Search in a list             | `O(n)`         |
| Search in a HashSet          | `O(1)` average |
| Sorting                      | `O(n log n)`   |
| groupingBy                   | `O(n)`         |

Example:

```java
list.contains(x);   // O(n)
set.contains(x);    // O(1)
```

For large datasets, these differences become very important.

### Important idea

> Streams make code cleaner, but they **do not change algorithmic complexity**.

Developers still need to choose appropriate data structures.

---

# Key Takeaways

* `toList()` is the modern way to collect stream results.
* `groupingBy` is useful for grouping and frequency counting.
* `summaryStatistics()` provides multiple numeric metrics at once.
* Choosing the right collection affects performance.
* Streams improve readability, but algorithm complexity still matters.

---

# Reflection Question

Why might a `Set` be faster than a `List` when checking if an element exists?

Think about the underlying data structures and their complexity.
