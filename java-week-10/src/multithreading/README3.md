# Multithreading (Part 3 - Futures & Async)

So far, we learned how to run tasks in parallel.

But there is a question:

### What if a task needs to return a result?

# Runnable vs Callable

We have already seen Runnable.

Runnable task = () -> System.out.println("Hello");

But it has a limitation:

it **cannot** return a value

# Enter: Callable
Callable<Integer> task = () -> 42;

 This can return a result.

# Future

When we submit a Callable, we get something back:

### a Future
```java
Future<Integer> future = executor.submit(() -> 42);
```
Think of Future as:

“I will give you the result... later”

### Getting the result
Integer result = future.get();

But careful:

### this line waits

If the task is not finished, our program will stop here.

This is called blocking.

### The problem with blocking

If we keep waiting for results:

we lose parallelism
our program becomes slower

Here comes the aid:

## CompletableFuture (modern approach)

Java gives us a better way:

**don’t wait...** continue when ready

```java
CompletableFuture<Integer> future =
CompletableFuture.supplyAsync(() -> 10)
.thenApply(x -> x * 2);

future.thenAccept(System.out::println);
```

## What is different here?
Task runs in background
No blocking
You define what happens next

### Combining multiple tasks
```java
CompletableFuture<Integer> f1 =
CompletableFuture.supplyAsync(() -> 10);

CompletableFuture<Integer> f2 =
CompletableFuture.supplyAsync(() -> 20);

CompletableFuture<Integer> result =
f1.thenCombine(f2, Integer::sum);
```
👉 Run tasks in parallel and combine results

### In summary
Runnable → no result
Callable → returns result
Future → result later
CompletableFuture → async flow
### Important note

Multithreading is powerful… but tricky.

* Don’t overuse it
* Keep things simple

