# Testing in Java (Without External Libraries)


## Java Built-in Testing Features

### 1. Assertions (`assert`)

Assertions are simple checks that throw `AssertionError` if a condition is false.

**Syntax:**
```java
assert condition;
assert condition : "Error message";
```

**Example:**
```java
public class Calculator {
    public int add(int a, int b) {
        int result = a + b;
        assert result >= a && result >= b : "Addition overflow";
        return result;
    }
}
```

**Important:** Assertions must be enabled at runtime:

```bash
java -ea YourClass    # -ea means "enable assertions"
```
We need -ea flag to enable assertions

```bash
javac testing/examples/Example5.java
java -ea testing.examples.Example5
```

## Common Testing Terms

- **Test Case** - A single scenario being tested
- **Test Suite** - A collection of test cases
- **Assert** - Verify that something is true
- **Expected Result** - What you think should happen
- **Actual Result** - What actually happens
- **Pass/Fail** - Test succeeds or throws an error

---

## Limitations of Built-in Testing

While assertions are useful, they have limitations:
- No test discovery (must run each test manually)
- No test reporting
- No test organization features
- No setup/teardown hooks


## Practice Tips

1. **Write tests as you code** - Don't wait until the end
2. **Test small units** - Test individual methods, not entire programs
3. **Make tests independent** - Each test should work on its own
4. **Keep tests simple** - Tests should be easy to understand
5. **Run tests often** - Catch problems early

# Author
https://github.com/sammou00
