
## 1. Call by Value vs Reference (Java)

Java is always call by value.

What is copied when calling a method:

- for primitives: the primitive value itself
- for objects: the reference value (address-like handle), not the object itself

This is why:

- changing object state inside a method is visible outside
- reassigning the parameter to a new object is not visible outside

```java
class Box {
    int value;

    Box(int value) {
        this.value = value;
    }
}

public class CallByValueDemo {
    static void changeState(Box b) {
        b.value = 99; // affects original object
    }

    static void reassign(Box b) {
        b = new Box(500); // only local copy of reference changes
    }

    public static void main(String[] args) {
        Box box = new Box(10);

        changeState(box);
        System.out.println(box.value); // 99

        reassign(box);
        System.out.println(box.value); // still 99
    }
}
```

---

## 2. How HashSet Checks Uniqueness

When you add something to a HashSet:

set.add(obj);

Java internally does this:

Step 1 — get hash
int hash = obj.hashCode();
Step 2 — find bucket
bucket = hash % tableSize
Step 3 — compare equals

If objects exist in that bucket:

if(existing.equals(obj))
duplicate

So the rule is:

hashCode() → fast filtering
equals()   → real equality check


### Rule You Must Respect

If two objects are equal by `equals(...)`, they must return the same `hashCode()`.

If this contract is broken, sets/maps behave incorrectly.

### Example

```java
import java.util.*;

class Person {
    private final String email;

    Person(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "Person{" + email + '}';
    }
}

public class SetUniquenessDemo {
    public static void main(String[] args) {
        Set<Person> people = new HashSet<>();

        people.add(new Person("a@x.com"));
        people.add(new Person("a@x.com")); // duplicate by email
        people.add(new Person("b@x.com"));

        System.out.println(people.size()); // 2
        System.out.println(people);
    }
}
```

Note: `TreeSet` is different. It uses ordering (`compareTo`/`Comparator`) to decide duplicates, not `hashCode()`.



# 3. Other Common Collections

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

# 4. Big-O Notation (Performance Awareness)

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
