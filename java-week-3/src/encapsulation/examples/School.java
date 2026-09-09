package encapsulation.examples;

public class School {
    public static void main(String[] args) {
        int age = 20;
        try {

            Student cath = new Student("Catherine", age);
        }
        catch (InvalidAgeException ageEx) {
            System.out.println("I couln't create this student bc of age: " + age);
        }
    }
}
