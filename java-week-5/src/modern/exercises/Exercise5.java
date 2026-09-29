/**
 * 1. Create a class Product with fields: name, price, inStock.
 * 2. Implement a static inner Builder class for Product, where inStock defaults to true when not set explicitly.
 * 3. Make build() throw an IllegalArgumentException if price is negative.
 * 4. Use chained builder calls in main to create one Product object without setting inStock, then print it to confirm the default was applied.
 */

package modern.exercises;

public class Exercise5 {
    /**
     * Product
     */
    static class Product {
        String name;
        double price;
        boolean inStock;

        @Override
        public String toString() {
            return "Is the " + name + " who cost " + price + " is available ? " + inStock;
        }

        private Product(Builder builder) {
            this.name = builder.name;
            this.price = builder.price;
            this.inStock = builder.inStock;
        }

        static class Builder {
            String name;
            double price;
            boolean inStock;

            public Builder name(String name) {
                this.name = name;
                return this;
            }

            public Builder price(double price) {
                this.price = price;
                return this;
            }

            public Builder inStock(boolean inStock) {
                this.inStock = inStock;
                return this;
            }

            public Product build() {
                if (price < 0) {
                    throw new IllegalArgumentException(
                            "Price can't be negative");
                }
                return new Product(this);
            }
        }
    }

    public static void main(String[] args) {
        Product product = new Product.Builder()
                .name("Asus")
                .price(1200.99)
                .inStock(true)
                .build();

        System.out.println(product);
    }
}
