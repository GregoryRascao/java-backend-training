# Multithreading (Part 2 - Thread Pools)

Up to now, we created threads manually using new Thread().

That works… but imagine doing this in a real application.

* What happens if you create 100 threads?
* Or 1000?

It quickly becomes hard to manage and can even crash your program.

So instead of creating threads one by one, Java gives us a better idea:

** Let’s reuse threads.**
---
## Similar idea in other places

Thread pools are not unique.

You may see the same idea in other parts of software:

Connection pooling (databases) → reuse database connections instead of opening new ones
String pool (Java) → reuse string objects instead of creating duplicates
---
### The core idea is always the same:
Reuse expensive resources instead of creating them again and again.

## The idea: Thread Pool

Instead of creating new threads every time, we create a pool of threads and reuse them.

Think of it like this:

You have a fixed number of workers
You give them tasks
They pick tasks and execute them

### ExecutorService

This is the tool that manages the thread pool.

You don’t create threads anymore.
You just submit tasks.
```java
ExecutorService executor = Executors.newFixedThreadPool(2);

executor.submit(() -> {
    System.out.println("Task running in: " + Thread.currentThread().getName());
});

executor.shutdown();
```
## What is happening here?
We created a pool with 2 threads
We sent a task using submit()
One of the threads runs that task
When done, the thread is reused

### Why is this better?
No need to manage threads manually
Reuses threads → more efficient
Easier to control how many threads run
### Important

Don’t forget:
```java
executor.shutdown();
```
Otherwise your program may not exit properly.

---

### For now, just remember:
Do **not** create threads manually in real applications — use a thread pool instead.

### Note:
Each ExecutorService manages its own tasks.
If one is overloaded, it will queue tasks — it does NOT send them to another executor automatically.

### Bonus
If you want that behavior, you need a shared pool or a work-stealing mechanism.
```java
Executors.newWorkStealingPool();
```
