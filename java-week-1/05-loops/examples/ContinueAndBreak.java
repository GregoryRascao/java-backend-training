
public class ContinueAndBreak {

    public static void main(String[] args)
    {
        for (int variable = 1; variable <= 10; variable++)
        {
            if (variable == 3) continue; // skip 3
            if (variable == 5) break;    // stop at 5
            System.out.println(variable);
        }
        // System.out.println(variable);   //IS NOT VISIBLE
        System.out.println("The continue break loop finished!");
    }
}
