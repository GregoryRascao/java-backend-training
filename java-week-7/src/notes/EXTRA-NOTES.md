# Extra Notes

This file contains extra notes for questions that often come up in class.

---

## BufferedWriter: what happens when the buffer is full?

`BufferedWriter` writes characters into a small internal memory buffer first.

When the buffer becomes full:
- Java writes buffered data to the underlying writer
- then continues writing new data

This happens automatically.

### Important distinction

- `flush()` forces all currently buffered data to be written immediately
- a full buffer causes Java to write enough data so writing can continue

Both actions move data forward, but they happen for different reasons.

---

## BufferedReader: how it works

`BufferedReader` does not have `flush()`.

Reading works differently:
- when the internal buffer becomes empty, Java reads more data from the source

So the idea is:
- a writer pushes data outward
- a reader pulls data inward

---

## Does buffering change space complexity?

Usually, buffering does not change the asymptotic space complexity.

Example:

```java
while ((line = reader.readLine()) != null)
{
    process(line);
}
```

This is usually still `O(1)` extra space because:
- only one line is processed at a time
- the buffer size is fixed

### When does space become `O(n)`?

Space grows with input size when the whole file is stored in memory.

```java
List<String> lines = Files.readAllLines(Path.of("data.txt"));
```

Now memory usage grows with the size of the file, so the extra space is `O(n)`.

### Practical summary

- buffering usually improves performance
- buffering usually does not change Big-O space complexity
- storing the full file in a collection is what usually increases space complexity

---

## Floating-point precision

`double` and `float` cannot store most decimal numbers exactly in binary.

Example:

```java
System.out.println(0.1 + 0.2);
```

Possible output:

```java
0.30000000000000004
```

This is normal floating-point behavior.

### Testing tip

Do not compare calculated floating-point results with exact equality.

Use a delta instead:

```java
assertEquals(0.3, result, 0.000001);
```

This means the test passes if the result is close enough.

---

## Function.identity() in Streams

`Function.identity()` is a built-in function that returns its input as it is.

```java
x -> x
```

So:

```java
Function.identity()
```

means exactly the same thing.
Example 1: grouping elements
```java
Map<String, Long> counts =
    list.stream()
        .collect(Collectors.groupingBy(
            Function.identity(),
            Collectors.counting()
        ));
```

This groups elements by themselves.

Equivalent to:

```java
groupingBy(x -> x)
```

### Example 2: creating a map

```java
Map<String, Integer> map =
    list.stream()
        .collect(Collectors.toMap(
            Function.identity(),
            String::length
        ));
```

This creates a map where:

- key -> the element itself
- value -> its length

### When to use it

Use `Function.identity()` when:

- you want to keep the original value
- and avoid writing `x -> x`

### Note

It is just a shorter version of `x -> x`.

If it feels confusing, you can always write the lambda instead.

---

## Final reminder

Good code is not the most clever code.

It is the code that:
- is easy to read
- solves the problem correctly
- can be maintained later