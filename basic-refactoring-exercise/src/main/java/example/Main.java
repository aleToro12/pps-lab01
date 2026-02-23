package example;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

public class Main {

    public static void main(String[] args) {
        final AccountHolder accountHolder = new AccountHolder("Mario", "Rossi", 1);
        final BankAccount bankAccount = new SimpleBankAccount(accountHolder, 0);
        bankAccount.deposit(accountHolder.id(), 100);
        bankAccount.withdraw(accountHolder.id(), 30);
        bankAccount.withdraw(accountHolder.id(), 80);
    }
}
