package exceptions.examples;

public class Example2
{
    public static void main(String[] args)
    {
        try {
            String text = null;
            System.out.println(text.length()); // risky code
            int array[] = new int[10];
            array[12] = 100;
        }
        catch (NullPointerException e) {
            System.out.println("This is a null String");
            System.out.println("A null string has been passed to Example2");
            //It's better to log error
        }
        catch (ArithmeticException ae) {
            System.out.println("ArithmeticException occured, log it somewhere");
        }
        catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("ArrayIndexOutOfBoundsException happened");
        }
        catch (RuntimeException rte) {
            System.out.println("RTE caught");
        }
        finally
        {
            System.out.println("Finally block always runs.");
        }
        System.out.println("I am written after the finally");

    }

/*
        if(runs smoothly) {
            do that
        }
        else if(it crashes) {
            handle like this
        }
        else if(it crashes another way) {
            handle differently
        }
        finally do sth else, close resources and such, this part ALWAYS runs
*/
}
