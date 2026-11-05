# Multithreading (Part 4 - Thinking & Best Practices)

This section focuses on how to **think about multithreading**.

We have seen tools like ExecutorService and Future...

Now the important question:

 **When and how should we use them correctly?**

---

##  When to use multithreading?

Good use cases:

* background tasks (file processing, logging)
* API calls in parallel
* heavy computations
* improving responsiveness (UI, web servers)

---

##  When NOT to use multithreading

Avoid it when:

* task is very small
* logic is simple
* performance is not critical

 Multithreading adds complexity
 Complexity = bugs

---

##  The biggest problem: Shared data

The main danger is **shared mutable state**.

Example:

```java
int counter = 0;
```

Multiple threads modify this → unpredictable results

 This is called a **race condition**

---

##  Rule #1: Avoid sharing data

Best solution:

 Do NOT share data at all

Bad:

```java
sharedCounter++
```

Better:

```java
return result instead of modifying shared state
```

---

##  Rule #2: If you must share → protect it

Use:

* `synchronized`
* or higher-level tools

Example:

```java
synchronized void increment() {
    counter++;
}
```

---

##  Rule #3: Prefer immutability

Immutable objects are safe by design.

Example:

```java
String
Integer
LocalDate
```

 Cannot be modified → no race condition

### Note:

Immutable objects are safe because they cannot be changed.

But if you need to update a shared value safely,
you need tools like AtomicInteger.
---

##  Rule #4: Keep threads independent

Each thread should:

* do its own job
* not depend on others too much

Bad design:

* threads waiting on each other
* complex dependencies

---

##  Rule #5: Avoid blocking when possible

Blocking:

```java
future.get();
```

Problems:

* wastes time
* reduces parallelism

Better:

* use async chaining (`CompletableFuture`)

---

##  Rule #6: Use high-level tools

Prefer:

* `ExecutorService`
* `CompletableFuture`

Avoid:

* manually managing many threads

---

##  Debugging multithreading issues

Hardest part of multithreading:

 Bugs are NOT consistent

We may see:

* works once
* fails next time
* impossible to reproduce

---

### Common symptoms:

* wrong values
* missing updates
* random behavior

---

### Debug tips:

* add logging with thread name:

```java
Thread.currentThread().getName()
```

* reduce number of threads
* simplify code
* isolate shared data

---

##  Common beginner mistakes

* calling `run()` instead of `start()`
* forgetting `join()`
* using shared variables without protection
* creating too many threads
* overusing multithreading

---

##  Golden Rule

 Start simple
 Add concurrency only if needed

---

##  Final mindset

Multithreading is not about:
 writing more threads

It is about:
 solving problems efficiently and safely

---

 If you can solve it without threads, do that first.

