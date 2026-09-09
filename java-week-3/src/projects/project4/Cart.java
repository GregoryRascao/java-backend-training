package projects.project4;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    Double totalPrice;
    Map<Product, Integer> items;

    Cart() {
        this.items = new HashMap<>();
        this.totalPrice = 0.0d;
    }

    void addProduct(Product product, int quantity) {
        if (product == null) {
            System.out.println("Product is null!");
            throw new IllegalArgumentException("Product cannot be null");
            //Which one is better?
        }
        if (items.containsKey(product)) {   //What if items.get(product) != null
            items.put(product, items.get(product) + quantity);
            //after the previous line, we have the quantity updated
        } else {
            items.put(product, quantity);
        }
        calculateTotalPrice();
    }

    //Same method name with different parameters, what is this called?
    void addProduct(Product product) {  //Method overloading
        this.addProduct(product, 1);
    }

    void removeProduct(Product product, int quantity) {
        if(product == null) {
            System.out.println("Product is null!");
            throw new IllegalArgumentException("Product cannot be null");
        }
        if(items.containsKey(product)) {    //if we have it on our cart already
            if(items.get(product) < quantity) {
                //4 different ways
                //1st way
                System.out.println("Quantity (" + quantity + ") was bigger than what we had (" + items.get(product) + ")");
                //2nd way
                System.out.println("Quantity (" + quantity + ") was bigger than what we had (" + items.get(product) + ")");
                System.out.println("Removing all of the products");
                items.remove(product);
                //3rd way
                throw new IllegalArgumentException("Quantity (" + quantity + ") was bigger than what we had (" + items.get(product) + ")");
                //4th way
                //Asking on runtime from CLI
            }
            else if(items.get(product) == quantity) {
                items.remove(product);
            }
            else {
                items.put(product, items.get(product) - quantity);
            }
        }
        calculateTotalPrice();
    }

    // This method removes all the products regardless of how many we have
    void removeProduct(Product product) {
        this.removeProduct(product, items.get(product));
    }

    // removeProduct by one could have been implemented here

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void calculateTotalPrice() {
        //This method has a bug, to be refactored by students
        System.out.println("Before calculation" + totalPrice);
        //students should find the bug here
        for(Map.Entry<Product, Integer> entry : items.entrySet()) {
            totalPrice += entry.getValue() * entry.getKey().getPrice();
        }   //              quantity       *    price
        /*
        //forEach is not designed for calculations
        this.items.forEach((product, quantity) -> {
            totalPrice += quantity * product.getPrice();
        });
        */
    }

    public void showCart() {
        this.items.forEach((product, quantity) -> System.out.println("We have " + quantity + " " + product.getName() + "s"));
    }
    // Command and Query Separation

}
