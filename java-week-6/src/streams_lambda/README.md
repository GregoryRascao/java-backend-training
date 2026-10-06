# From Generics to Streams

## Lesson Goal

In this lesson, we connect **Generics** with **Streams**.

By the end of the lesson, we should:

- Understand how generics are used in real APIs
- Recognize generic functional interfaces
- Understand how streams use generics
- Write simple stream pipelines

---

## Part 1: Generics in Real Java APIs

Generics are everywhere in the Java standard library.

### Example

```java
List<String> names = List.of("Alice", "Bob", "Charlie");
```

The `List` interface is generic:

```java
interface List<E>
```

This means a list can store any type safely.

### More Examples

```java
List<Integer> numbers;
List<Double> prices;
List<User> users;
```

## Bridge from Last Week: Why Lambda Expressions?

In **Flexible API Design** last week, we said:

> Later in the course, we will learn **Lambda Expressions**, which provide a shorter syntax for many cases where anonymous classes were used.

This is that moment.

### Step 1: Anonymous Class Style (Older)

```java
Predicate<Integer> isEven = new Predicate<Integer>() {
    @Override
    public boolean test(Integer n) {
        return n % 2 == 0;
    }
};
```

### Step 2: Lambda Style (Shorter)

```java
Predicate<Integer> isEven = n -> n % 2 == 0;
```

The behavior is the same. Lambda syntax is shorter and easier to read.

### Step 3: Same Idea Inside a Stream

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

numbers.stream()
       .filter(n -> n % 2 == 0)
       .forEach(System.out::println);
```
 
### Method reference is a shorter version of a lambda expression
 Lambda: students.forEach(s -> System.out.println(s))
 Method reference: students.forEach(System.out::println)

So streams are not a separate world. They are APIs that use the same functional ideas (Predicate, Function, Consumer) with lambda syntax.

## Part 2: Generic Interfaces

Generics are also used in interfaces.

### Example

```java
interface Processor<T> {
    T process(T input);
}
```

### Usage

```java
Processor<String> upper = s -> s.toUpperCase();
Processor<Integer> square = n -> n * n;
```

The same interface works with different types.

## Part 3: Functional Interfaces

Many Java APIs use generic functional interfaces.

### Common Interfaces

| Interface | Purpose |
| --- | --- |
| `Predicate<T>` | test a condition |
| `Function<T, R>` | transform a value |
| `Consumer<T>` | process a value |
| `Comparator<T>` | compare values |

### Example

```java
Predicate<Integer> isEven = n -> n % 2 == 0;
```

Explanation:

- `T = Integer`
- Input: `Integer`
- Output: `boolean`

## Part 4: Why This Matters for Streams

These generic interfaces are heavily used by streams.

### Example Pipeline

```java
numbers.stream()
       .filter(n -> n > 5)         //-> Stream<Integer>
       .map(n -> n * 2)            //Stream<Integer>
       .forEach(System.out::println);
```

Behind the scenes:

- `filter` -> `Predicate<T>`
- `map` -> `Function<T, R>`
- `forEach` -> `Consumer<T>`

Streams are generic pipelines.

Note: Each step see what is the current object on the stream to understand better.

## Part 5: First Stream Example

### Given

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
```

### Traditional Loop

```java
for (Integer n : numbers) {
    if (n % 2 == 0) {
        System.out.println(n);
    }
}
```

### Stream Version

```java
numbers.stream()
       .filter(n -> n % 2 == 0)
       .forEach(System.out::println);
```

## Part 6: Core Stream Operations

### `stream()`

Creates a stream from a collection.

```java
list.stream();
```

### `filter()`

Keeps elements that match a condition.

```java
.filter(predicate)
.filter(n -> n > 10)
```

### `map()`

Transforms elements.

```java
.map(n -> n * 2)
```

### `forEach()`

Processes each element.

```java
.forEach(System.out::println)
```

### Full Example

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);

numbers.stream()
       .filter(n -> n > 2)
       .map(n -> n * 10)
       .forEach(System.out::println);
```

Output:

```text
30
40
50
```

## Exercise: Connecting Generics and Streams

### Given

```java
List<String> names = List.of("Alice", "Bob", "Charlie", "Anna");
```

### Tasks

1. Keep names starting with `"A"`
2. Convert them to uppercase
3. Print them

Hint:

- `filter` -> `Predicate<String>`
- `map` -> `Function<String, String>`

## Key Insight

Streams are built on top of generics.

The pipeline works because Java knows the types at each step.

Examples:

```java
Stream<String>
Stream<Integer>
Stream<User>
```

Generics make stream operations type-safe.

## Next Lesson

Next, we will explore:

- `collect()`
- `sorted()`
- `distinct()`
- `reduce()`
- Real-world stream pipelines