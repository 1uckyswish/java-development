package com.pluralsight.finance;

import com.pluralsight.portfolio.Portfolio;

import java.util.Scanner;

public class FinanceApplication {
    public static void main(String[] args) {
        // Create a portfolio
        Portfolio portfolio = new Portfolio("My Portfolio", "John Doe");

        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

// Prompt the user to add assets to the portfolio
        while (true) {
            System.out.println("Enter asset details (type 'done' to finish):");
            System.out.print("Asset name: ");
            String name = scanner.nextLine();
            if (name.equals("done")) {
                break; // Exit the loop if the user enters 'done'
            }

            System.out.print("Asset account number: ");
            String accountNumber = scanner.nextLine();

            System.out.print("Asset balance: ");
            double balance = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character

            // Create a new BankAccount instance for each asset and add it to the portfolio
            BankAccount asset = new BankAccount(name, accountNumber, balance);
            portfolio.addAsset(asset);
        }

        // Display portfolio information
        System.out.println("Portfolio: " + portfolio.getName());
        System.out.println("Owner: " + portfolio.getOwner());
        System.out.println("Net value of all assets: " + portfolio.getValue());
        System.out.println("Most valuable asset: " + portfolio.getMostValuable());
        System.out.println("Least valuable asset: " + portfolio.getLeastValuable());

        // Close the scanner
        scanner.close();
    }
}
