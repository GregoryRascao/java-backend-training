package classes.examples.polymorphism;

/**
 * Example 4: Abstract, Final, and Inner Classes
 */
//TODO arrange it in a better way
public class Example4Polymorphism
{
    private int iAmPrivate = 0;

    public static void main(String[] args)
    {
        Figure a = new Circle();     //referance type is Shape
        Figure b = new Square();     //The real object's type is Square /or actual type)
        a.draw();                   //how it will behave will be decided on runtime (when we are running)
        b.draw();
        Circle c = new Circle();    //also possible

        //Polymorphism is when the same method call behaves differently depending on the actual type of the object.

//      Figure f = new Figure(); //figure is abstract, cannot be instantiated

        Utility u = new Utility();
        u.printMessage();

        //question: how would you create an inner class object?

        Example4Polymorphism outer = new Example4Polymorphism();
        System.out.println(outer.iAmPrivate);

        Inner inner = outer.new Inner();            //inner class cannot live without an outer class
        inner.show();

        //Another question, how can we create a Circle object but not create an Inner object?
            //why do we need an outer object for inner but not for Circle?
    }

    private void imAnAnIntrovert() {
        System.out.println("I dont want to talk!");
        this.imAnAnIntrovert();
    }

    // Inner class
    class Inner
    {
        void show()
        {
            System.out.println("Inner class method");
            System.out.println(iAmPrivate );
            imAnAnIntrovert();
        }

        //question: can it use outer class' private methods?
        //          implicit outer reference
    }
}

class Circle extends Figure
{
    public int radius;
    public final double PI = 3.14;

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }

    public final double area() {
        return PI * radius * radius;
    }
}

class Sphere extends Circle {   //note: bad example, Sphere is not a Circle!
    /* final methods cannot be overriden!
    public double area() {
        return 0.0;
    }*/
}

// Final class
final class Utility
{
    public void printMessage()
    {
        System.out.println("A final class cannot be extended");
    }
}

