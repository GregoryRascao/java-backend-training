# ArrayList in Java

## 1. Introduction
The **`ArrayList`** is a resizable array implementation provided in the **Java Collections Framework**.  
It belongs to the `java.util` package and implements the **List interface**.

- Unlike arrays, it **grows and shrinks dynamically**.
- Stores only **objects** (use wrapper classes like `Integer`, `Double`, etc. for primitives).
- Allows **duplicate elements**.
- Maintains **insertion order**.

---

## 2. Declaration and Initialization
//TODO: write about Arrays.asList and List.of
```java
import java.util.ArrayList;

// Generic ArrayList of integers
ArrayList<Integer> numbers = new ArrayList<>();

// With initial capacity
ArrayList<String> names = new ArrayList<>(20);

// Raw type (not recommended)
ArrayList list = new ArrayList();

// immutable list
var numbers = java.util.List.of(1, 2, 3);

// `asList(T... a)` → Convert **array to List**
// check arrays-class title 10
String[] arr = {"A", "B", "C"};
List<String> list = Arrays.asList(arr);
````

---

## 3. Commonly Used Methods in ArrayList

### 🔹 3.1 Adding Elements

```java
add(E e)              // Appends element to the end
add(int index, E e)   // Inserts element at given index
```

Example:

```java
ArrayList<String> list = new ArrayList<>();
list.add("A");                // ["A"]
list.add("B");                // ["A", "B"]
list.add(1, "C");             // ["A", "C", "B"]
```

---

### 🔹 3.2 Accessing Elements

```java
get(int index)   // Returns element at index
```

Example:

```java
String val = list.get(1); // "C"
```

---

### 🔹 3.3 Modifying Elements

```java
set(int index, E e)   // Replaces element at index
```

Example:

```java
list.set(1, "Z");   // ["A", "Z", "B"]
```

---

### 🔹 3.4 Removing Elements

```java
remove(int index)    // Removes element at index
remove(Object o)     // Removes first occurrence of element
clear()              // Removes all elements
```

Example:

```java
list.remove("A");    // ["Z", "B"]
list.clear();        // []
```

---

### 🔹 3.5 Size and Capacity

```java
size()            // Returns number of elements
isEmpty()         // Checks if list is empty
trimToSize()      // Trims capacity to current size
ensureCapacity()  // Increases capacity
```

Example:

```java
list.size();      // 2
list.isEmpty();   // false
```

---

### 🔹 3.6 Searching

```java
contains(Object o)   // Returns true if element exists
indexOf(Object o)    // Returns first index of element
lastIndexOf(Object o)// Returns last index of element
```

Example:

```java
list.contains("B");    // true
list.indexOf("B");     // 1
```

---

### 🔹 3.7 Iterating Through ArrayList

```java
// For loop
for (int i = 0; i < list.size(); i++) 
{
    System.out.println(list.get(i));
}

// Enhanced for loop
for (String item : list) 
{
    System.out.println(item);
}

```

---

### 🔹 3.8 Conversion

```java
toArray()   // Converts ArrayList to array
```

Example:

```java
String[] arr = list.toArray(new String[0]);
```

---

## 4. Important Notes

* **Null values** are allowed.
* **Duplicates** are allowed.

---

## 5. Example Program

```java
import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        System.out.println("Fruits: " + fruits);

        fruits.set(1, "Mango");
        System.out.println("After update: " + fruits);

        fruits.remove("Apple");
        System.out.println("After removal: " + fruits);

        System.out.println("Contains Cherry? " + fruits.contains("Cherry"));
        System.out.println("Size: " + fruits.size());
    }
}
```

---

## ✅ Summary

* `ArrayList` is a **resizable array** from the Java Collections Framework.
* Provides many useful methods for **adding, removing, searching, and iterating**.
* Use `ArrayList` when flexibility and built-in operations are required, instead of traditional arrays.

---

