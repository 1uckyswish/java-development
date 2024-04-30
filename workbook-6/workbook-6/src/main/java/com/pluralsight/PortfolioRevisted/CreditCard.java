package com.pluralsight.PortfolioRevisted;

public class CreditCard implements Valuable{
    private String name;
    private String accountNumber;
    private double balance;

    public CreditCard(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void charge(double amount){
        balance += amount;
    }

    public void pay(double amount){
        if(balance >= amount){
            balance -= amount;
        }else{
            System.out.println("NO FUNDS TO PAY");
        }
    }

    @Override
    public double getValue() {
        return -balance;
    }
}
