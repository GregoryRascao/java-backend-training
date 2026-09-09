package inheritance.examples;

public class Main
{
    public static void main(String[] args) {
        Car car = new Car("Toyota", 4);
        Bike bike = new Bike("Yamaha", 2, "2025");

        car.drive();
        car.playMusic();

        bike.drive();
    }
}
