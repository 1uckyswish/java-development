package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {
    public static void main(String[] args) {
        //initialize scanner top level
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to java sandwich shop");
        // ask user for size
        String size = getSize(scanner);
        // pass the value size of sandwich to figure out the cost of it
        double costOfSandwich = getCost(size);
        //ask user if they want it loaded and it will return true or false
        boolean loadedOrNot = wantsLoaded(scanner);
        // pass the boolean value to figure out the cost of sandwich if extra toppings
        double loadedCost = getLoadedCost(loadedOrNot, costOfSandwich);
        // grab only the age of user
        int age = getAge(scanner);
        // figure out the discount based on age and the cost of the sandwich
        double discount = getDiscount(age, costOfSandwich);
        //pass the cost of sandwich, extra topping cost and discount amount to figure out grand total
        double total = getTotal(costOfSandwich, loadedCost, discount);
        // pass all the variables that hold a value currently just to display the Receipt of sandwich
        summary(size, loadedCost, discount, total);
        // close scanner after use to prevent memory leaks
        scanner.close();
    }

    public static String getSize(Scanner scanner) {
        System.out.println("What size sandwich would you like?");
        System.out.println("Regular: $5.45\nLarge: $8.95");
        System.out.print("Choose an option: ");
        //ask user for size but make it lowercase due to the value being checked later as lower (ex. getCost() method)
        String size = scanner.nextLine().toLowerCase();
        // make sure user types in the proper size else it will return the method
        if (!size.equalsIgnoreCase("regular") && !size.equalsIgnoreCase("large")) {
            System.out.println("Invalid option. Please choose either 'regular' or 'large'.");
            //return the getSize method
            return getSize(scanner);
        }
        // if value equals one of the two correctly return it.
        return size;
    }

    public static double getCost(String size) {
        // if the size is regular do 5.45 but if the condition is false it defaults to 8.95.
        return (size.equals("regular")) ? 5.45 : 8.95;
    }

    public static boolean wantsLoaded(Scanner scanner) {
        System.out.print("Would you like your sandwich Loaded for an extra cost? ");
        //if they choose no it will return flase since it doesnt equal yes. also it ignore case sensitive
        return scanner.next().equalsIgnoreCase("yes");
    }

    public static double getLoadedCost(boolean loadedOrNot, double costOfSandwich) {
        //if loaded is true then check the condition else (:) do 0.00
        //if loaded is true then check the cost of candwich and see if it equals the cost of regular or large.
        // if cost is large or small then return the cost of the extra topping based on sandwich size
        return loadedOrNot ? (costOfSandwich == 5.45 ? 1.00 : 1.75) : 0.00;
        //double loadedCost = (loadedOrNot && costOfSandwich == 5.45) ? 1.00 : (loadedOrNot && costOfSandwich == 8.95) ? 1.75 : 0.00;
    }

    public static int getAge(Scanner scanner) {
        System.out.println("What is your age to receive discount");
        System.out.println("Don't lie now.. we check ID'S here at java shop");
        //return the age chosen
        return scanner.nextInt();
    }

    public static double getDiscount(int age, double costOfSandwich) {
        double discount = 0.00;
        // have a defaut value of 0
        // if it doesnt pass the following test then return zero
        if (age < 18 && age > 0) {
            discount = costOfSandwich * 0.10;
        } else if (age >= 65) {
            discount = costOfSandwich * 0.20;
        }
        // return zero if no logic up top ^ gets passed. else if it does then return updated value
        return discount;
    }

    public static double getTotal(double costOfSandwich, double loadedCost, double discount) {
        return (costOfSandwich + loadedCost) - discount;
    }

    public static void summary(String size, double loadedCost, double discount, double total) {
        System.out.println("*********** ORDER SUMMARY ***********");
        System.out.printf("Choice of sandwich: %s\n", size);
        System.out.printf("Extra toppings: $%.2f\n", loadedCost);
        System.out.printf("Total discount: $%.2f\n", discount);
        System.out.printf("Total price ~ : $%.2f\n", total);
        System.out.println("*********** THANK YOU COME AGAIN ***********");
    }
}

