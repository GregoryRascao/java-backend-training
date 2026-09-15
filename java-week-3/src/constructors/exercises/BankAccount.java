package constructors.exercises;

/**
 * TODO:
 * 1. Create class BankAccount with:
 * - private fields accountNumber, balance
 * - private static field accountCount
 * 2. Add constructors:
 * - Default constructor → sets accountNumber="0000", balance=0
 * - Parameterized constructor → sets accountNumber and balance
 * 3. Increment accountCount whenever a new account is created.
 * 4. Add methods deposit(), withdraw(), getBalance().
 * 5. Add static method getTotalAccounts().
 * 6. Test creating multiple accounts and check total accounts.
 */

public class BankAccount {
     private String accountNumber;
     private int balance;
     private static int accountCount;

     public BankAccount() {
          this("0000", 0);
     }

     public BankAccount(String accountNumber, int balance) {
          this.accountNumber = accountNumber;
          this.balance = balance;
          accountCount++;
     }

     public void deposit(int amount) {
          if (amount > 0) {
               balance += amount;
          }
     }

     public void withdraw(int amount) {
          if (amount > 0 && amount <= balance) {
               balance -= amount;
          }
     }

     public int getBalance() {
          return balance;
     }

     public static int getTotalAccounts() {
          return accountCount;
     }
}
