# Streams: Collecting, Aggregating, and Optional

## Lesson Goal

In the previous lesson, we created simple stream pipelines using:

- `filter()`
- `map()`
- `forEach()`

Now we will go one step further.

Instead of only printing values, we often want to:

- create a new collection
- sort or remove duplicates
- calculate totals or averages
- find one particular value
- handle cases where no result exists

By the end of this lesson, we should be able to:

- Create result collections with `toList()` and `collect()`
- Use `distinct()` and `sorted()`
- Understand the difference between intermediate and terminal operations
- Combine values with `reduce()`
- Use primitive streams such as `IntStream`
- Understand why some stream operations return `Optional`
- Safely handle missing results
- Build small reporting pipelines

---

## Part 1: A Stream Pipeline Has an End

Last lesson we wrote pipelines like this:

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);

numbers.stream()
       .filter(n -> n > 2)
       .map(n -> n * 10)
       .forEach(System.out::println);
```

There are two important kinds of stream operations.

### Intermediate operations

These return another stream.

Examples:

```java
filter()
map()
distinct()
sorted()
```

They allow us to continue the pipeline.

```java
numbers.stream()
       .filter(n -> n > 2)
       .map(n -> n * 10);
```

At this point we still have a stream.

### Terminal operations

These finish the stream pipeline and produce a result or perform an action.

Examples:

```java
toList()
collect()
forEach()
sum()
count()
reduce()
findFirst()
max()
```

For example:

```java
List<Integer> result = numbers.stream()
        .filter(n -> n > 2)
        .map(n -> n * 10)
        .toList();
```

Here:

```text
stream()
   ↓
filter()      intermediate
   ↓
map()         intermediate
   ↓
toList()      terminal
   ↓
List<Integer>
```

After a terminal operation, the stream is finished.

---

## Part 2: Creating Results with `toList()`

Until now, we often ended streams with `forEach()`.

But `forEach()` only performs an action.

If we want to keep the result, we can use `toList()`.

```java
List<String> names = List.of(
        "alice",
        "bob",
        "anna",
        "alex"
);

List<String> aNames = names.stream()
        .filter(name -> name.startsWith("a"))
        .map(String::toUpperCase)
        .toList();

System.out.println(aNames);
```

Output:

```text
[ALICE, ANNA, ALEX]
```

The original list is still unchanged.

```java
System.out.println(names);
```

Output:

```text
[alice, bob, anna, alex]
```

Streams normally process data without modifying the original collection.

### Important: `toList()` returns an unmodifiable list

The result of `Stream.toList()` cannot be modified.

```java
List<String> result = names.stream()
        .toList();

result.add("David"); // UnsupportedOperationException
```

This is useful when we only need the result for reading.

---

## Part 3: `collect()`

Sometimes we want something other than a simple list.

For example, we may want a `Set`.

```java
List<String> names = List.of(
        "Alice",
        "Bob",
        "Alice",
        "Anna"
);

Set<String> uniqueNames = names.stream()
        .collect(Collectors.toSet());

System.out.println(uniqueNames);
```

A `Set` automatically removes duplicate values.

### Common collectors

```java
Collectors.toList()
Collectors.toSet()
Collectors.toMap(...)
Collectors.groupingBy(...)
Collectors.counting()
```

Example:

```java
Set<String> namesStartingWithA = names.stream()
        .filter(name -> name.startsWith("A"))
        .collect(Collectors.toSet());
```

### `toList()` or `collect()`?

For a normal list:

```java
stream.toList();
```

is usually the simplest choice.

Use `collect()` when you need more control over the result.

For example:

```java
Set<String> result = stream.collect(Collectors.toSet());
```

or later:

```java
Map<String, List<Person>> result =
        stream.collect(Collectors.groupingBy(Person::getDepartment));
```

### What if we need a mutable list?

We can explicitly create an `ArrayList`.

```java
List<String> result = names.stream()
        .collect(Collectors.toCollection(ArrayList::new));

result.add("David");
```

---

## Part 4: Removing Duplicates with `distinct()`

Consider:

```java
List<Integer> numbers =
        List.of(5, 1, 3, 2, 4, 3, 2);
```

We can remove duplicate elements with:

```java
List<Integer> unique = numbers.stream()
        .distinct()
        .toList();

