# flatMap in Java Streams

> Optional reading  
> You do not need to fully master this yet.

## Goal

Understand the difference between:
- `map`
- `flatMap`

And learn when to use `flatMap`.

---

## map vs flatMap

### map -> one-to-one

```java
List<String> words = List.of("hi", "ok");

List<Integer> lengths =
    words.stream()
         .map(String::length)
         .toList();
```

Result:

```java
[2, 2]
```

Each input produces one output.

### Problem with map

```java
List<String> words = List.of("hi", "ok");

List<String[]> result =
    words.stream()
         .map(word -> word.split(""))
         .toList();
```

Result:

```java
[["h", "i"], ["o", "k"]]
```

This is a nested structure.

### flatMap -> one-to-many + flatten

```java
List<String> words = List.of("hi", "ok");

List<String> chars =
    words.stream()
         .flatMap(word -> Arrays.stream(word.split("")))
         .toList();
```

Result:

```java
["h", "i", "o", "k"]
```

## Mental model

### map

```java
["hi", "ok"]
-> [["h", "i"], ["o", "k"]]
```

### flatMap

```java
["hi", "ok"]
-> ["h", "i", "o", "k"]
```

`flatMap = map + flatten`

---

## Real-world example: log processing

```java
List<String> lines = List.of(
    "INFO User logged in",
    "ERROR Disk full"
);

List<String> words =
    lines.stream()
         .flatMap(line -> Arrays.stream(line.split("\\s+")))
         .toList();
```

Result:

```java
["INFO", "User", "logged", "in", "ERROR", "Disk", "full"]
```

---

## Common mistake

```java
map(line -> line.split("\\s+"))
```

This gives `Stream<String[]>`.

Instead:

```java
flatMap(line -> Arrays.stream(line.split("\\s+")))
```

This gives `Stream<String>`.

---

## When to use flatMap

Use flatMap when:

- one input produces multiple outputs
- you want a single flattened stream
- you want to avoid nested collections

## Key takeaway

`flatMap = transform + flatten`

---

## Exercises

### Exercise 1: Split words

```java
List<String> sentences = List.of(
    "Java is fun",
    "Streams are powerful"
);
```

Task:
- Return a list of all words.

Expected:

```java
["Java", "is", "fun", "Streams", "are", "powerful"]
```

Answer
```java
List<String> result =
sentences.stream()
.flatMap(s -> Arrays.stream(s.split("\\s+")))
.toList();
```

### Exercise 2: Count all words

Task:
- Count how many total words exist.

Hint:

- use `flatMap`
- then `count()`

Expected:

```java
6
```

Answer:
```java
long count = sentences.stream()
.flatMap(sentence -> Arrays.stream(sentence.split(" ")))
.count();

System.out.println(count);
```

### Exercise 3: Unique words

Task:
- Return a list of unique words.

Hint:

- `flatMap`
- `distinct()`

Expected (order may vary):

```java
["Java", "is", "fun", "Streams", "are", "powerful"]
```

Answer:
```java
List<String> uniqueWords = sentences.stream()
    .flatMap(s -> Arrays.stream(s.split("\\s+")))
    .distinct()
    .toList();
```
### Exercise 4: Filter words

Task:
- Return only words longer than 4 characters.

Expected:

```java
["Streams", "powerful"]
```

Answer
```java
List<String> result = sentences.stream()
.flatMap(s -> Arrays.stream(s.split("\\s+")))
.filter(word -> word.length() > 4)
.distinct()
.toList();
```
### Trap question

```java
List<String[]> result =
    sentences.stream()
             .map(s -> s.split(" "))
             .toList();
```

Question:
- Why is this not a `List<String>`?

Expected answer:
- because `map` returns `Stream<String[]>`
- we need `flatMap`