# Streams: Collecting, Aggregating, and Optional

## Lesson Goal

This lesson focuses on producing reusable results from stream pipelines and handling missing values safely.

By the end of the lesson, students should:

- Build result collections with `toList()` and `Collectors`
- Sort and deduplicate stream output
- Choose between `List.sort(...)` and `Stream.sorted(...)`
- Aggregate data with `reduce()` and primitive stream helpers
- Explain why stream operations like `max()`, `findFirst()`, and `average()` return `Optional`
- Use `Optional` safely with `orElse`, `orElseGet`, `orElseThrow`, and `ifPresent`
- Build small reporting pipelines with clear, null-safe logic

---

## Part 1: Materializing Results with `toList()` and `collect(...)`

Use `toList()` for simple immutable list results.
Use `collect(...)` when you need a specific result type.

```java
List<String> names = List.of("alice", "bob", "anna", "alex");

List<String> aNames = names.stream()
        .filter(n -> n.startsWith("a"))
        .map(String::toUpperCase)
        .toList();

Set<String> uniqueA = names.stream()
        .filter(n -> n.startsWith("a"))
        .collect(Collectors.toSet());
```

Common collectors:

- `Collectors.toList()`
- `Collectors.toSet()`
- `Collectors.toMap(...)`
- `Collectors.groupingBy(...)`

## Part 2: Ordering and Deduplication

```java
List<Integer> values = List.of(5, 1, 3, 2, 4, 3, 2);

List<Integer> cleanSorted = values.stream()
        .distinct()
        .sorted()
        .toList();
```

`List.sort(...)` vs `Stream.sorted(...)`:

- `List.sort(...)` mutates a mutable list
- `Stream.sorted(...)` returns a new ordered stream and keeps the source unchanged

## Part 3: Aggregation with `reduce()`

`reduce()` combines elements into a single value.

```java
List<Integer> numbers = List.of(2, 4, 6, 8);

int sum = numbers.stream().reduce(0, Integer::sum);
int product = numbers.stream().reduce(1, (acc, n) -> acc * n);
```

## Part 4: Primitive Streams (`IntStream`, `LongStream`, `DoubleStream`)

Primitive streams are specialized stream types for numeric data.

Why use them:

- They avoid boxing/unboxing overhead (`Integer` <-> `int`)
- They provide numeric terminal operations like `sum()`, `average()`, `min()`, `max()`
- They improve readability for number-heavy pipelines

### `IntStream` examples

```java
int evenSum = IntStream.rangeClosed(1, 10)
        .filter(n -> n % 2 == 0)
        .sum();

double avg = IntStream.of(4, 8, 12)
        .average()
        .orElse(0.0);
```

### Convert from object stream to primitive stream

```java
int total = numbers.stream().mapToInt(Integer::intValue).sum();
double avg = numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
```

### Convert back to object stream when needed

```java
List<Integer> squares = IntStream.rangeClosed(1, 5)
        .map(n -> n * n)
        .boxed()
        .toList();
```

### `LongStream` and `DoubleStream` quick examples

```java
long longTotal = LongStream.of(10L, 20L, 30L).sum();
double maxValue = DoubleStream.of(2.5, 7.1, 3.9).max().orElse(0.0);
```

## Part 5: Optional in Stream Pipelines

Some stream operations may have no result, so Java returns `Optional`.

Common cases:

- `findFirst()` -> `Optional<T>`
- `max(...)` / `min(...)` -> `Optional<T>`
- `reduce(BinaryOperator<T>)` (without identity) -> `Optional<T>`
- `average()` on primitive streams -> `OptionalDouble`

### Why Optional?

It makes "no value" explicit and avoids null-related bugs.

### Example: Safe max value

```java
List<Integer> scores = List.of();

int best = scores.stream()
        .max(Integer::compareTo)
        .orElse(0);

System.out.println(best); // 0 when list is empty
```

### Useful Optional methods

```java
Optional<String> maybeName = List.of("Ada", "Bob").stream()
        .filter(n -> n.startsWith("Z"))
        .findFirst();

String name1 = maybeName.orElse("Unknown");
String name2 = maybeName.orElseGet(() -> "Generated-" + System.currentTimeMillis());
maybeName.ifPresent(System.out::println);
String name3 = maybeName.orElseThrow(() -> new IllegalStateException("Name not found"));
```

Guidelines:

- Prefer `orElseGet(...)` if the fallback is expensive
- Avoid calling `get()` directly unless presence is guaranteed
- Keep Optional at boundaries; do not use it as a field type in beginner exercises

## Part 6: Grouping and Summaries

```java
List<String> names = List.of("Alice", "Adam", "Bob", "Bella", "Charlie");

Map<Character, Long> countByInitial = names.stream()
        .collect(Collectors.groupingBy(n -> n.charAt(0), Collectors.counting()));

IntSummaryStatistics stats = IntStream.of(4, 8, 12, 20)
        .summaryStatistics();
```

`IntSummaryStatistics` gives you count, sum, min, max, and average in one object.

## Part 7: Real-World Example (With Optional)

```java
List<Integer> amounts = List.of(120, 40, 120, 300, 75, 40, 500);

List<Integer> report = amounts.stream()
        .filter(a -> a >= 100)
        .distinct()
        .sorted()
        .toList();

int total = amounts.stream()
        .filter(a -> a >= 100)
        .mapToInt(Integer::intValue)
        .sum();

int highest = amounts.stream()
        .filter(a -> a >= 100)
        .max(Integer::compareTo)
        .orElse(0);

System.out.println(report);
System.out.println(total);
System.out.println(highest);
```

## Part 8: Common Pitfalls

- Using `forEach()` when you need a returned result
- Reusing a stream after a terminal operation
- Calling `sorted()` without a comparator on non-comparable types
- Overusing `reduce()` when `sum()` or `count()` is clearer
- Calling `Optional.get()` without checking presence

## Exercise: Build a Null-Safe Report

Given:

```java
List<String> products = List.of("Book", "Pen", "Book", "Laptop", "Pencil", "Pen");
List<Integer> prices = List.of(25, 5, 25, 900, 3, 5);
```

Tasks:

1. Produce unique, alphabetically sorted product names
2. Compute total price
3. Find the highest price using an Optional-safe approach
4. Print all results

## Key Insight

A strong stream pipeline is not only about transformation.
It is also about:

- shaping results (`collect`, `groupingBy`)
- aggregating safely (`sum`, `reduce`)
- handling missing values explicitly (`Optional`)
