# Streams FAQ

This document answers common questions asked when first learning **Java Streams**.

---

## 1. What is a Stream?

A **Stream** is not a collection.

It is a **pipeline of operations applied to data**.

### Example

```java
numbers.stream()
       .filter(n -> n > 5)
       .map(n -> n * 2)
       .forEach(System.out::println);
```

Streams process data, but they do not store data.

## 2. Do Streams Modify the Original List?

No.

Streams work in a functional style and usually produce new results.

### Example

```java
List<Integer> numbers = List.of(1, 2, 3, 4);

List<Integer> filtered = numbers.stream()
                                .filter(n -> n > 2)
                                .toList();
```

The original list remains unchanged.

## 3. Why Does `filter()` Need a Boolean Condition?

`filter()` uses a `Predicate<T>`.

A `Predicate<T>` represents a function:

```java
boolean test(T value)
```

### Example

```java
.filter(n -> n > 10)
```

- `true` -> keep the element
- `false` -> discard the element

## 4. Why Can a Stream Only Be Used Once?

Streams are consumed after a terminal operation.

### Example

```java
Stream<Integer> stream = numbers.stream();

stream.forEach(System.out::println);
stream.forEach(System.out::println); // IllegalStateException
```

Once a terminal operation runs (`forEach`, `collect`, `sum`, etc.), the stream is closed.

If you need another stream, call `.stream()` again.

## 5. What Is the Difference Between `map()` and `filter()`?

`filter()` keeps or removes elements.

```java
.filter(n -> n > 10)
```

`map()` transforms elements.

```java
.map(n -> n * 2)
```

### Example Pipeline

```java
numbers.stream()
       .filter(n -> n > 10)
       .map(n -> n * 2)
       .forEach(System.out::println);
```

## 6. What Does `mapToInt()` Do?

`mapToInt()` converts a stream into a primitive stream (`IntStream`).

### Example

```java
numbers.stream()
       .mapToInt(n -> n * n)
       .sum();
```

Primitive streams are efficient for numeric operations such as:

- `sum()`
- `average()`
- `min()`
- `max()`

## 7. What Is a Terminal Operation?

Stream operations are divided into two categories:

### Intermediate Operations

These return another stream.

Examples:

- `filter()`
- `map()`
- `sorted()`

### Terminal Operations

These produce a result or side effect.

Examples:

- `forEach()`
- `collect()`
- `sum()`
- `toList()`

A stream pipeline must end with a terminal operation.

## 8. Why Do Streams Use Lambda Expressions?

Streams rely on functional interfaces.

| Operation | Interface |
| --- | --- |
| `filter()` | `Predicate<T>` |
| `map()` | `Function<T, R>` |
| `forEach()` | `Consumer<T>` |

### Example

```java
numbers.stream()
       .filter(n -> n % 2 == 0)
       .forEach(System.out::println);
```

Lambdas make these operations concise and readable.

## 9. When Should I Use Streams Instead of Loops?

Streams are useful when you want to:

- Process collections declaratively
- Chain operations
- Write concise data transformations

### Example

Loop:

```java
for (Integer n : numbers) {
    if (n > 5) {
        System.out.println(n);
    }
}
```

Stream:

```java
numbers.stream()
       .filter(n -> n > 5)
       .forEach(System.out::println);
```

Both work, but streams are often more expressive for data pipelines.

## 10. Can Streams Be Parallel?

Yes. Java supports parallel streams.

### Example

```java
numbers.parallelStream()
       .filter(n -> n > 10)
       .forEach(System.out::println);
```

Parallel streams can run operations across multiple threads.

Use them carefully and only when performance benefits are clear.