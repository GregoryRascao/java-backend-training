package projects.project4;

public class User {
    private Cart cart;

    User(Cart cart) {
        this.setCart(cart);
    }


    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
