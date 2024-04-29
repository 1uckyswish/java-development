package com.pluralsight.portfolio;

import com.pluralsight.finance.*;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private String name;
    private String owner;
    private List<BankAccount> bankAccounts;

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
        this.bankAccounts = new ArrayList<>();
    }

    public void addAsset(BankAccount asset) {
        bankAccounts.add(asset);
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public double getValue() {
        double netValue = 0.0;
        for (BankAccount account : bankAccounts) {
            netValue += account.getBalance();
        }
        return netValue;
    }

    public BankAccount getMostValuable() {
        if (bankAccounts.isEmpty()) {
            return null;
        }
        BankAccount mostValuable = bankAccounts.get(0);
        for (BankAccount account : bankAccounts) {
            if (account.getBalance() > mostValuable.getBalance()) {
                mostValuable = account;
            }
        }
        return mostValuable;
    }

    public BankAccount getLeastValuable() {
        if (bankAccounts.isEmpty()) {
            return null;
        }
        BankAccount leastValuable = bankAccounts.get(0);
        for (BankAccount account : bankAccounts) {
            if (account.getBalance() < leastValuable.getBalance()) {
                leastValuable = account;
            }
        }
        return leastValuable;
    }
}
