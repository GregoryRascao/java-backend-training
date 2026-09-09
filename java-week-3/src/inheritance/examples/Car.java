package inheritance.examples;

// Subclass
public class Car extends Vehicle
{
    private int doors;

//    public Car() {  }  //This constructor cannot exist because parent class doesn't have a default constructor.

    public Car(String brand, int doors)
    {
        super(brand); // call Vehicle constructor
        this.doors = doors;
    }

    @Override
    public void drive()
    {
        System.out.println(brand + " car with " + doors + " doors is driving...");
    }

    public void playMusic()
    {
        System.out.println("Playing music in " + brand + " car.");
    }
}
