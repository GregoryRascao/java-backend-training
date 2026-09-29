/**
 * 1. Create a record named Product with components: String name, double price.
 * 2. Add a compact constructor that throws an IllegalArgumentException if price is negative.
 * 3. Create two Product objects with the same values in main.
 * 4. Print each product using accessor methods and print the objects directly.
 * 5. Check if the two objects are equal, then try creating a Product with a negative price to confirm the validation works.
 */

package modern.exercises;

public class Exercise7 {
    record Product(String name, double price) {
        public Product {
            if (price < 0) {
                throw new IllegalArgumentException("Price can't be negative");
            }
        }
    };

    public static void main(String[] args) {
        Product p = new Product("Computer", 10);
        Product d = new Product("Mouse", 100);

        System.out.println("P :" + p.name() + " " + p.price());
        System.out.println("D :" + d.name() + " " + d.price());

        System.out.println(p.equals(d));

        try {
            Product invalidProduct = new Product("Mouse", -20);
            System.out.println(invalidProduct);
        } catch (IllegalArgumentException exception) {
            System.out.println("Error : " + exception.getMessage());
        }

    }
}
