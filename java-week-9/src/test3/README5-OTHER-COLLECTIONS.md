# Queues, Stacks & Testing Collection Contents

You already know how lists, sets and maps store data, and how some collections preserve or sort their iteration order.
Now we will look at collections that help us decide **which item to process next**.

---

## 1. Queue — First In, First Out

A FIFO queue works like a line of customers: the first person to join is the first person served.

`Queue<E>` is an interface. `ArrayDeque<E>` is one implementation we can use:

```java
Queue<String> customers = new ArrayDeque<>();
customers.offer("Gayatri");
customers.offer("Mila");
customers.offer("Oleg");

System.out.println(customers.peek()); // Gayatri — look without removing
System.out.println(customers.poll()); // Gayatri — remove and return
System.out.println(customers.poll()); // Mila
System.out.println(customers);        // [Oleg]
```

| Method | Action | When the queue is empty |
|---|---|---|
| `offer(e)` | Add an item; returns whether it was accepted | Adds the item |
| `peek()` | Look at the next item without removing it | Returns `null` |
| `poll()` | Remove and return the next item | Returns `null` |
| `remove()` | Remove and return the next item | Throws `NoSuchElementException` |

Use a FIFO queue for pending tasks or requests that should be handled in arrival order. **Not every `Queue` implementation is FIFO**: we will see a priority queue below.

---

## 2. Stack — Last In, First Out

A stack works like a pile of plates: the last plate added is the first one removed.

Use a `Deque` implemented by `ArrayDeque`:

```java
Deque<String> actions = new ArrayDeque<>();
actions.push("Write title");
actions.push("Add image");
actions.push("Change colour");

System.out.println(actions.peek()); // Change colour
System.out.println(actions.pop());  // Change colour
System.out.println(actions.pop());  // Add image
```

| Method | Action |
|---|---|
| `push(e)` | Add an item to the top |
| `peek()` | Look at the top; returns `null` when empty |
| `pop()` | Remove the top; throws `NoSuchElementException` when empty |

An undo feature can keep actions in a stack so the most recent action is undone first. Other examples include checking matching brackets and exploring paths with backtracking.

Java also has a class called `Stack`, but the Java API recommends `Deque` instead for stack operations. You should recognise `Stack` in older code; use `Deque` in these examples.

---

## 3. Deque & ArrayDeque — How They Fit Together

**Deque** means **double-ended queue**: items can be added or removed at either end.

| Name | What it is |
|---|---|
| `Queue<E>` | Interface for holding items to process |
| `Deque<E>` | Interface extending `Queue`, with operations at both ends |
| `ArrayDeque<E>` | Resizable-array implementation of `Deque` |

```java
Deque<String> tasks = new ArrayDeque<>();
tasks.addLast("Normal task");
tasks.addFirst("Urgent task");

System.out.println(tasks.removeFirst()); // Urgent task
System.out.println(tasks.removeLast());  // Normal task
```

The same implementation supports two familiar behaviours:

- **FIFO:** `offer()` adds at the back; `poll()` removes from the front.
- **LIFO:** `push()` adds at the front; `pop()` removes from the front.

Choose the interface that expresses your intention: `Queue` for FIFO examples, `Deque` for stack or two-ended operations. Unlike a `List`, a deque does not provide indexed access such as `get(2)`.

`ArrayDeque` allows duplicates, rejects `null` elements, and is not thread-safe. Its iterator visits items from front to back; when used as a stack, that means top to bottom.

---

## 4. PriorityQueue & Heap — Priority Comes First

Sometimes the next item should be chosen by priority rather than arrival time.

```java
Queue<Integer> priorities = new PriorityQueue<>();
priorities.offer(30);
priorities.offer(10);
priorities.offer(20);

System.out.println(priorities.poll()); // 10
System.out.println(priorities.poll()); // 20
System.out.println(priorities.poll()); // 30
```

By default, the smallest value comes first. A `Comparator` can change that:

```java
Queue<Integer> highestFirst =
        new PriorityQueue<>(Comparator.reverseOrder());
highestFirst.addAll(List.of(30, 10, 20));

System.out.println(highestFirst.poll()); // 30
```

