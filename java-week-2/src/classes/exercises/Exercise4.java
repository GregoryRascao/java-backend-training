package classes.exercises;

/**
 * Exercise 4: Abstract, Final, Inner Classes
 * ------------------------------------------
 * TODO:
 * 1. Create an abstract class Animal with abstract method sound().
 * 2. Create a subclass Cat that implements sound().
 * 3. Create a final class MathUtil with method square(int).
 * 4. Create an inner class inside Exercise4_AbstractFinalInner that prints a message.  //do not do it yet
 */
public class Exercise4
{
    public static void main(String[] args)
    {
        Cat cat1 = new Cat();
        cat1.Sleep();
        cat1.sound();

        MathUtil mat = new MathUtil();
        System.out.println("Square method :" + mat.square(2));
    }
}

abstract class Animal{
    abstract void sound();
    void Sleep(){
        System.out.println("il dort");
    }
}

class Cat extends Animal{
    @Override
    void sound(){
        System.out.println("the cat says..");
    }
}

class MathUtil{
    int square(int number){
        return number * number;
    }
}