package projects.project4;

public class User {

    private final Cart cart;

    User() {
        cart = new Cart();
    }

    User(Cart cart) {
        this.cart = cart;
    }

    public Cart getCart() {
        return this.cart;
    }
}