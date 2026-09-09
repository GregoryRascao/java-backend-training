package encapsulation.examples;

public class Human {
    private int age;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0) {
            System.out.println("Age cannot be smaller than zero");
            //it is better to stop than continue with an error. We'll see a better way to prevent such errors later.
        }
        else {
            this.age = age;
        }
    }
}
