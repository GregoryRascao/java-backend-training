package exceptions.examples;

public class Example2
{
    public static void main(String[] args)
    {
        try {
            String text = null;
            System.out.println(text.length()); // risky code
        }
        catch (NullPointerException e) {
            System.out.println("This is a null String");
            System.out.println("A null string has been passed to Example2");
            //It's better to log error
        }
        catch (RuntimeException rte) {
            System.out.println("RTE caught");
        }
        finally
        {
            System.out.println("This block always runs.");
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
        finally do sth else
*/
    }
}
