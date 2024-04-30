package com.pluralsight.PortfolioRevisted;

public class BankAccount implements Valuable{
    //Variables as private
    private String name;
    private int accountNumber;
    private double balance;

    public BankAccount(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
        }else{
            System.out.print("No Funds");
        }
    }

    @Override
    public double getValue() {
        return balance;
    }
}
