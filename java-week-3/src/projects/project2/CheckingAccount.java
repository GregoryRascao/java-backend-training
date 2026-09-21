package projects.project2;

public class CheckingAccount extends BankAccount {
    private static final double WITHDRAWAL_FEE = 1.00;

    public CheckingAccount(String accountNumber, String ownerName,
            double initialBalance) {
        super(accountNumber, ownerName, initialBalance);
    }

    @Override
    public boolean withdraw(double amount) {
        validatePositiveAmount(amount);
        double totalAmount = amount + WITHDRAWAL_FEE;

        // Le retrait doit couvrir à la fois la somme demandée et les frais.
        if (totalAmount > getBalance()) {
            return false;
        }

        updateBalance(-totalAmount);
        return true;
    }

    @Override
    public String getAccountType() {
        return "Checking account";
    }
}
