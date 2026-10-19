# JUnit 5: Further Techniques

Week 7 covered testability, basic assertions, boundary and error cases, Arrange-Act-Assert, and `@BeforeEach`. This section moves on to additional JUnit techniques.

## Parameterized tests

Use a parameterized test when one behavior needs to be checked with several input/expected-value pairs. JUnit runs the test once for each row.

```java
@ParameterizedTest
@CsvSource({
        "BrUssels,2",
        "Antwerp,2",
        "Ghent,1"
})
void countsVowels(String text, int expected)
{
    assertEquals(expected, countVowels(text));
}
```

`@CsvSource` converts each value to the type of the corresponding method parameter. See [Example 8](examples/Example8.java) for a complete example.

## Group related checks with `assertAll`

`assertAll(...)` runs every supplied assertion and reports all failures together, instead of stopping at the first failure. It will run **all** the assertions whether they fail or succeed.

```java
assertAll(
        () -> assertEquals("Gayatri", student.getName()),
        () -> assertEquals(91, student.getScore())
);
```

See [Example 9](examples/Example9.java) for a complete example that also checks an exception message.


## Test coverage

Coverage reports which lines or branches a test run executed. Use a report to find behavior that has not been checked; do not treat a high percentage as proof that tests are useful. A test must make meaningful assertions to verify behavior.

IntelliJ IDEA and JaCoCo can report coverage. There is no single coverage percentage that is right for every project.

## Test-driven development practice

TDD's Red → Green → Refactor cycle was introduced in Week 7. [Exercise 11](exercises/Exercise11.java) is an additional opportunity to apply that process to a behavior-first implementation.

## Included exercises

- [Exercise 8](exercises/Exercise8.java): parameterized tests with `@CsvSource`
- [Exercise 9](exercises/Exercise9.java): grouped assertions and exception messages
- [Exercise 11](exercises/Exercise11.java): behavior-first development
