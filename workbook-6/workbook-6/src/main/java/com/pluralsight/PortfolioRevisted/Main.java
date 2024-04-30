package com.pluralsight.PortfolioRevisted;

import java.util.Scanner;

public class Main {
    //Make scanner global to be used
    private static final Scanner scanner = new Scanner(System.in);
    //Set a single portfolio
    private static final Portfolio portfolio = new Portfolio("Portfolio", "Noel Guillen");

    public static void main(String[] args) {
        //Keep the program running
        while (true) {
            //display the options
            displayMainMenu();
            //Get user choice
            int choice = getUserChoice();
            //Pass choice to see if it exist
            handleUserChoice(choice);
        }
    }

    private static void displayMainMenu() {
        System.out.println("\nSelect asset type to add:");
        System.out.println("1. Bank Account");
        System.out.println("2. Credit Card");
        System.out.println("3. Gold");
        System.out.println("4. Jewelry");
        System.out.println("5. House");
        System.out.println("6. Portfolio Information");
        System.out.println("7. Exit");
        System.out.print("Choose an option: ");
    }

    private static int getUserChoice() {
        return scanner.nextInt();
    }

    //Handle the choice and run the method associated to it
    private static void handleUserChoice(int choice) {
        switch (choice) {
            case 1 -> addBankAccount();
            case 2 -> addCreditCard();
            case 3 -> addGold();
            case 4 -> addJewelry();
            case 5 -> addHouse();
            case 6 -> displayPortfolioInformation();
            case 7 -> exitProgram();
            default -> System.out.println("Invalid input.");
        }
    }
    //get user input and append the values to a new class constructor to append to portfolio ArrayList
    private static void addBankAccount() {
        String accountName = getUserInput("Enter account name: ");
        int accountNumber = getIntInput("Enter account number: ");
        double balance = getDoubleInput("Enter account balance: ");
        portfolio.add(new BankAccount(accountName, accountNumber, balance));
    }
    //get user input and append the values to a new class constructor to append to portfolio ArrayList
    private static void addCreditCard() {
        String cardName = getUserInput("Enter credit card name: ");
        String cardNumber = getUserInput("Enter card number: ");
        double cardBalance = getDoubleInput("Enter card balance: ");
        portfolio.add(new CreditCard(cardName, cardNumber, cardBalance));
    }
    //get user input and append the value to a new class constructor to append to portfolio ArrayList
    private static void addGold() {
        double goldWeight = getDoubleInput("Enter weight of gold: ");
        portfolio.add(new Gold(goldWeight));
    }
    //get user input and append the value to a new class constructor to append to portfolio ArrayList
    private static void addJewelry() {
        String jewelryName = getUserInput("Enter name of jewelry: ");
        double karat = getDoubleInput("Enter karat of jewelry: ");
        portfolio.add(new Jewelry(jewelryName, karat));
    }
    //get user input and append the values to a new class constructor to append to portfolio ArrayList
    private static void addHouse() {
        String address = getUserInput("Enter Property Address: ");
        int yearBuilt = getIntInput("Enter year built: ");
        int squareFeet = getIntInput("Enter square feet: ");
        int bedrooms = getIntInput("Enter number of bedrooms: ");
        portfolio.add(new House(address, yearBuilt, squareFeet, bedrooms));
    }
    //method returns the value of the portfolio with the most valuable and least
    private static void displayPortfolioInformation() {
        System.out.println("Portfolio total value: $" + portfolio.getValue());

        Valuable mostValuable = portfolio.getMostValuable();
        printAssetValue("Most valuable asset", mostValuable);

        Valuable leastValuable = portfolio.getLeastValuable();
        printAssetValue("Least valuable asset", leastValuable);
    }


    private static void printAssetValue(String title, Valuable asset) {
        if (asset != null) {
            System.out.println(title + ": " + asset.getClass().getSimpleName() + " - $" + asset.getValue());
        } else {
            System.out.println("No assets in the portfolio.");
        }
    }

    //UTILITY methods
    private static String getUserInput(String prompt) {
        System.out.print(prompt);
        scanner.nextLine(); // Clear the newline character
        return scanner.nextLine();
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    private static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    private static void exitProgram() {
        scanner.close();
        System.exit(0);
    }
}