System.out.println(unique);
```

Output:

```text
[5, 1, 3, 2, 4]
```

Notice that `distinct()` keeps the original encounter order.

For objects, `distinct()` uses `equals()` and `hashCode()` to decide whether two objects are equal.

---

## Part 5: Sorting with `sorted()`

We can sort stream elements using `sorted()`.

```java
List<Integer> sorted = numbers.stream()
        .sorted()
        .toList();
```

Output:

```text
[1, 2, 2, 3, 3, 4, 5]
```

We can combine it with `distinct()`.

```java
List<Integer> cleanSorted = numbers.stream()
        .distinct()
        .sorted()
        .toList();
```

Output:

```text
[1, 2, 3, 4, 5]
```

### Custom sorting

Remember the `Comparator<T>` functional interface from the previous lesson.

```java
List<Integer> descending = numbers.stream()
        .sorted((a, b) -> Integer.compare(b, a))
        .toList();
```

Or:

```java
List<Integer> descending = numbers.stream()
        .sorted(Comparator.reverseOrder())
        .toList();
```

---

## Part 6: `List.sort()` vs `Stream.sorted()`

These two look similar, but behave differently.

### `List.sort()`

Changes the existing list.

```java
List<Integer> numbers =
        new ArrayList<>(List.of(5, 3, 1, 4, 2));

numbers.sort(Integer::compareTo);

System.out.println(numbers);
```

The original list is now sorted.

### `Stream.sorted()`

Does not change the original collection.

```java
List<Integer> numbers =
        List.of(5, 3, 1, 4, 2);

List<Integer> sorted = numbers.stream()
        .sorted()
        .toList();
```

Now:

```java
System.out.println(numbers);
```

still prints:

```text
[5, 3, 1, 4, 2]
```

while:

```java
System.out.println(sorted);
```

prints:

```text
[1, 2, 3, 4, 5]
```

A simple rule:

```text
list.sort()      → modify this list

list.stream().sorted()  → create a sorted stream/result
```

---

## Part 7: Aggregating Values

Sometimes we do not want another collection.

We want one result.

For example:

```text
[10, 20, 30, 40]
       ↓
      100
```

This is called aggregation.

Common aggregation operations include:

```java
sum()
count()
min()
max()
average()
reduce()
```

---

## Part 8: `reduce()`

`reduce()` combines many elements into one value.

Example:

```java
List<Integer> numbers =
        List.of(2, 4, 6, 8);

int sum = numbers.stream()
        .reduce(0, (a, b) -> a + b);

System.out.println(sum);
```

Output:

```text
20
```

We can also write:

```java
int sum = numbers.stream()
        .reduce(0, Integer::sum);
```

### What does `0` mean?

The first argument is called the **identity value**.

```java
reduce(0, Integer::sum)
```

Think of the calculation like this:

```text
0 + 2 = 2
2 + 4 = 6
6 + 6 = 12
12 + 8 = 20
```

For addition, `0` is a good identity because:

```text
0 + x = x
```

For multiplication, we usually use `1`.

```java
int product = numbers.stream()
        .reduce(1, (result, n) -> result * n);
```

Why `1`?

Because:

```text
1 * x = x
```

### Accumulator

You will sometimes see code like:

```java
.reduce(0, (acc, n) -> acc + n)
```

`acc` means accumulator.

It represents the result built so far.

---

## Part 9: `reduce()` Without an Identity

We can also write:

```java
Optional<Integer> result = numbers.stream()
        .reduce(Integer::sum);
```

Why does this return an `Optional<Integer>` instead of `Integer`?

Because the stream could be empty.

```java
List<Integer> numbers = List.of();
```

What is the sum if Java has no identity value and no elements?

There is no result.

Therefore Java returns:

```java
Optional<Integer>
```

We will look at `Optional` shortly.

---

## Part 10: Primitive Streams

Normal streams work with objects.

For example:

```java
Stream<Integer>
Stream<Double>
```

But Java also has specialized streams for primitive numbers:

```java
IntStream
LongStream
DoubleStream
```

Why?

First, they avoid some unnecessary conversion between:

```text
Integer ↔ int
Double  ↔ double
Long    ↔ long
```

This conversion is called boxing and unboxing.

More importantly for us, primitive streams provide useful numeric operations such as:

```java
sum()
average()
min()
max()
```

---

## Part 11: `IntStream`

Example:

```java
int sum = IntStream.of(2, 4, 6, 8)
        .sum();

System.out.println(sum);
```

Output:

```text
20
```

We can also generate ranges.

```java
IntStream.range(1, 5)
        .forEach(System.out::println);
