package classes.examples;

//import classes.exercises.Exercise2;       //cannot import because the constructor is not public
//import classes.exercises.WeTrySomething;  //cannot import bc the class is not public


/**
 * Example 2: Constructors
 * - Default and Parameterized Constructors
 */

public class Example2Constructors
{
    public static void main(String[] args)
    {
        Student who = new Student();
        Student preeti = new Student("Preeti", 20);

        who.display();
        preeti.display();


//        WeTrySomething wts = new WeTrySomething();
//        neither of them works because they are not public
//        Exercise2 = new Exercise2();
    }
}

class Student
{
    String name;
    int age;

    // Default constructor
    Student() {
        name = "Unknown";
        age = 0;
    }

    // Parameterized constructor
    Student(String name, int a)
    {
        this.name = name;
        age = a;
    }

    void display()
    {
        System.out.println(name + " is " + age + " years old");
    }

}
