package iterators.examples;

import java.util.*;

/**
 * Example 7: Sorting with Collections.sort and Comparator
 *
 * We sort a list of products first by price, then by price and name together.
 */
public class Example7
{
    public static void main(String[] args)
    {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Adjustable table", 200.0));
        products.add(new Product("Keyboard", 45.0));
        products.add(new Product("Mouse", 20.0));
        products.add(new Product("Monitor", 45.0));
        products.add(new Product("Webcam", 30.0));
        products.add(new Product("Headset", 20.0));

        System.out.println("Original order:");
        printAll(products);

        // We sort by price ascending using a Comparator
        Collections.sort(products, new Comparator<Product>()
        {
            public int compare(Product p1, Product p2)
            {
                if(p1.getPrice() < p2.getPrice()) {
                    return -1;
                }
                else if(p1.getPrice() > p2.getPrice()) {
                    return 1;
                }
                else return 0;
                //return Double.compare(p1.getPrice(), p2.getPrice());
            }
        });

        System.out.println("\nSorted by price:");
        printAll(products);

        // When two products share the same price, we break the tie by name
        Collections.sort(products, new Comparator<Product>()
        {
            public int compare(Product p1, Product p2)
            {
                int priceComparison = Double.compare(p1.getPrice(), p2.getPrice());
                if (priceComparison != 0)
                {
                    return priceComparison;
                }
                return p1.getName().compareTo(p2.getName());
            }
        });

        System.out.println("\nSorted by price, then by name:");
        printAll(products);

        // Teaser: later, lambdas will let us write the whole Comparator above in one line, like this:
        // Collections.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
    }

    private static void printAll(List<Product> products)
    {
        for (Product product : products)
        {
            System.out.println(product);
        }
    }
}

class Product
{
    private String name;
    private double price;

    public Product(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    @Override
    public String toString()
    {
        return name + " (" + price + ")";
    }
}