```

Output:

```text
1
2
3
4
```

The end is excluded.

But:

```java
IntStream.rangeClosed(1, 5)
        .forEach(System.out::println);
```

prints:

```text
1
2
3
4
5
```

### Example

```java
int evenSum = IntStream.rangeClosed(1, 10)
        .filter(n -> n % 2 == 0)
        .sum();

System.out.println(evenSum);
```

Output:

```text
30
```

---

## Part 12: Converting `Stream<Integer>` to `IntStream`

Imagine we already have:

```java
List<Integer> numbers =
        List.of(10, 20, 30, 40);
```

Calling:

```java
numbers.stream()
```

gives us:

```java
Stream<Integer>
```

We can convert it to an `IntStream`.

```java
int total = numbers.stream()
        .mapToInt(Integer::intValue)
        .sum();
```

You can think of it like:

```text
List<Integer>
     ↓
Stream<Integer>
     ↓ mapToInt(...)
IntStream
     ↓
sum()
     ↓
int
```

This is very common when working with numeric properties.

For example:

```java
int totalAge = students.stream()
        .mapToInt(Student::getAge)
        .sum();
```

---

## Part 13: Average

Primitive streams also have `average()`.

```java
double average = IntStream.of(4, 8, 12)
        .average()
        .orElse(0.0);

System.out.println(average);
```

Output:

```text
8.0
```

But why do we need:

```java
.orElse(0.0)
```

?

Because this is possible:

```java
IntStream.empty()
        .average();
```

What is the average of zero numbers?

There is no average.

Therefore `average()` does not directly return a `double`.

It returns:

```java
OptionalDouble
```

---

## Part 14: Converting Back with `boxed()`

Sometimes we start with an `IntStream` but later need objects again.

Use:

```java
boxed()
```

Example:

```java
List<Integer> squares =
        IntStream.rangeClosed(1, 5)
                .map(n -> n * n)
                .boxed()
                .toList();
```

Result:

```text
[1, 4, 9, 16, 25]
```

The pipeline is:

```text
IntStream
   ↓
boxed()
   ↓
Stream<Integer>
   ↓
toList()
   ↓
List<Integer>
```

---

## Part 15: `LongStream` and `DoubleStream`

The same idea exists for other primitive types.

```java
long total =
        LongStream.of(10L, 20L, 30L)
                .sum();
```

And:

```java
double max =
        DoubleStream.of(2.5, 7.1, 3.9)
                .max()
                .orElse(0.0);
```

You do not need to memorize every primitive stream method.

The important idea is:

```text
Stream<Integer> → general object stream

IntStream       → specialized numeric stream
```

---

## Part 16: Why `Optional` Exists

Some operations cannot always produce a value.

For example:

```java
List<String> names = List.of();
```

Now imagine:

```java
names.stream()
        .findFirst();
```

What should Java return?

There is no first element.

It could return `null`, but then every caller would have to remember to check for `null`.

Instead, Java represents the possibility of "there may be no result" explicitly.

```java
Optional<String>
```

An `Optional<T>` means:

```text
There may be a T inside,
or there may be no value.
```

It is important to understand that `Optional` does not magically make code null-safe.

Its main purpose is to represent **a result that may be absent**.

---

## Part 17: Stream Operations That Return Optional

Common examples are:

```java
findFirst()
findAny()
min(...)
max(...)
reduce(...)
```

Example:

```java
Optional<Integer> highest =
        numbers.stream()
                .max(Integer::compareTo);
```

Primitive streams use specialized versions:

```java
OptionalInt
OptionalLong
OptionalDouble
```

For example:

```java
OptionalDouble average =
        IntStream.of(1, 2, 3)
                .average();
```

---

## Part 18: Using `orElse()`

Suppose we want the highest score.

```java
List<Integer> scores =
        List.of();
```

We can write:

```java
int best = scores.stream()
        .max(Integer::compareTo)
        .orElse(0);
```

If a value exists:

```text
Optional[95]
      ↓
95
```

If no value exists:

```text
Optional.empty
      ↓
0
```

This is one of the simplest ways to handle an optional result.

---

## Part 19: `orElseGet()`

`orElseGet()` is similar to `orElse()`.

```java
String name = maybeName.orElseGet(
        () -> createDefaultName()
);
```

The important difference is when the fallback value is calculated.

With:

```java
maybeName.orElse(createDefaultName());
```

`createDefaultName()` is evaluated even if the Optional already contains a value.

With:

```java
maybeName.orElseGet(() -> createDefaultName());
```

the method is called only if the Optional is empty.

So if creating the fallback value is expensive, prefer:

```java
orElseGet(...)
```

---

## Part 20: `ifPresent()`

Sometimes we only want to perform an action if the value exists.

```java
Optional<String> maybeName =
        List.of("Ada", "Bob").stream()
                .filter(name -> name.startsWith("A"))
                .findFirst();

