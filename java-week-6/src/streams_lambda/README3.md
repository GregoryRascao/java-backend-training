# Streams and Lambda: Ordering, Uniqueness, and Comparison Rules

## Lesson Goal

This lesson explains how Java decides:

- how `max(...)` works in streams
- what Java really means by call by value
- when to use `Comparable` vs `Comparator`
- why `sorted()` fails for non-comparable types without a comparator
- how to read and use `.thenComparing(Comparator.naturalOrder())`
- whether two objects are "the same" in a `Set`

---


## 2. Optional Example with `stream().max(...)`

`max(...)` can return no value for an empty stream, so it returns `Optional<T>`.

```java
import java.util.*;

public class MaxOptionalDemo {
    public static void main(String[] args) {
        List<Integer> scores = List.of(10, 44, 18, 44, 3);

        Optional<Integer> maxScore = scores.stream()
                .max(Integer::compareTo);

        maxScore.ifPresent(System.out::println); // 44

        int safeMax = scores.stream()
                .max(Integer::compareTo)
                .orElse(0);

        System.out.println(safeMax); // 44

        List<Integer> empty = List.of();
        int fallback = empty.stream().max(Integer::compareTo).orElse(-1);
        System.out.println(fallback); // -1
    }
}
```

---

## 3. `Comparable` vs `Comparator`

### `Comparable<T>`

- defines natural order inside the class itself
- method: `compareTo(T other)`
- example: `String`, `Integer`, `LocalDate`

### `Comparator<T>`

- external ordering strategy
- you can have MANY comparators for the same class
- useful when you cannot or should not modify the class

### `sorted()` Without Comparator on Non-Comparable Types

If stream elements do not implement `Comparable`, this fails at runtime.

```java
import java.util.*;

class Student {
    private final String name;
    private final int score;
    private final int age;
    private final String city;

    Student(String name, int score, int age, String city) {
        this.name = name;
        this.score = score;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return name + "(" + score + ", " + age + ", " + city + ")";
    }
}

class StudentComparators {
    // 1) Highest score first
    static final Comparator<Student> BY_SCORE_DESC =
            Comparator.comparingInt(Student::getScore).reversed();

    // 2) Name alphabetically (case-insensitive)
    static final Comparator<Student> BY_NAME_IGNORE_CASE =
            Comparator.comparing(Student::getName, String.CASE_INSENSITIVE_ORDER);

    // 3) City, then age, then name
    static final Comparator<Student> BY_CITY_AGE_NAME =
            Comparator.comparing(Student::getCity)
                    .thenComparingInt(Student::getAge)
                    .thenComparing(Student::getName);
}

public class SortedNonComparableDemo {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Amal", 85, 24, "Brussels"),
                new Student("bram", 85, 22, "Antwerp"),
                new Student("Noa", 92, 22, "Brussels")
        );

        // This compiles, but fails at runtime with ClassCastException:
        // students.stream().sorted().forEach(System.out::println);

        // Correct: provide a Comparator (you can choose different ones)
        students.stream()
                .sorted(StudentComparators.BY_SCORE_DESC)
                .forEach(System.out::println);

        students.stream()
                .sorted(StudentComparators.BY_NAME_IGNORE_CASE)
                .forEach(System.out::println);

        students.stream()
                .sorted(StudentComparators.BY_CITY_AGE_NAME)
                .forEach(System.out::println);
    }
}
```

If you want `sorted()` without arguments, make `Student` implement `Comparable<Student>`.

---


## 4. What Does `.thenComparing(Comparator.naturalOrder())` Mean?

`thenComparing(...)` adds a tie-breaker comparator.

Use case:

- primary sort key: score
- if scores are equal, apply secondary sort key with natural order

Example:

```java
import java.util.*;

record Player(String name, int score) {}

public class ThenComparingDemo {
    public static void main(String[] args) {
        List<Player> players = List.of(
                new Player("Zara", 90),
                new Player("Amal", 90),
                new Player("Noa", 95)
        );

        players.stream()
                .sorted(
                        Comparator.comparingInt(Player::score)
                        .thenComparing(Player::name, Comparator.naturalOrder())
                        // You can chain more thenComparing method calls also
                )
                .forEach(System.out::println);
    }
}
```

Reading this in plain language:

- sort by score ascending
- when score is tied, sort names alphabetically (`naturalOrder` for strings)

Equivalent shorter form for comparable key types:

```java
Comparator.comparingInt(Player::score)
          .thenComparing(Player::name)
```

Exact syntax example:

```java
List<String> words = List.of("pear", "apple", "fig", "plum");

List<String> result = words.stream()
    .sorted(Comparator.comparingInt(String::length)
        .thenComparing(Comparator.naturalOrder()))
    .toList();

System.out.println(result); // [fig, pear, plum, apple]
```

`Comparator.naturalOrder()` means default ascending order according to `Comparable`.

---

## 5. Call by Value vs Reference (Java)

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

## 6. How HashSet Checks Uniqueness

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


## Common Pitfalls

- Overriding `equals(...)` without `hashCode()` in hash-based collections
- Mutating fields used in `equals/hashCode` after object is placed in a `HashSet`
- Assuming Java is pass by reference
- Calling `sorted()` without comparator for non-comparable objects
- Forgetting that `max(...)` can be empty

## Key Insight

For robust stream code:

- define equality correctly (`equals` + `hashCode`) for set/map behavior
- define ordering clearly (`Comparable` or `Comparator`) for sorting/max/min
- handle missing values with `Optional`
