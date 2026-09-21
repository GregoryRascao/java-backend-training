package exceptions.examples;

/*
    DO NOT RUN!
    First try to guess the program flow.
    Then guess again.
    Because
    Most of us will fall to this :)
 */

public class Example5NestedChallenge {

    public static int testMethod() {
        try {
            System.out.println("1");

            try {
                System.out.println("2");
                int x = 10 / 0; // exception here
                System.out.println("3");
            } catch (ArithmeticException e) {
                System.out.println("4");
                return 100;
            } finally {
                System.out.println("5");
            }

            System.out.println("6");

        } catch (Exception e) {
            System.out.println("7");
        } finally {
            System.out.println("8");
        }

        System.out.println("9");
        return 200;
    }

    //DO NOT RUN
    public static void main(String[] args) {
        int result = testMethod();
        System.out.println("Result: " + result);
    }
}

/*
Next step: what happens if on first finally we return 300?
 */