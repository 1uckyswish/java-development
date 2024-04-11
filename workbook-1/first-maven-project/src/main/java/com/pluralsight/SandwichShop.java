package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to java sandwich shop");
        System.out.println("What size sandwich would you like?");
        System.out.println("Regular: " +
                "$5.45\n" +
                "Large: " +
                "$8.95");
        System.out.print("Choose an option: ");
        String size = scanner.nextLine();
        String lowerCase = size.toLowerCase();
        double costOfSandwich = (lowerCase.equals("regular")) ? 5.45 : 8.95;
        System.out.println("What is your age to receive discount");
        System.out.println("Don't lie now.. we check ID'S here at java shop");
        int age = scanner.nextInt();
        double total;
        double discount;
        if (!lowerCase.equals("regular") && !lowerCase.equals("large")) {
            System.out.printf("Sorry we don't offer %s here: Try our other options please", size);
            return;
        }
        if(age < 18 && age > 0){
            discount = costOfSandwich * 0.10;
            total = costOfSandwich - discount;
            System.out.printf("Your total for today with discount is $%.2f", total);
        }else if(age >= 65){
            discount = costOfSandwich * 0.20;
            total = costOfSandwich - discount;
            System.out.printf("Your total for today with discount is $%.2f", total);
        }else{
            total = costOfSandwich;
            System.out.printf("Sorry no discount! here is your total $%.2f", total);
        }
        
    }
}