maybeName.ifPresent(System.out::println);
```

If the Optional contains a value, it is printed.

If it is empty, nothing happens.

---

## Part 21: `orElseThrow()`

Sometimes an absent value is an error.

For example:

```java
String name = maybeName.orElseThrow(
        () -> new IllegalStateException("Name not found")
);
```

Now:

```text
value exists
→ return the value

value does not exist
→ throw exception
```

---

## Part 22: Avoid `Optional.get()`

You may see:

```java
String name = maybeName.get();
```

This works only when a value exists.

If the Optional is empty, it throws:

```text
NoSuchElementException
```

So avoid doing this:

```java
optional.get();
```

unless you are completely certain that a value exists.

Usually these methods communicate your intention better:

```java
orElse(...)
orElseGet(...)
orElseThrow(...)
ifPresent(...)
```

---

## Part 23: A Complete Optional Example

```java
List<String> names =
        List.of("Ada", "Bob", "Alice");

Optional<String> maybeName = names.stream()
        .filter(name -> name.startsWith("Z"))
        .findFirst();

String name1 =
        maybeName.orElse("Unknown");

String name2 =
        maybeName.orElseGet(
                () -> "Generated-" + System.currentTimeMillis()
        );

maybeName.ifPresent(System.out::println);

String name3 =
        maybeName.orElseThrow(
                () -> new IllegalStateException("Name not found")
        );
```

We would not normally use all four approaches on the same Optional.

This example only shows the available choices.

---

## Part 24: Grouping Data

Collectors can do more than create lists and sets.

For example, we can group values.

```java
List<String> names =
        List.of(
                "Alice",
                "Adam",
                "Bob",
                "Bella",
                "Charlie"
        );
```

Suppose we want to group them by their first letter.

```java
Map<Character, List<String>> byInitial =
        names.stream()
                .collect(
                        Collectors.groupingBy(
                                name -> name.charAt(0)
                        )
                );
```

The result is similar to:

```text
A → [Alice, Adam]
B → [Bob, Bella]
C → [Charlie]
```

The classifier:

```java
name -> name.charAt(0)
```

decides which group each value belongs to.

---

## Part 25: Grouping and Counting

We can also count the elements in each group.

```java
Map<Character, Long> countByInitial =
        names.stream()
                .collect(
                        Collectors.groupingBy(
                                name -> name.charAt(0),
                                Collectors.counting()
                        )
                );
```

Result:

```text
A → 2
B → 2
C → 1
```

Here two collectors work together:

```text
groupingBy(...)
     +
counting()
```

---

## Part 26: Summary Statistics

Sometimes we want several statistics from the same numeric stream.

For example:

```java
IntSummaryStatistics stats =
        IntStream.of(4, 8, 12, 20)
                .summaryStatistics();
```

Now we can ask for:

```java
stats.getCount();
stats.getSum();
stats.getMin();
stats.getMax();
stats.getAverage();
```

Example:

```java
System.out.println(stats.getCount());   // 4
System.out.println(stats.getSum());     // 44
System.out.println(stats.getMin());     // 4
System.out.println(stats.getMax());     // 20
System.out.println(stats.getAverage()); // 11.0
```

This is useful when we need several numeric statistics at once.

---

## Part 27: Real-World Example

Imagine these are transaction amounts:

```java
List<Integer> amounts =
        List.of(120, 40, 120, 300, 75, 40, 500);
```

We only want transactions of at least `100`.

First, create a clean report:

```java
List<Integer> report = amounts.stream()
        .filter(amount -> amount >= 100)
        .distinct()
        .sorted()
        .toList();
```

Result:

```text
[120, 300, 500]
```

Now calculate the total:

```java
int total = amounts.stream()
        .filter(amount -> amount >= 100)
        .mapToInt(Integer::intValue)
        .sum();
```

Result:

```text
1040
```

Notice that duplicates are included here because these are real transactions.

Now find the highest qualifying amount:

```java
int highest = amounts.stream()
        .filter(amount -> amount >= 100)
        .max(Integer::compareTo)
        .orElse(0);