`PriorityQueue` uses a **heap** internally. In a min-heap, each parent's value is no greater than its children's, so a minimum is at the root. This is a partial ordering, not a fully sorted sequence. You do not need to implement a heap for this lesson.

**Unlike `TreeSet`, `PriorityQueue` allows duplicates and does not guarantee sorted iteration.** Printing it, using `forEach`, or converting it to a list does not guarantee priority order. Repeated `poll()` calls retrieve items in priority order, removing them as you go. Ties have no guaranteed arrival order.

> A heap data structure is different from the JVM heap memory area. Likewise, using a stack collection is different from discussing the JVM call stack.

---

## 5. Choosing the Right Structure

| Need | Typical choice |
|---|---|
| Access items by index | `List` with `ArrayList` |
| Process items in arrival order | `Queue` with `ArrayDeque` |
| Process the most recently added item first | `Deque` with `ArrayDeque` |
| Add or remove at both ends | `Deque` with `ArrayDeque` |
| Repeatedly process the smallest/highest-priority item | `PriorityQueue` |
| Keep unique elements in sorted iteration order | `TreeSet` |

---

## 6. Testing Contents: assertEquals vs assertIterableEquals

For objects, `assertEquals(expected, actual)` uses their equality behaviour. For lists, `equals()` already compares the elements in order, so **both assertions work**:

```java
assertEquals(List.of("GAYATRI", "MILA"), List.of("GAYATRI", "MILA"));
assertIterableEquals(List.of("GAYATRI", "MILA"), List.of("GAYATRI", "MILA"));
```

`assertIterableEquals` compares the elements produced by two iterators in order. The number of elements must also match. This matters when the collection's own `equals()` does not express what your test needs.

It is not the only possible solution—you could convert collections to lists—but in the following examples, **directly replacing it with `assertEquals` changes what is tested**.

The test examples use these imports:

```java
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
```

### Example 1: Two separate ArrayDeque objects

`ArrayDeque` inherits identity-based `equals()` from `Object`. Two separate deques are not equal according to that method, even when their contents match.

```java
@Test
void queuesContainTheSameCustomers() {
    Queue<String> expected = new ArrayDeque<>(List.of("Gayatri", "Mila"));
    Queue<String> actual = new ArrayDeque<>(List.of("Gayatri", "Mila"));

    assertIterableEquals(expected, actual); // Passes: same contents and order
    // assertEquals(expected, actual);      // Would fail: separate objects
}
```

### Example 2: Expected list, actual stack

We can describe expected contents with `List.of(...)` even when the result is a deque.

```java
@Test
void newestActionIsAtTheTop() {
    Deque<String> actions = new ArrayDeque<>();
    actions.push("Write title");
    actions.push("Add image");

    assertIterableEquals(List.of("Add image", "Write title"), actions);
    // assertEquals(List.of("Add image", "Write title"), actions);
    // Would fail: List.equals() does not consider a deque an equal list.
}
```

The assertion checks the current top-to-bottom contents without removing anything. To test removal behaviour too, also check the results of `pop()`.

### Example 3: LinkedHashSet order matters

Set equality checks membership, **not iteration order**. If insertion order is part of the requirement, `assertEquals` alone can miss a bug:

```java
@Test
void preservesRegistrationOrder() {
    Set<String> expected = new LinkedHashSet<>(List.of("Gayatri", "Mila"));
    Set<String> actual = new LinkedHashSet<>(List.of("Mila", "Gayatri"));

    assertEquals(expected, actual);         // Passes: same members
    assertIterableEquals(expected, actual); // Fails: wrong iteration order
}
```

This test deliberately fails to demonstrate the difference. Change `actual` to the required order to make it pass.

**Choose the assertion based on the requirement:**

- Same set members, order irrelevant? Use `assertEquals` on sets.
- Same sequence of elements? Use `assertIterableEquals` when ordinary equality is unsuitable.
- Do not assume `HashSet` has a stable iteration order, or `PriorityQueue` iterates in priority order.

### See Example 10
## Compare collection results

When a method returns a collection, compare the expected and actual contents rather than only checking that the result is non-null:

