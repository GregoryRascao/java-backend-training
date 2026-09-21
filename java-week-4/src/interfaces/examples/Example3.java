package interfaces.examples;

public class Example3
{
    public static void main(String[] args)
    {
        Shape s1 = new Circle(5);
        Shape s2 = new Rectangle(4, 6);

        System.out.println("Circle area: " + s1.area());
        System.out.println("Rectangle area: " + s2.area());
    }
}

interface Shape
{
    double area();
}

class Circle implements Shape
{
    private final double radius;
    public Circle(double radius) { this.radius = radius; }

    @Override
    public double area()
    {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape
{
    private final double width;
    private final double height;
    public Rectangle(double width, double height)
    {
        this.width = width; this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

