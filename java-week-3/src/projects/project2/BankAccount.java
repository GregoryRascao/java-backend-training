package projects.project2;

public abstract class BankAccount {
    private final String accountNumber;
    private final String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName,
            double initialBalance) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException(
                    "Account number cannot be empty.");
        }
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("Owner name cannot be empty.");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                    "Initial balance cannot be negative.");
        }

        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    // Le solde est lisible, mais il n'est pas modifiable directement.
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        validatePositiveAmount(amount);
        balance += amount;
    }

    public boolean withdraw(double amount) {
        validatePositiveAmount(amount);

        if (amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }

    // Les sous-classes utilisent cette méthode pour appliquer leurs règles.
    protected void updateBalance(double amount) {
        balance += amount;
    }

    protected void validatePositiveAmount(double amount) {
        if (amount <= 0 || Double.isNaN(amount)
                || Double.isInfinite(amount)) {
            throw new IllegalArgumentException(
                    "Amount must be a finite positive number.");
        }
    }

    public abstract String getAccountType();

    @Override
    public String toString() {
        return getAccountType() + " - " + accountNumber + " - "
                + ownerName + " - balance: " + String.format("%.2f", balance);
    }
}
