package encapsulation.examples;

/**
 * A class representing a bank account with encapsulated balance.
 * Demonstrates encapsulation by keeping fields private
 * and providing controlled access through methods.
 */

public class BankAccount
{
    private final String accountNumber; // immutable (final) → cannot change once set
    private double balance;             // mutable → controlled by deposit/withdraw


    public BankAccount(String accountNumber, double balance)
    {
        this.accountNumber = accountNumber;
        if (balance >= 0)
        {
            this.balance = balance;
        }
        else
        {
            this.balance = 0; // fallback to 0 if invalid
            System.out.println("Initial balance cannot be negative. Set to 0.");
        }
    }

    public String getAccountNumber() { return accountNumber;}

    public double getBalance() {return balance; }

    public void deposit(double amount)
    {
        if (amount > 0)
        {
            balance += amount;
            System.out.println("Deposited: " + amount + " | New Balance: " + balance);
        }
        else
        {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount)
    {
        if (amount > 0 && amount <= balance)
        {
            balance -= amount;
            System.out.println("Withdrew: " + amount + " | New Balance: " + balance);
        }
        else
        {
            System.out.println("Invalid withdrawal amount. Available balance: " + balance);
        }
    }
}