```java
    assertIterableEquals(List.of("BRUSSELS", "GHENT"), Files.readAllLines(output));
    assertEquals(List.of("BRUSSELS", "GHENT"), Files.readAllLines(output));
    // Both assertions work here because List.equals() compares elements in order.
    // assertIterableEquals explicitly checks iterable contents and their order.
```

For file tests, Week 7 introduced using a temporary destination instead of a shared project file. [Example 10](examples/Example10.java) demonstrates JUnit's `@TempDir` support.


---

## 7. Exercise — Test a Waiting Queue

The implementation below prepares a FIFO queue of customer names. Your task is to **write JUnit tests for its behaviour**.

### Requirements

- Trim each name and skip names that are empty after trimming.
- Preserve the remaining names' original order and letter case.
- Keep duplicate names: two customers may have the same name.
- Return an empty queue for an empty list or a list containing only blank names.
- Throw `IllegalArgumentException` if the input list or any name is `null`.
- Do not modify the input list.

Put this code in `WaitingQueue.java`:

```java
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class WaitingQueue {
    public static Queue<String> prepare(List<String> names) {
        if (names == null) {
            throw new IllegalArgumentException("Names must not be null");
        }

        Queue<String> result = new ArrayDeque<>();
        for (String name : names) {
            if (name == null) {
                throw new IllegalArgumentException("A name must not be null");
            }

            String cleaned = name.trim();
            if (!cleaned.isEmpty()) {
                result.offer(cleaned);
            }
        }
        return result;
    }
}
```

Start a `WaitingQueueTest` class with the test imports from section 6:

```java
@Test
void trimsNamesAndPreservesOrder() {
    Queue<String> actual = WaitingQueue.prepare(List.of(" Gayatri ", "", "Mila"));

    // TODO: Check the complete contents and their order.
}
```

Write separate tests covering these cases:

| Case | Input / action | Expected behaviour |
|---|---|---|
| Cleaning and order | `[" Gayatri ", "", "Mila"]` | Contents: `["Gayatri", "Mila"]` |
| Single name and case | `[" mila "]` | Contents: `["mila"]` |
| Duplicates | `["Gayatri", "Gayatri"]` | Both names remain |
| No customers | Empty list; separately, `["", "   "]` | Empty queue in both cases |
| Invalid list | `null` | `IllegalArgumentException` |
| Invalid element | `["Gayatri", null]` | `IllegalArgumentException` |
| FIFO removal | Prepare `["Gayatri", "Mila"]`, then call `poll()` three times | `"Gayatri"`, then `"Mila"`, then `null` |
| Input unchanged | Pass a mutable list and keep a copy of its original contents | Input still equals its original copy |

Use `assertIterableEquals` for queue contents, `assertEquals` for individual returned values, `assertNull` for an exhausted queue, and `assertThrows` for invalid input.

**Hint:** `List.of(...)` rejects `null` before your method is called. Use `Arrays.asList("Gayatri", null)` for the null-element test. For the input-unchanged test, use an `ArrayList` containing names with spaces and an empty name, so accidental in-place cleaning would be detectable.

**Explain:** Why is `assertNotNull(actual)` insufficient? Why would `assertEquals(List.of("Gayatri", "Mila"), actual)` fail even when this method is correct?

---

## Learning Outcomes

After this topic, you should be able to:

- Distinguish FIFO queues, LIFO stacks and priority queues.
- Use `ArrayDeque` through `Queue` and `Deque` interfaces.
- Explain the connection between a heap and `PriorityQueue`.
- Distinguish iteration order from priority-removal order.
- Choose between object equality and ordered-content assertions.
- Test normal inputs, boundary cases, invalid inputs and observable behaviour.

## References

- [Java: Deque](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Deque.html)
- [Java: ArrayDeque](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayDeque.html)
- [Java: Stack](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Stack.html)
- [Java: PriorityQueue](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/PriorityQueue.html)
- [Java: List.equals](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/List.html#equals(java.lang.Object))
- [Java: Set.equals](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Set.html#equals(java.lang.Object))
- [JUnit 5: Assertions](https://docs.junit.org/5.9.1/api/org.junit.jupiter.api/org/junit/jupiter/api/Assertions.html)
