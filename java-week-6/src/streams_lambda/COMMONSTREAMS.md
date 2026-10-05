# Common Functional Interfaces Used with Streams

Java Streams rely heavily on **functional interfaces**.
A functional interface is an interface with **exactly one abstract method**.

These interfaces let us pass **behavior as data**, usually with **lambda expressions**.

---

## 1. `Predicate<T>`

Represents a **condition**.

Method:

```java
boolean test(T value)
```

It returns `true` or `false`.
Often used with `filter()`.

### Example

```java
Predicate<Integer> isEven = n -> n % 2 == 0;

List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

numbers.stream()
       .filter(isEven)
       .forEach(System.out::println);
```

Use when you need to test something.

## 2. `Function<T, R>`

Represents a transformation.

Method:

```java
R apply(T value)
```

Input type -> output type.
Commonly used with `map()`.

### Example

```java
Function<Integer, Integer> square = n -> n * n;

List<Integer> numbers = List.of(1, 2, 3);

numbers.stream()
       .map(square)
       .forEach(System.out::println);
```

Use when you want to transform values.

## 3. `Consumer<T>`

Represents an operation that uses a value and returns nothing.

Method:

```java
void accept(T value)
```

Commonly used with `forEach()`.

### Example

```java
Consumer<String> printer = word -> System.out.println(word);

List<String> words = List.of("Java", "Streams", "Lambda");

words.stream()
     .forEach(printer);
```

Use when you want to process or print values.

## 4. `Supplier<T>`

Represents a value provider.

Method:

```java
T get()
```

It takes no input and returns a value.

### Example

```java
Supplier<Double> randomNumber = () -> Math.random();

System.out.println(randomNumber.get());
```

Use when you need to generate values.

## 5. `BiFunction<T, U, R>`

Takes two inputs and produces one output.

Method:

```java
R apply(T t, U u)
```

### Example

```java
BiFunction<Integer, Integer, Integer> max = (a, b) -> a >= b ? a : b;

System.out.println(max.apply(10, 7));
```

Use when you need a function with two parameters.

## 6. `Comparator<T>`

Used to compare two values for ordering.

Method:

```java
int compare(T a, T b)
```

Often used with `sorted()`.

### Example

```java
List<Integer> numbers = List.of(5, 1, 7, 3);

numbers.stream()
       .sorted((a, b) -> Integer.compare(b, a))
       .forEach(System.out::println);
```

Use when you want to sort values.

## 7. `UnaryOperator<T>`

A specialization of `Function<T, T>`.

Input and output are the same type.

### Example

```java
UnaryOperator<Integer> doubleValue = n -> n * 2;

System.out.println(doubleValue.apply(5));
```

## 8. `BinaryOperator<T>`

A specialization of `BiFunction<T, T, T>`.

Both inputs and the result are the same type.
Often used with `reduce()`.

### Example

```java
BinaryOperator<Integer> sum = (a, b) -> a + b;

List<Integer> numbers = List.of(1, 2, 3, 4);

int result = numbers.stream()
                    .reduce(0, sum);

System.out.println(result);
```

## How Streams Use These Interfaces

Streams rely on these interfaces internally.

| Stream Operation | Functional Interface |
| --- | --- |
| `filter()` | `Predicate<T>` |
| `map()` | `Function<T, R>` |
| `forEach()` | `Consumer<T>` |
| `sorted()` | `Comparator<T>` |
| `reduce()` | `BinaryOperator<T>` |

### Example Pipeline

```java
numbers.stream()
       .filter(n -> n > 10)           // Predicate
       .map(n -> n * 2)               // Function
       .forEach(System.out::println); // Consumer
```

## Key Idea

Streams work because Java combines:

- Generics
- Functional interfaces
- Lambda expressions

Together, they enable clean and expressive data processing.