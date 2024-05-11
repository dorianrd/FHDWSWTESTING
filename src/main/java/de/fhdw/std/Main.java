package de.fhdw.std;

public class Main {
    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount("1", 1000, 1000, 10);
        checkingAccount.deposit(1000);
        checkingAccount.withdraw(500);
        System.out.println(checkingAccount);

        SavingsAccount savingsAccount = new SavingsAccount("2", 1000, 0.05);
        savingsAccount.deposit(100);
        savingsAccount.addInterest();
        System.out.println(savingsAccount);
    }
}