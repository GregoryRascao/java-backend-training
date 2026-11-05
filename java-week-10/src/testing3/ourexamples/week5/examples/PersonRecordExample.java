package testing3.ourexamples.week5.examples;

public record PersonRecordExample(int age, String name)
{
    public PersonRecordExample
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Username cannot be blank");
        }
        if (age < 0)
        {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

    public String getSurname()
    {
        String[] parts = this.name.split(" ");
        return parts[parts.length - 1];
    }
}