# String vs StringBuilder vs StringBuffer

## 1. Differences between String, StringBuilder, and StringBuffer

| Feature            | String                                                         | StringBuilder                                                                 | StringBuffer                                                                  |
|--------------------|----------------------------------------------------------------|-------------------------------------------------------------------------------|-------------------------------------------------------------------------------|
| **Mutability**     | Immutable – value cannot change after creation                 | Mutable – can change content without creating new object                      | Mutable – can change content without creating new object                      |
| **Performance**    | Slower for concatenation or modifications                      | Faster for frequent modifications                                             | Slightly slower than StringBuilder due to synchronization                     |
| **Memory Usage**   | More memory if many modifications (new object for each change) | More memory-efficient (modifies existing object)                              | More memory-efficient (modifies existing object)                              |
| **Thread Safety**  | Thread-safe (immutable)                                        | Not thread-safe                                                               | Thread-safe (synchronized)                                                    |
| **Common Methods** | `concat()`, `substring()`, `charAt()`, `length()`, etc.        | `append()`, `insert()`, `delete()`, `reverse()`, `charAt()`, `length()`, etc. | `append()`, `insert()`, `delete()`, `reverse()`, `charAt()`, `length()`, etc. |
| **Use Case**       | Best for fixed or rarely changing text                         | Best for frequently changing strings in a single thread                       | Best for frequently changing strings in a multi-threaded environment          |

**Example:**

```java
// String
String str = "Hello";
str += " World"; // Creates new String object

// StringBuilder (single-threaded)
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World"); // Modifies existing object

// StringBuffer (multi-threaded safe)
StringBuffer sbf = new StringBuffer("Hello");
sbf.append(" World"); // Thread-safe modification
````

---

## 2. List of String Methods in Java

Some commonly used methods of the `String` class:

* `char charAt(int index)`
* `int compareTo(String anotherString)`
* `int compareToIgnoreCase(String str)`
* `String concat(String str)`
* `boolean contains(CharSequence s)`
* `boolean endsWith(String suffix)`
* `boolean startsWith(String prefix)`
* `boolean equals(Object anObject)`
* `boolean equalsIgnoreCase(String anotherString)`
* `byte[] getBytes()`
* `int indexOf(String str)`
* `int indexOf(String str, int fromIndex)`
* `int lastIndexOf(String str)`
* `int lastIndexOf(String str, int fromIndex)`
* `int length()`
* `boolean isEmpty()`
* `String replace(char oldChar, char newChar)`
* `String replace(CharSequence target, CharSequence replacement)`
* `String[] split(String regex)`
* `String[] split(String regex, int limit)`
* `boolean matches(String regex)`
* `String substring(int beginIndex)`
* `String substring(int beginIndex, int endIndex)`
* `char[] toCharArray()`
* `String toLowerCase()`
* `String toUpperCase()`
* `String trim()`
* `String strip()`
* `String stripLeading()`
* `String stripTrailing()`

---

## 3. List of StringBuilder Methods in Java

* `StringBuilder()`
* `StringBuilder(int capacity)`
* `StringBuilder(String str)`
* `StringBuilder append(String str)`
* `StringBuilder append(char c)`
* `StringBuilder insert(int offset, String str)`
* `StringBuilder delete(int start, int end)`
* `StringBuilder deleteCharAt(int index)`
* `StringBuilder replace(int start, int end, String str)`
* `StringBuilder reverse()`
* `String substring(int start)`
* `String substring(int start, int end)`
* `char charAt(int index)`
* `void setCharAt(int index, char ch)`
* `int length()`
* `int capacity()`
* `void ensureCapacity(int minimumCapacity)`
* `void trimToSize()`
* `void setLength(int newLength)`
* `String toString()`

---

## 4. List of StringBuffer Methods in Java

* `StringBuffer()`
* `StringBuffer(int capacity)`
* `StringBuffer(String str)`
* `StringBuffer append(String str)`
* `StringBuffer append(char c)`
* `StringBuffer insert(int offset, String str)`
* `StringBuffer delete(int start, int end)`
* `StringBuffer deleteCharAt(int index)`
* `StringBuffer replace(int start, int end, String str)`
* `StringBuffer reverse()`
* `String substring(int start)`
* `String substring(int start, int end)`
* `char charAt(int index)`
* `void setCharAt(int index, char ch)`
* `int length()`
* `int capacity()`
* `void ensureCapacity(int minimumCapacity)`
* `void trimToSize()`
* `void setLength(int newLength)`
* `String toString()`

---

**Tips:**

* Use **`String`** for immutable text or rarely changing content.
* Use **`StringBuilder`** for frequent modifications in a single-threaded context.
* Use **`StringBuffer`** for frequent modifications in a multithreaded environment to ensure thread safety.

---
