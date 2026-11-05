# Java Multithreading

This README is a gentle introduction to **multithreading** in Java.
Goal: understand the idea, learn the basic words, and write 1–2 tiny examples.

---

## 1) What is a thread?

A **thread** is a path of execution inside a program.

- **Single-thread** program: tasks happen one after another.
- **Multi-thread** program: tasks can run **at the same time** (or appear to, depending on CPU).

Why use threads?
- Doing multiple things at once (example: download + UI still responsive)
- Using multiple CPU cores
- Handling many requests (servers)

---

## 2) The most important warning

Threads share memory. That means:
- Two threads can modify the same variable at the same time.
- This can create **race conditions** (bugs that happen “sometimes”).

So multithreading is powerful… and easy to break if we are not careful.

---

## 3) Creating a thread (two common ways)

### Option A: `Runnable`

```java
public class DemoRunnable {
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Hello from: " + Thread.currentThread().getName());
        };

        Thread t = new Thread(task);
        t.start(); // IMPORTANT: start() runs in a new thread
        System.out.println("Main thread: " + Thread.currentThread().getName());
    }
}
```

-----------------------------
 start() creates a new thread
 run() does NOT create a new thread (it runs like a normal method)

Option B: extends Thread (works, but less flexible)
```java
public class DemoExtendsThread {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Running in: " + getName());
        }
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
```
4) sleep() and join() (simple control)
sleep(ms) pauses the current thread
```java
public class DemoSleep {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");
        Thread.sleep(500); // 0.5 seconds
        System.out.println("End");
    }
}
```
join() waits until another thread finishes
```java
public class DemoJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Worker: " + i);
            }
        });

        t.start();
        t.join(); // wait for t
        System.out.println("Main continues after worker finishes.");
    }
}
```
5) Shared data problem (race condition example)

This code looks correct but may print the wrong result:
```java
public class RaceConditionDemo {
    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) counter++;
            // Separating numbers with _ is allowed and it increases readability.
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) counter++;
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Counter = " + counter); // expected 200000, might be less
    }
}
```
### Why?

counter++ is NOT one step.

It’s like: read -> add -> write

Two threads can interleave those steps.

6) A simple fix: synchronized

synchronized makes sure only one thread at a time enters a critical section.
```java
public class SynchronizedDemo {
    static int counter = 0;

    static synchronized void increment() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) increment();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Counter = " + counter); // now reliably 200000
    }
}
```
 Good for basic safety
 Overusing synchronized can reduce performance (later topic)

## 7) Key vocabulary

Thread: execution unit

Runnable: task to run in a thread

start(): begin a new thread

run(): code executed by the thread

join(): wait for a thread to finish

sleep(): pause a thread

race condition: “sometimes wrong” bug due to timing

synchronized: only one thread at a time
