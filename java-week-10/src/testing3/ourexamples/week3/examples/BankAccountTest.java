package testing3.ourexamples.week3.examples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankAccountTest
{
    private static String sharedAccountNumber;
    private BankAccount freshAccount;

    @BeforeAll
    static void storeSharedAccountNumber()
    {
        sharedAccountNumber = "BE123";
    }

    @BeforeEach
    void openFreshAccount()
    {
        freshAccount = new BankAccount(sharedAccountNumber, 100.0);
    }

    @AfterAll
    static void removeSharedAccountNumber()
    {
        sharedAccountNumber = null;
    }

    @Test
    void constructorStoresAccountNumber()
    {
        assertEquals("BE123", freshAccount.getAccountNumber());
    }

    @Test
    void depositIncreasesBalanceForPositiveAmount()
    {
        freshAccount.deposit(50.0);

        assertEquals(150.0, freshAccount.getBalance());
    }

    @Test
    void invalidDepositKeepsBalanceUnchanged()
    {
        freshAccount.deposit(-10.0);

        assertEquals(100.0, freshAccount.getBalance());
    }

    @Test
    void validWithdrawalDecreasesBalance()
    {
        freshAccount.withdraw(40.0);

        assertEquals(60.0, freshAccount.getBalance());
    }

    @Test
    void invalidWithdrawalKeepsBalanceUnchanged()
    {
        freshAccount.withdraw(200.0);

        assertEquals(100.0, freshAccount.getBalance());
    }
}