/**
 * 1. Create a sealed type hierarchy.
 * 2. Use pattern matching for instanceof.
 * 3. Calculate area by type.
 */

package modern.examples;

public class Example5
{
    /*
    sealed interface Shape permits Circle, Rectangle
    {
    }

    record Circle(double radius) implements Shape
    {
    }

    static final class Rectangle implements Shape
    {
        private final double width;
        private final double height;

        Rectangle(double width, double height)
        {
            this.width = width;
            this.height = height;
        }

        public double getWidth()
        {
            return width;
        }

        public double getHeight()
        {
            return height;
        }
    }

    private static double area(Shape shape)
    {
        if (shape instanceof Circle circle)
        {
            return Math.PI * circle.radius() * circle.radius();
        }

        if (shape instanceof Rectangle rectangle)
        {
            return rectangle.getWidth() * rectangle.getHeight();
        }

        return 0;
    }

    public static void main(String[] args)
    {
        Shape shape1 = new Circle(3);
        Shape shape2 = new Rectangle(4, 5);

        System.out.println("Circle area: " + area(shape1));
        System.out.println("Rectangle area: " + area(shape2));
    }
*/

}
