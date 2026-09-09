package classes.exercises;

/**
 * Exercise 2: Constructors
 * -------------------------
 * TODO:
 * 1. Create a class `Person` with fields: name, age.
 * 2. Write a default constructor (assign default values).
 * 3. Write a parameterized constructor.
 * 4. Create objects using both constructors and display results.
 */
public class Exercise2
{
    public static void main(String[] args)
    {
        // TODO: Create Person objects using both constructors
        Person person1 = new Person(); // default
        Person person2 = new Person("greg", 10);

        System.out.println("default person :" + person1.name + " " + person1.age);
        System.out.println("person 2 :" + person2.name + " " + person2.age);
    }

    Exercise2() {

    }
}

/**
 * Person
 */
class Person{
    String name;
    int age;

    Person(){
        this.name = "default";
        this.age = 31;
    }

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}

/**
 * This class will be used in Example2Contructors.java
 */
class WeTrySomething {
    public int field;
    public WeTrySomething() {

    }
}
