package projects.project4;

public class Shopping {

    public static void main(String[] args) {
        User user = new User(new Cart());   //We give what the user needs (a cart)

        Product milk = new Product("Milk", 3.0);
        Product yogurt = new Product("Yogurt", 2.0);

        System.out.println("I added 3 milks");
        user.getCart().addProduct(milk, 3);
        System.out.println("Carts total price is: " + user.getCart().totalPrice);
        user.getCart().showCart();
        System.out.println("Carts total price is: " + user.getCart().totalPrice);
        user.getCart().addProduct(milk);
        System.out.println("I added 1 milk");
        user.getCart().showCart();
        System.out.println("Carts total price is: " + user.getCart().totalPrice);
        user.getCart().addProduct(yogurt, 2);
        System.out.println("I added 2 yogurts");
        user.getCart().showCart();
        System.out.println("Carts total price is: " + user.getCart().totalPrice);
    }
}
