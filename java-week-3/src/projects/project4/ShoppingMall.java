package projects.project4;

public class ShoppingMall {

    public static void main(String[] args) {
        User chitra = new User();

        Product computer = new Product("Computer", 499.99);
        Product tablet = new Product("Tablet", 399.99);
        // Product isItPossible = new Product("", 999.99);
        Product water = new Product("water", 0.99);

        chitra.getCart().addOneProduct(computer);
        chitra.getCart().addOneProduct(tablet);

        User charlotte = new User();
        charlotte.getCart().addProduct(tablet, 5);

        // User gregory = new User(chitra.getCart());  //in the shopping mall, gregory took Chitra's cart
        User gregory = new User(new Cart(chitra.getCart().getItems()));


        charlotte.getCart().addOneProduct(water );
        gregory.getCart().addProduct(water, 10);

        charlotte.getCart().removeProduct(water, 5);
        gregory.getCart().removeProduct(water, 5);
    }
}