```

Finally:

```java
System.out.println(report);
System.out.println(total);
System.out.println(highest);
```

This shows an important point:

The same source data can be used to answer different questions.

---

## Part 28: Streams Cannot Be Reused

A stream can only be consumed once.

This works:

```java
Stream<Integer> stream = numbers.stream();

List<Integer> result = stream.toList();
```

But this does not:

```java
Stream<Integer> stream = numbers.stream();

stream.forEach(System.out::println);

long count = stream.count(); // error at runtime
```

The first terminal operation consumes the stream.

If we need another pipeline, create another stream:

```java
numbers.stream()
        .forEach(System.out::println);

long count = numbers.stream()
        .count();
```

---

## Part 29: Common Pitfalls

### 1. Using `forEach()` when you need a result

Not ideal:

```java
List<Integer> result = new ArrayList<>();

numbers.stream()
        .filter(n -> n > 5)
        .forEach(result::add);
```

Prefer:

```java
List<Integer> result = numbers.stream()
        .filter(n -> n > 5)
        .toList();
```

---

### 2. Reusing a stream

Wrong:

```java
Stream<Integer> stream = numbers.stream();

stream.count();
stream.toList();
```

A stream is consumed after its terminal operation.

---

### 3. Assuming `sorted()` modifies the original list

```java
numbers.stream().sorted();
```

does not change `numbers`.

You need a terminal operation and usually store the result:

```java
List<Integer> sorted =
        numbers.stream()
                .sorted()
                .toList();
```

---

### 4. Sorting objects without defining an order

This is easy:

```java
Stream<Integer>
Stream<String>
```

because Java already knows their natural order.

But for:

```java
Stream<Student>
```

Java needs to know how students should be compared.

For example:

```java
students.stream()
        .sorted(Comparator.comparing(Student::getName))
        .toList();
```

---

### 5. Using `reduce()` for everything

This works:

```java
int sum = numbers.stream()
        .reduce(0, Integer::sum);
```

But for numeric values this is often clearer:

```java
int sum = numbers.stream()
        .mapToInt(Integer::intValue)
        .sum();
```

Use the operation that communicates your intention most clearly.

---

### 6. Calling `Optional.get()` without checking

Avoid:

```java
optional.get();
```

Prefer:

```java
optional.orElse(...)
optional.orElseGet(...)
optional.orElseThrow(...)
optional.ifPresent(...)
```

---

## Exercise: Build a Small Report

Given:

```java
List<String> products =
        List.of(
                "Book",
                "Pen",
                "Book",
                "Laptop",
                "Pencil",
                "Pen"
        );

List<Integer> prices =
        List.of(25, 5, 25, 900, 3, 5);
```

### Task 1

Create a list containing unique product names in alphabetical order.

Expected result:

```text
[Book, Laptop, Pen, Pencil]
```

### Task 2

Calculate the total of all prices.

Expected result:

```text
963
```

Try using:

```java
mapToInt(...)
sum()
```

### Task 3

Find the highest price.

Handle the case where the list could be empty.

Expected result:

```text
900
```

Hint:

```java
max(...)
orElse(...)
```

### Task 4

Calculate the average price.

Handle an empty list safely.

Hint:

```java
mapToInt(...)
average()
orElse(...)
```

### Task 5

Print all results.

---

## Optional Challenge

Given:

```java
List<String> names =
        List.of(
                "Alice",
                "Adam",
                "Bob",
                "Bella",
                "Charlie",
                "Chris"
        );
```

Count how many names start with each letter.

Expected result:

```text
A → 2
B → 2
C → 2
```

Hint:

```java
Collectors.groupingBy(...)
Collectors.counting()
```

---

## Key Ideas

A stream pipeline usually looks like:

```text
source
   ↓
intermediate operations
   ↓
terminal operation
   ↓
result
```

For example:

```text
List<Integer>
      ↓
stream()
      ↓
filter()
      ↓
map()
      ↓
sorted()
      ↓
toList()
      ↓
List<Integer>
```

Use:

```java
filter()
```

to decide what stays.

Use:

```java
map()
```

to transform values.

Use:

```java
distinct()
```

to remove duplicates.

Use:

```java
sorted()
```

to order values.

Use:

```java
toList()
collect()
```

to create result collections.

Use:

```java
sum()
average()
reduce()
```

to aggregate values.

Use:

```java
Optional
```

when an operation may not produce a value.

The main idea is not to memorize every stream method.

The important skill is learning to read the pipeline step by step and understand:

```text
What type/value is flowing through the stream right now?
```