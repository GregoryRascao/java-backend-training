/**
 * Exercises:
 * -------------------------------------------------------------
 * 1. Create an int variable x and check if it is even or odd using if-else.
 *
 * 2. Create an int variable age.
 *    - If age >= 18, print "Adult".
 *    - Else, print "Minor".
 *
 * 3. Create an int variable score (0-100).
 *    - Use if-else to assign grades:
 *      >=90 -> "A"
 *      >=75 -> "B"
 *      >=50 -> "C"
 *      <50  -> "F"
 *
 * 4. Create a double variable temperature.
 *    - If temperature > 30, print "Hot".
 *    - Else if temperature >= 20, print "Warm".
 *    - Else, print "Cold".
 *
 * Bonus:
 * 5. Combine two conditions using logical operators:
 *    - Check if a number n is positive **and** even.
 * -------------------------------------------------------------
 */

public class IfElseE
{
    public static void main(String[] args)
    {
        int number = 10;

        if (number > 0)
        {
            System.out.println("The number is positive.");
        }
        else if (number < 0)
        {
            System.out.println("The number is negative.");
        }
        else
        {
            System.out.println("The number is zero.");
        }

        // -------------------- Student Exercises --------------------
        // 1. Check if x is even or odd.
        int x = 7;
        if (x % 2 == 0)
        {
            System.out.println("EVEN");
        }
        else
        {
            System.out.println("ODD");
        }

        // 2. Check age and print "Adult" or "Minor".
        int age = 18;

        if (age >= 18)
        {
            System.out.println("Adult");
        }
        else
        {
            System.out.println("Minor");
        }


        // 3. Assign grades based on score using if-else if-else.

        int score = 85;

        if (score >= 90)
        {
            System.out.println("Grade A");
        }
        else if (score >= 80)
        {
            System.out.println("Grade B");
        }
        else if (score >= 70)
        {
            System.out.println("Grade C");
        }
        else if (score >= 60)
        {
            System.out.println("Grade D");
        }
        else
        {
            System.out.println("Grade F");
        }


        // 4. Check temperature and print "Hot", "Warm", or "Cold".

        int temperature = 25;

        if (temperature >= 30)
        {
            System.out.println("Hot");
        }
        else if (temperature >= 15)
        {
            System.out.println("Warm");
        }
        else
        {
            System.out.println("Cold");
        }


        // 5. Check if n is positive AND even using logical operators.

        int n = 10;

        if (n > 0 && n % 2 == 0)
        {
            System.out.println("The number is positive and even.");
        }
        else
        {
            System.out.println("The number is not positive and even.");
        }

        //6. Combine two conditions using logical operators:
        //- Check if a number n is positive **and** even.

        int coucouNumber = 10;
        if ( coucouNumber <= 12)
            switch(coucouNumber){
                case 10:
                    System.out.println("hello there");
                    break;
                default:
                    System.out.println("Nope");
        }
    }
}
