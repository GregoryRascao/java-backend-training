package projects.project2;

public class SavingsAccount extends BankAccount {
    private static final double MINIMUM_BALANCE = 100.00;

    public SavingsAccount(String accountNumber, String ownerName,
            double initialBalance) {
        super(accountNumber, ownerName, initialBalance);
    }

    @Override
    public boolean withdraw(double amount) {
        validatePositiveAmount(amount);

        // Un compte d'epargne doit conserver son solde minimum.
        if (getBalance() - amount < MINIMUM_BALANCE) {
            return false;
        }

        updateBalance(-amount);
        return true;
    }

    @Override
    public String getAccountType() {
        return "Savings account";
    }
}
