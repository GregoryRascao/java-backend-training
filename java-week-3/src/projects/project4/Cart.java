package projects.project4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private double totalPrice;
    private final Map<Product, Integer> items = new HashMap<>();
    // Use `Map<Product, Integer>` for product quantities.
    // Why not Map<Integer, Product> ?

    Cart() {
    }

    Cart(Map<Product, Integer> selectedOnes) {
        this.items.putAll(selectedOnes);
        calculateTotalPrice();
    }

    public Map<Product, Integer> getItems() {
        return Collections.unmodifiableMap(items);
    }

    // why not this is possible?
    // public void setItems(Map<Product, Integer> givenItems) {
    // this.items = givenItems;
    // }

    public void addItems(Map<Product, Integer> givenItems) {
        // this.items = givenItems; //I cannot do this
        this.items.putAll(givenItems);
        calculateTotalPrice();
        // update the new total price
    }

    public void addOneProduct(Product toBeAdded) {
        if (!validateProduct(toBeAdded, 1))
            return;

        if (this.items.containsKey(toBeAdded)) { // if there was already a product before in cart
            this.items.put(toBeAdded, this.items.get(toBeAdded) + 1);// get the number of that product+1)
        } else { // if it is a new product added
            this.items.put(toBeAdded, 1);
        }
        // when should we call calculateTotalPrice();
        // and when should we do:
        this.totalPrice += toBeAdded.getPrice();
        // OR
        calculateTotalPrice();
    }

    public void addProduct(Product toBeAdded, int howMany) {
        if (!validateProduct(toBeAdded, howMany))
            return;

        int previousQuantity = items.getOrDefault(toBeAdded, 0);
        this.items.put(toBeAdded, previousQuantity + howMany);

        // should we update the totalPrice like this or should we call
        // calculateTotalPrice?
        this.totalPrice += (toBeAdded.getPrice() * howMany);
        // OR
        calculateTotalPrice();
    }

    private boolean validateProduct(Product toBeAdded, int howMany) {
        if (toBeAdded == null) {
            // return false;
            // Think about what to do on validations
            // will you just warn the user?
            // will you run the code even if it is not validated?
            // will you throw an exception?
            throw new IllegalArgumentException("You cannot add a null product!");
        }
        if (howMany <= 0) {
            // return false;
            // throw new IllegalArgumentException("Minus value was passed to add method.");
            throw new IllegalArgumentException("You cannot add minus number of products, user removeProduct instead!");
        }
        return true;
    }

    public void removeOneProduct(Product toBeRemoved) {
        removeProduct(toBeRemoved, 1);
    }

    public void removeProduct(Product toBeRemoved, int quantity) {
        // Psuedo code
        // I will remove the product //this needs more detail

        // Better Psuedo code
        // I will find the previous quantity
        // I will check if given quantity is <= previous quantity
        // if the quantity is smaller, update the quantity
        // if it is equal remove the whole item from the cart
        // update the total price
        if (toBeRemoved == null) {
            throw new IllegalArgumentException("The product cannot be null.");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "The quantity to remove must be positive.");
        }
        int previousQuantity = items.getOrDefault(toBeRemoved, 0);
        if (previousQuantity <= quantity) {
            // This situation was not specified in the original question
            // So if you face a situation like this in an interview or in a code kata
            // Ask them for details
            System.out.println("You don't have " + quantity + " items, " +
                    "you had " + previousQuantity + " items, so all the "
                    + toBeRemoved + " will be removed.");
            this.items.remove(toBeRemoved);
            calculateTotalPrice();
        } else {
            this.items.put(toBeRemoved, previousQuantity - quantity);
            calculateTotalPrice();
        }
    }

    private void calculateTotalPrice() {
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : this.items.entrySet()) {
            total = total + entry.getKey().getPrice() * entry.getValue();
        }
        this.totalPrice = total;
    }

}