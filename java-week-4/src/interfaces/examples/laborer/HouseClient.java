package interfaces.examples.laborer;

interface Lockable {
    void lock();
    void unlock();
}

abstract class Door {
    private int height = 0;     // implicitly they are all static
    private int width = 0;      // implicitly they are final

    public abstract void build();

    public int getArea() {
        return getHeight() * getWidth();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) throws IllegalArgumentException{
        if(height < 0) throw new IllegalArgumentException();
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}

class WoodenDoor extends Door implements Lockable {
    public void build() {
        System.out.println("Building a wooden door");
    }

    public void lock() {
        System.out.println("Locking");
    }

    public void unlock() {
        System.out.println("Unlocking");
    }
}

class SteelDoor extends Door implements Lockable {
    public void build() {
        System.out.println("Building a steel door");
    }

    @Override
    public void lock() {
        System.out.println("SteelDoor locking");
    }

    @Override
    public void unlock() {
        System.out.println("SteelDoor unlocking");

    }
}

interface Paint {

    void apply();
}
class RedPaint implements Paint {
    public void apply() {
        System.out.println("Painting with red color");
    }
}

class BluePaint implements Paint {
    public void apply() {
        System.out.println("Painting with blue color");
    }
}

class Laborer {

    private Door door;
    private Paint paint;

    public Laborer(Door door, Paint paint) {
        this.door = door;
        this.paint = paint;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public Door getDoor() {
        return door;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public Paint getPaint() {
        return paint;
    }

    public void produce() {
        door.build();
        paint.apply();
    }

}

public class HouseClient {
    public static void main(String[] args) {

        //There are different types of paint and doors, they are interchangable, they are decided on runtime, this is Strategy pattern

        WoodenDoor wd = new WoodenDoor();
        wd.setWidth(10);

        Laborer maker1 =
                new Laborer(new WoodenDoor(), new RedPaint());        //This is dependency injection
        //private Door door = new WoodenDoor(); // this is hard coded, tightly coupled

        Laborer maker2 =
                new Laborer(new SteelDoor(), new BluePaint());

        /*
            Dependency Injection is a technique.
            Strategy is a design pattern.
            DI is often used to implement Strategy.
         */

        maker1.produce();
        maker2.produce();

        /*
            Single Responsibility
            Open Closed Principle

            Dependency Inversion Principle
            SOLID

            Dependency Inversion Principle
            High-level modules should not depend on low-level modules.
            Both should depend on abstractions.

         */
    }
}
