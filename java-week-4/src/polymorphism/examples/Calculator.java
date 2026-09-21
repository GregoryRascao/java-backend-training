package polymorphism.examples;


public class Calculator
{
    public static void main(String[] args)
    {
        Calculator calc = new Calculator();

        System.out.println(calc.add(2, 3));         // 5
        System.out.println(calc.add(2.5, 3.5));     // 6.0
        System.out.println(calc.add(1, 2, 3));      // 6
    }

    // same method name, different signatures
    public int add(int a, int b)
    {
        return a + b;
    }

    public double add(double a, double b)
    {
        return a + b;
    }

    public int add(int a, int b, int c)
    {
        return a + b + c;
    }
}
