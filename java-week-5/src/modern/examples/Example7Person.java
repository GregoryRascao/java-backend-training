package modern.examples;

/**
 * This is an example to show immutability aspect of records.
 */
public record Example7Person(int age, String name) {
    public Example7Person {
        // First it sets the fields
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Username cannot be blank");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

    // Getters are allowed because they don't break imutability
    public String getSurname() {
        String[] s = this.name.split(" ");
        return s[s.length-1];
    }
    //setter is not allowed because it is immutable
}
