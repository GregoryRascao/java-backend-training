/**
 * 1. Create a sealed interface Shape that permits Circle, Rectangle and Triangle.
 * 2. Create classes/records for Circle, Rectangle and Triangle (base and height).
 * 3. Write a method area(Shape shape) using pattern matching for instanceof, with a branch for each shape.
 * 4. In main, create one of each shape and print their areas.
 */

package modern.exercises;

public class Exercise6 {
    sealed interface Shape permits Circle, Rectangle, Triangle {
    }

    record Circle(double radius) implements Shape {
    }

    record Rectangle(double width, double height) implements Shape {
    }

    record Triangle(double base, double height) implements Shape {
    }

    public static double area(Shape shape) {
        if (shape instanceof Circle circle) {
            return Math.PI * circle.radius() * circle.radius();
        } else if (shape instanceof Rectangle rectangle) {
            return rectangle.height() * rectangle.width();
        }else if (shape instanceof Triangle triangle) {
            return triangle.base() * triangle.height() / 2;
        }
        throw new IllegalArgumentException("Unknown shape");
    }

    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape triangle = new Triangle(4, 6);
        System.out.println("Circle area: " + area(circle));
        System.out.println("Rectangle area: " + area(rectangle));
        System.out.println("Triangle area: " + area(triangle));
    }
}
