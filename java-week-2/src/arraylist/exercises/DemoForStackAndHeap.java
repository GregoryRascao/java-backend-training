package arraylist.exercises;

public class DemoForStackAndHeap {

    public static void main(String[] args) {
        int number = 10;        //this is in stack
        int digit = 2;
        swap(number, digit);
        System.out.println("Number:" + number + " digit: " + digit);

        Employee malek = new Employee("Malek", "Human Resources", 19);
        Employee.promote(malek);

        System.out.println("Department: " + malek.getDepartment() + " age: " + malek.getAge());
    }

    public static void swap(int a, int b) {
        System.out.println("Before");
        System.out.print("a: " + a);
        System.out.println(" b: " + b);
        int temp;
        temp = a;
        a = b;
        b = temp;
        //something like that

        System.out.println("After");
        System.out.print("a: " + a);
        System.out.println(" b: " + b);


    }

}

class Employee {
    private String name;
    private String department;
    private int age;

    public Employee(String name, String dep, int age) {
        this.name = name;
        this.department = dep;
        this.age = age;
    }

    public void setAge(int age) {
        if(age < 18) {
            System.out.println("Not allowed");
        }
        else {
            this.age = age;
        }
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDepartment(String department1) {
        this.department = department1;
    }

    public String getDepartment() {
        return this.department;
    }

    public void ascend() {      //instance method
        this.age++;
        this.department = this.department + " Manager";
    }

    public static void promote(Employee anEmployee) {       //static method
        anEmployee.age++;
        anEmployee.department = anEmployee.department + " Manager";
    }

}