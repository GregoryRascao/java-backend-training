public class IsVariableVisible {

    public static void main(String[] args)
    {
        int variable = 1;

        while (variable <= 5)
        {
            System.out.println("variable = " + variable);
            variable++;
        }

        System.out.println(variable);   //variable is still visible because it was defined outside the loop block
    }
}
