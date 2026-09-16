package projects.project4;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.setName(name);
        this.setPrice(price); // this is better to use encapsulation
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return this.price;
    }

public void setPrice(double updatedPrice) {
    if (!Double.isFinite(updatedPrice) || updatedPrice < 0) {
        throw new IllegalArgumentException(
            "The price must be a finite positive value."
        );
    }

    this.price = updatedPrice;
}

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "The product name cannot be null or empty.");
        }

        this.name = name;
    }

    public String toString() {
        return this.name + "(" + this.price + ")";
    }
}