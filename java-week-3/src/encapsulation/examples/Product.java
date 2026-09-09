package encapsulation.examples;

/**
 * This class represents a Product with encapsulated fields and methods.
 * It includes validation in setters and a method to apply a discount.
 */

public class Product
{
    private final String name;
    private double price;

    // Constructor
    public Product(String name, double price)
    {
        this.name = name;
        setPrice(price); // validation
    }

    // Getters
    public String getName() {return name;}
    public double getPrice() {return price;}

    // Setter with validation
    public void setPrice(double price)
    {
        if (price >= 0)
        {
            this.price = price;
        }
    }

    // Behavior: apply discount
    public void applyDiscount(double percentage)
    {
        if (percentage > 0 && percentage <= 50)
        {
            price -= price * (percentage / 100);
        }
    }
}
