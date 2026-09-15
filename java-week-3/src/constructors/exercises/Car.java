package constructors.exercises;

/**
 * TODO:
 * 1. Create class Car with private fields brand and year.
 * 2. Add:
 * - Default constructor → sets brand="Unknown", year=0
 * - Parameterized constructor → sets brand and year
 * 3. Add method printCarInfo().
 * 4. Test both constructors.
 */

public class Car {
     private String brand;
     private int year;

     // defaut
     public Car() {
          this.brand = "unknown";
          this.year = 0;
     }

     // parameterized
     public Car(String brand, int year) {
          this.brand = brand;
          this.year = year;
     }

     public void printCarInfo() {
          System.out.println("Brand: " + brand);
          System.out.println("Year: " + year);
     }

     public static void main(String[] args) {
          Car defaultCar = new Car();
          defaultCar.printCarInfo();

          System.out.println();

          Car customCar = new Car("Toyota", 2022);
          customCar.printCarInfo();
     }
}
