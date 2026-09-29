/**
 * 1. Create an interface named Printer with method: void print(String text).
 * 2. Inside main, create an anonymous class that implements Printer and converts the text to uppercase before printing it.
 * 3. Print the text: "Learning anonymous classes!".
 */


package modern.exercises;

public class Exercise3
{
    /**
     * Printer
     */
    interface Printer {
        void print(String text);
    }
    public static void main(String[] args)
    {
        Printer p = new Printer(){
            @Override 
            public void print(String text){
                System.out.println(text.toUpperCase());
            }
        };
        p.print("Anonymous");
    }
}
