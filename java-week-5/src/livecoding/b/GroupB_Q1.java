package livecoding.b;

class Engine
{
    private final int horsePower;

    public Engine(int horsePower)
    {
        this.horsePower = horsePower;
    }

    public void start()
    {
        System.out.println("Engine started");
    }

    public int getHorsePower()
    {
        return horsePower;
    }
}

class Car
{
    private final String brand;
    private final Engine engine;

    public Car(String brand, Engine engine)
    {
        this.brand = brand;
        this.engine = engine;
    }

    public void drive()
    {
        engine.start();
        System.out.println("Car is driving");
    }

    public String getBrand()
    {
        return brand;
    }
}

public class GroupB_Q1
{
    public static void main(String[] args)
    {
        Engine engine = new Engine(150);
        Car car = new Car("Toyota", engine);
        car.drive();
    }
}
