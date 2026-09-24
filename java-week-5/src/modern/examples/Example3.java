/**
 * 1. Use an anonymous class to implement an interface.
 * 2. Use another anonymous class with Comparator.
 */

package modern.examples;

import java.util.Arrays;
import java.util.Comparator;

public class Example3
{
    interface Printer
    {
        void print(String text);
    }

    @SuppressWarnings("Convert2Lambda")
    public static void main(String[] args)
    {
        Printer printer = new Printer()
        {
            @Override
            public void print(String text)
            {
                System.out.println(text);
            }
        };

        printer.print("Hello from anonymous class!");

        String[] names = {"Ali", "Christopher", "Mia", "Jo"};
        Arrays.sort(names, new Comparator<String>()
        {
            @Override
            public int compare(String a, String b)
            {
                return Integer.compare(a.length(), b.length());
            }
        });

        System.out.println(Arrays.toString(names));
    }
}
