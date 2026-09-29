/**
 * 1. Create a class Product with fields: String name, double price.
 * 2. Override toString() to print the product nicely.
 * 3. Override equals() and hashCode() so two products with the same name and price are equal.
 * 4. In main, create two Product objects with the same values and prove equals()/hashCode() work,
 *  then create a third Product with a different price and prove it is NOT equal to the first two.
 */

package modern.exercises;

import java.util.Objects;

public class Exercise8 {
    static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Product name is " + name + " and is price is " + price;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Product other)) {
                return false;
            }
            return Double.compare(price, other.price) == 0 && Objects.equals(name, other.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, price);
        }
    }

    public static void main(String[] args) {
        Product firstProduct = new Product("Computer", 1000);
        Product secondProduct = new Product("Computer", 1000);
        Product thirdProduct = new Product("Computer", 1200);

        System.out.println(firstProduct);
        System.out.println(secondProduct);
        System.out.println(thirdProduct);

        System.out.println("firstProduct equals secondProduct: "
                + firstProduct.equals(secondProduct));

        System.out.println("Same hash code: "
                + (firstProduct.hashCode() == secondProduct.hashCode()));

        System.out.println("firstProduct equals thirdProduct: "
                + firstProduct.equals(thirdProduct));
    }
}
