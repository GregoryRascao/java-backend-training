package projects.project2;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankingApplication {
    public static void main(String[] args) {
        // La valeur de la Map est BankAccount: elle peut donc contenir
        // CheckingAccount et SavingsAccount grace au polymorphisme.
        Map<String, BankAccount> accounts = new LinkedHashMap<>();

        BankAccount checkingAccount = new CheckingAccount(
                "CHK-001", "Alice", 500.00);
        BankAccount savingsAccount = new SavingsAccount(
                "SAV-001", "Bob", 1_000.00);

        accounts.put(checkingAccount.getAccountNumber(), checkingAccount);
        accounts.put(savingsAccount.getAccountNumber(), savingsAccount);

        checkingAccount.deposit(150.00);
        savingsAccount.deposit(200.00);

        System.out.println("Withdrawal from checking account: "
                + checkingAccount.withdraw(100.00));
        System.out.println("Withdrawal from savings account: "
                + savingsAccount.withdraw(1_100.00));

        // La boucle appelle la bonne version de getAccountType()
        // selon le type reel de chaque objet.
        for (BankAccount account : accounts.values()) {
            System.out.println(account);
        }
    }
}
