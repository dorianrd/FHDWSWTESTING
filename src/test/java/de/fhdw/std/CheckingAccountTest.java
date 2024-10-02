package de.fhdw.std;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CheckingAccountTest {

    //CheckingAccount
    @Test 
    void depositNegative() {
        CheckingAccount checkingAccount = new CheckingAccount("1", 0, 500, 5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> checkingAccount.deposit(-100));
    }

    @Test 
    void depositPositiv() {
        CheckingAccount checkingAccount = new CheckingAccount("1", 0, 500, 5);;
        checkingAccount.deposit(100);
        Assertions.assertEquals(100, checkingAccount.getBalance());
    }

    @Test
    void withdrawwPositve() {
        CheckingAccount checkingAccount = new CheckingAccount("1", 1000, 500, 5);
        checkingAccount.withdraw(200);
        Assertions.assertEquals(800, checkingAccount.getBalance());
    }

    @Test
    void withdrawwithinLimit() {
        CheckingAccount checkingAccount = new CheckingAccount("1", 1000, 500, 5);
        checkingAccount.withdraw(1200);
        Assertions.assertEquals(-205, checkingAccount.getBalance());
    }

    @Test
    void withdrawOverLimit() {
        CheckingAccount checkingAccount = new CheckingAccount("1", 1000, 500, 5);
        Assertions.assertThrows(InsufficientFundsException.class, () -> checkingAccount.withdraw(1700));
    }

    @Test
    void withdrawNegative() {
        CheckingAccount checkingAccount = new CheckingAccount("1", 0, 500, 5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> checkingAccount.withdraw(-100));
    }

    //SavingsAccount
    @Test
    void SavingsAccountdepositNegative() {
        SavingsAccount savingsAccount = new SavingsAccount("1", 1000, 0.05);
        Assertions.assertThrows(IllegalArgumentException.class, () -> savingsAccount.deposit(-100));
    }

    @Test
    void SavingsAccountdepositPositiv() {
        SavingsAccount savingsAccount = new SavingsAccount("1", 1000, 0.05);
        savingsAccount.deposit(100);
        Assertions.assertEquals(1100, savingsAccount.getBalance());
    }

    @Test
    void SavingsAccountwithdrawPositiv() {
        SavingsAccount savingsAccount = new SavingsAccount("1", 1000, 0.05);
        savingsAccount.withdraw(200);
        Assertions.assertEquals(800, savingsAccount.getBalance());
    }

    @Test
    void SavingsAccountwithdrawLimit() {
        SavingsAccount savingsAccount = new SavingsAccount("1", 1000, 0.05);
        Assertions.assertThrows(IllegalArgumentException.class, () -> savingsAccount.deposit(-1200));
    }

    @Test 
    void SavingsAccountwithdrawNegative() {
        SavingsAccount savingsAccount = new SavingsAccount("1", 1000, 0.05);
        Assertions.assertThrows(IllegalArgumentException.class, () -> savingsAccount.withdraw(-100));
    }
}