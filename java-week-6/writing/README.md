# Writing Files in Java

This folder continues from `inputoutput1`.

Already covered in `inputoutput1`:
- creating and writing files with `FileWriter`
- basic copy operations
- try-with-resources and exception handling

In this `writing` module, the focus is writing workflows and patterns, not repeating the first write example.

## Focus of this module

1. Efficient writing with `BufferedWriter`
2. Appending data (`new FileWriter(path, true)`)
3. Structured multi-line output
4. Controlled write behavior with `flush()` when needed

## Typical pattern used in this folder

```java
try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true))) {
    writer.write("new entry");
    writer.newLine();
    writer.flush();
} catch (IOException e) {
    System.out.println("Error writing file: " + e.getMessage());
}
```

## Learning outcomes

By the end of this folder, students should be able to:
- write line-oriented text output
- append logs or incremental records safely
- generate files from in-memory data structures
- choose when buffered writing is preferable
