package projects.project4;

public class Person {
    private double age;

    public int getAge() {
        return (int)age;

    }

    public void setAge(int age) {
        if(age < 0) {
            System.out.println("Age cannot be smaller than zero");
            age = 0;
        }
        else {
            this.age = age;
        }
    }
}
