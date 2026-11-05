package testing3.ourexamples.week3.examples;

/**
 * Testing note:
 * This file is copied with the same file name and executable code.
 * getAge() and setAge() are suitable for state-based testing.
 * The warning message printed for invalid input is not asserted in unit tests.
 */

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