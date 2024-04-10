package com.pluralsight;

import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        //Scanner inserted
        Scanner scan = new Scanner(System.in);
        //Ask user for first option to store it in a variable
        System.out.print("Enter the first number: ");
        int firstInt = scan.nextInt();
        //Ask user for second option to store it in a variable
        System.out.print("Enter the second number: ");
        int secondInt = scan.nextInt();
        //Ask user for calculation
        System.out.println("Possible calculations:\n" +
                "(A)dd\n" +
                "(S)ubtract\n" +
                "(M)ultiply\n" +
                "(D)ivide");
        //Ask user for Calculation option to store it in a variable
        System.out.print("Please select an option: ");
        String option = scan.next();
        //No matter what user inserts it is no longer case-sensitive
        switch(option.toUpperCase()){
            case "A":
                System.out.println("Your total calculation is " + (firstInt + secondInt)); break;
            case "S" :
                System.out.println("Your total calculation is " + (firstInt - secondInt));break;
            case "M":
                System.out.println("Your total calculation is " + (firstInt * secondInt));break;
            case "D":
                System.out.println("Your total calculation is " + (firstInt / secondInt));break;
            default:
                System.out.println("Sorry Please type One of the options printed Above.");
        }
    }
}
