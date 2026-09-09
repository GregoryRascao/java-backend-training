package inheritance.examples;

public class HashCodeDemo {
    public static void main(String[] args) {

        Bike shimano = new Bike("Shimano", 0, "2026");
        System.out.println(shimano.hashCode());
        Bike bmx = new Bike("Shimano", 0, "2026");
        System.out.println(bmx.hashCode());

        System.out.println(shimano.hashCode() == bmx.hashCode());
//        When you don’t override hashCode(), Java uses object identity.
//        Two different objects → different identities → different hash codes.


//        String word = "word";
//        System.out.println(word.hashCode());
//        String word2 = "word";
//        System.out.println(word.hashCode());
//        System.out.println(word.hashCode() == word2.hashCode());        // This is true because of string pooling
//        System.out.println(word.equals(word2);        // This is true because of string pooling

    }
}
