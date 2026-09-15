package encapsulation.exercises;

/**
 TODO:
 1. Create private fields: name (String), salary (double).
 2. Write a constructor to initialize both.
 3. Add getters for both fields.
 4. Add a setter for salary that does NOT allow negative values.
 5. Create a method giveRaise(double amount) that increases salary.
 */
public class Employee
{
    private String name;
    private double salary;


    Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary){
        if(salary < 0) throw new IllegalArgumentException("Salary cannot be negative.");
    }

    public void giveRaise( double amount){
        if (amount < 0) {
            throw new IllegalArgumentException("Raise cannot be negative.");
        }
        this.salary += amount;
    }
}
