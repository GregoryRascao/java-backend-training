package interfaces.exercises;

/**
 * TODO:
 * Exercise 3:
 * Create two interfaces: Flyable and Swimmable, each with a method (fly(),
 * swim()).
 * Implement them in classes: Bird (can fly), Fish (can swim), and Duck (can
 * both fly & swim).
 * Test them in Exercise3 class.
 */
public class Exercise3 {
    /**
     * Flyable
     */
    interface Flyable {
        void fly();
    }

    /**
     * Swimable
     */
    interface Swimable {
        void swim();
    }

    /**
     * Bird
     */
    public static class Bird implements Flyable {
        @Override
        public void fly() {
            System.out.println("I believe i can fly");
        };
    }

    /**
     * Fish
     */
    public static class Fish implements Swimable {
        @Override
        public void swim() {
            System.out.println("I believe i can swim");
        }
    }

    /**
     * Duck
     */
    public static class Duck implements Flyable, Swimable {
        @Override
        public void fly() {
            System.out.println("The duck is flying.");
        }

        @Override
        public void swim() {
            System.out.println("The duck is swimming.");
        }
    }

    public static void main(String[] args) {
        Bird bird = new Bird();
        Fish fish = new Fish();
        Duck duck = new Duck();

        bird.fly();
        fish.swim();
        duck.fly();
        duck.swim();
    }
}
