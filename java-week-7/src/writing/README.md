# Writing Files in Java (Optional)

This optional module builds on the file-writing material from week 6 and focuses on flushing buffered output, writing transformed collections, and testing generated files.

### What does flush() do?

Buffered writers store data temporarily in memory (the buffer).
Calling `flush()` forces the buffered data to be written to disk immediately.

Normally you do not need to call `flush()` manually because
`close()` (or try-with-resources) will flush automatically.

## Stream-friendly writing pattern

When data is already in a collection, you can transform it with streams and write once:

```java
List<String> lines = names.stream()
        .map(String::trim)
        .filter(s -> !s.isEmpty())
        .map(String::toUpperCase)
        .toList();

Files.write(Path.of("output.txt"), lines);
```

This keeps transformation and output logic clear and testable.

## Testing Note

Programs that generate files should be tested.

For example, a test could verify that:

- the correct number of lines were written
- the file contains expected values
- logs follow the correct format

The next module introduces automated testing for such cases.

