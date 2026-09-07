/**
 * Assignment Operators
 * --------------------
 * =   : Assignment
 * +=  : Addition assignment
 * -=  : Subtraction assignment
 * *=  : Multiplication assignment
 * /=  : Division assignment
 * %=  : Modulus assignment
 */

public class Assignment
{
    public static void main(String[] args)
    {
        int a = 10; // Assignment
        System.out.println("Initial value of a: " + a);

        a += 5; // Addition assignment a = a + 5
        System.out.println("After a += 5: " + a);

        //Does += change the original value
        System.out.println("is a changed? " + a);

        a -= 3; // Subtraction assignment a = a - 3
        System.out.println("After a -= 3: " + a);

        a *= 2; // Multiplication assignment
        System.out.println("After a *= 2: " + a);

        a /= 4; // Division assignment
        System.out.println("After a /= 4: " + a);

        a %= 3; // Modulus assignment
        System.out.println("After a %= 3: " + a);
    }
}
