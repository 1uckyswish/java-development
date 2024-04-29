package com.pluralsight.finance;

public class FinanceApplication {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("pam", "123", 12500);
        Valuable account2 = new BankAccount("gary", "456", 1500);

        account1.deposit(100);
        ((BankAccount) account2).deposit(100);

        System.out.println(account1);
        System.out.println(account2);
    }
}
