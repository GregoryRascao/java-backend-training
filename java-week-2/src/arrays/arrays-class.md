# 📘 Java `Arrays` Class

```java
import java.util.Arrays;
```

The `Arrays` class contains **static methods**; you don’t need to create an object to use them.

---

## 1. Sorting Methods

### `sort()`

* Sorts an array in **ascending order**.
* Works for primitive types and objects.

```java
public class Main 
{
    public static void main(String[] args) 
    {
        int[] arr = {5, 2, 8, 1};
        Arrays.sort(arr);  // [1, 2, 5, 8]
    }
}
```

### `sort(T[] a, int fromIndex, int toIndex)`

* Sort a **range** of an array.

```java
public class Main 
{
    public static void main(String[] args) 
    {
        int[] arr = {5, 2, 8, 1};
        Arrays.sort(arr, 1, 3);  // Only sorts elements at index 1 and 2
    }
}
```

---

## 2. Searching Methods

### `binarySearch()`

* Performs **binary search** (array must be sorted).

```java
public class Main
{
    static void main() 
    {
        int[] arr = {1, 2, 3, 4, 5};
        int index = Arrays.binarySearch(arr, 3); // Returns 2
    }
}
```

### Overloaded:

```md
Arrays.binarySearch(arr, fromIndex, toIndex, key);
```

---

## 3. Comparison Methods

### `equals()`

* Checks if **two arrays are equal** (same length, same elements).

```java
int[] arr1 = {1, 2, 3};
int[] arr2 = {1, 2, 3};
boolean eq = Arrays.equals(arr1, arr2); // true
```

### `deepEquals()`

* For **multi-dimensional arrays**, compares elements recursively.

```java
int[][] a = {{1,2},{3,4}};
int[][] b = {{1,2},{3,4}};
boolean eq = Arrays.deepEquals(a, b); // true
```

---

## 4. Filling Arrays

### `fill()`

* Fill **entire array** with a value.

```java
int[] arr = new int[5];
Arrays.fill(arr, 7); // {7,7,7,7,7}
```

### `fill(array, fromIndex, toIndex, value)`

* Fill **specific range**.

```java
int[] arr = {1,2,3,4,5};
Arrays.fill(arr, 1, 4, 9); // {1,9,9,9,5}
```

---

## 5. Copying Arrays

### `copyOf()`

* Copy entire array or part of it.

```java
int[] arr = {1,2,3};
int[] copy = Arrays.copyOf(arr, 5); // {1,2,3,0,0}
```

### `copyOfRange()`

* Copy **specific range**.

```java
int[] arr = {1,2,3,4,5};
int[] range = Arrays.copyOfRange(arr, 1, 4); // {2,3,4}
```

---

## 6. Array to String

### `toString()`

* Convert **single-dimensional array** to string.

```java
int[] arr = {1,2,3};
System.out.println(Arrays.toString(arr)); // [1, 2, 3]
```

### `deepToString()`

* Convert **multi-dimensional array** to string.

```java
int[][] arr = {{1,2},{3,4}};
System.out.println(Arrays.deepToString(arr)); // [[1, 2], [3, 4]]
```

---

## 7. Hash Code Methods

### What is a Hash?

A **hash** is a fixed-size numeric fingerprint generated from any input data by a **hash function**.
No matter how large or small the input is, the output (the hash) is always the same length.

Key properties:
- **Deterministic** — the same input always produces the same hash.
- **One-way** — it is computationally infeasible to reverse a hash back to the original input. We cannot recover the original data from the hash alone.
- **Avalanche effect** — a tiny change in input produces a completely different hash.
- **Collision-resistant** — two different inputs should not produce the same hash (though mathematically it can happen, well-designed algorithms make it extremely rare).

### Two Famous Hash Algorithms

| Algorithm | Output Size | Common Use |
|-----------|------------|------------|
| **SHA-256** (Secure Hash Algorithm) | 256 bits / 64 hex chars | File integrity, TLS, Bitcoin |
| **MD5** (Message Digest 5) | 128 bits / 32 hex chars | Legacy checksums *(no longer considered secure for cryptographic use)* |

### Verifying File Integrity with PowerShell

When we download a file from the internet, the publisher often provides its expected hash.
We can verify the downloaded file has not been tampered with (or corrupted) by comparing
the published hash against the hash we compute ourselves:

```powershell
Get-FileHash .\downloaded-file.zip -Algorithm SHA256
```

Output example:
```
Algorithm  Hash                                                              Path
---------  ----                                                              ----
SHA256     3B4C...F9A1                                                       .\downloaded-file.zip
```

If the hash we get matches the hash published on the download page, the file is intact and trustworthy.
If they differ even by a single character, the file must not be used — it may have been corrupted or replaced by a malicious version.

> **Note for later:** When we work on security features, we will never store a user's plain-text password in the database.
> Instead, we will hash the password (using a slow, salted algorithm like **BCrypt**) and store only the hash.
> When the user logs in, we hash the entered password and compare the two hashes — because of the one-way nature of hashing,
> there is no way to "decrypt" a stored hash back to the original password, which keeps users safe even if the database is leaked.

---

### `hashCode()` in Java

The `Arrays.hashCode()` method computes an integer hash code for an array based on its contents.
This is used internally by collections (e.g., `HashMap`, `HashSet`) to quickly locate objects.
Note that Java's `hashCode()` is **not** a cryptographic hash — it is optimised for speed and bucket distribution, not security.

### `hashCode()`

* Returns **hash code** for single-dimensional array.

```java
int[] arr = {1,2,3};
int hash = Arrays.hashCode(arr);
```

### `deepHashCode()`

* For **multi-dimensional arrays**.

```java
int[][] arr = {{1,2},{3,4}};
int hash = Arrays.deepHashCode(arr);
```

---

## 8. Mismatch Method

### `mismatch()`

* Returns **first index where two arrays differ**, or -1 if equal.

```java
int[] a = {1,2,3};
int[] b = {1,4,3};
int index = Arrays.mismatch(a, b); // 1
```

---

## 9. Parallel Methods (Java 8+)

* `parallelSort()` → faster sorting for large arrays using multiple threads.
* `parallelPrefix()` → apply a **cumulative operation** on array.
* `parallelSetAll()` → initialize array elements in parallel.

Example:

```java
int[] arr = {5,2,8,1};
Arrays.parallelSort(arr);  // sorts array in parallel
```

---

## 10. Utility Methods

* `asList(T... a)` → Convert **array to List**.

```java
String[] arr = {"A", "B", "C"};
List<String> list = Arrays.asList(arr);
```

* `spliterator()` → Return a **Spliterator** for the array (for streams).

---

## ✅ Summary of Most Used `Arrays` Methods

| Method           | Purpose                                  |
|------------------|------------------------------------------|
| `sort()`         | Sort array                               |
| `binarySearch()` | Search in sorted array                   |
| `equals()`       | Compare arrays                           |
| `deepEquals()`   | Compare multidimensional arrays          |
| `fill()`         | Fill array with value                    |
| `copyOf()`       | Copy array                               |
| `copyOfRange()`  | Copy array range                         |
| `toString()`     | Convert array to string                  |
| `deepToString()` | Convert multidimensional array to string |
| `hashCode()`     | Hash code of array                       |
| `deepHashCode()` | Hash code of multidimensional array      |
| `mismatch()`     | Find first differing index               |
| `parallelSort()` | Parallel sort (Java 8+)                  |
| `asList()`       | Convert array to List                    |

