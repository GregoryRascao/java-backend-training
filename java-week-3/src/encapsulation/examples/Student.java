package encapsulation.examples;
/**
 * A class representing a student with encapsulated name and age.
 */

public class Student
{
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) throws InvalidAgeException {
        this.name = name;
        setAge(age); // validation inside setter
    }

    // Getter
    public String getName() {return name;}
    public int getAge() {return age;}

    // Setter with validation
    public void setAge(int age) throws InvalidAgeException {
        if (age >= 0 && age < 120)
        {
            this.age = age;
        }
        else {
            throw new InvalidAgeException();
        }
    }

    public void setName(String name) {
        if(name == null)
            throw new InvalidNameException();
        else if (name.isBlank()) {
            throw new InvalidNameException();
        }
        this.name = name;
    }
}
