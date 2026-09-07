package classes.examples.polymorphism;

public class Rectangle extends Figure {

    public void draw() {
        System.out.println("Rectangle is the latest");
    }

    public void rectangleSpecific() {
        System.out.println("Sum of my inside angles are 360 degrees.");
    }

}
