package com.pluralsight;

import java.util.Scanner;

public class RentalCarCalculator {
    public static void main(String[] args) {
        startCarApplication();
    }

    public static String getPickUpDate(Scanner scanner){
        System.out.println("Welcome to Java Rental Motors");
        System.out.println("What day would fit best for you to pick up your rental");
        System.out.println("Here are the following dates available\n" +
                "  (A)Monday May 15th 2024\n" +
                "  (B)Tuesday May 16th 2024\n" +
                "  (C)Friday May 18th 2024\n" +
                "  (D)Sunday May 20th 2024");
        System.out.print("Choose a option from above: ");
        String option = scanner.nextLine().toUpperCase();
        switch(option){
            case "A" :
                return "Monday May 15th 2024";
            case "B":
                return "Tuesday May 16th 2024";
            case "C":
                return "Friday May 18th 2024";
            case "D":
                return "Sunday May 20th 2024";
            default:
                System.out.println("Sorry that option is not available. Try one of the options again.");
                return getPickUpDate(scanner);
        }
    }

    public static int getNumberOfDays(Scanner scanner){
        System.out.print("How many days would you like to rent the vehicle out? ");
        int days = scanner.nextInt();
        if(days <= 0){
            System.out.printf("Sorry please enter a day isn't %d. Please try again\n", days);
            return getNumberOfDays(scanner);
        }else{
            return days;
        }
    }

    public static boolean getTollTag(Scanner scanner){
        System.out.print("Would you like to add electronic toll tag for an extra $3.95 a day? (yes/no): ");
        String answer = scanner.next();
        if(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")){
            System.out.println("Sorry please try again. Type either (yes/no)");
            return getTollTag(scanner);
        }else{
            return answer.equalsIgnoreCase("yes");
        }
    }

    public static boolean getGPS(Scanner scanner){
        System.out.print("Would you like to add GPS feature to the rental for an extra $2.95 a day? (yes/no): ");
        String answer = scanner.next();
        if(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")){
            System.out.println("Sorry please try again. Type either (yes/no)");
            return getGPS(scanner);
        }else{
            return answer.equalsIgnoreCase("yes");
        }
    }

    public static boolean getRoadside(Scanner scanner){
        System.out.print("Would you like to add roadside assistance for the rental for an extra $3.95 a day? (yes/no): ");
        String answer = scanner.next();
        if(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")){
            System.out.println("Sorry please try again. Type either (yes/no)");
            return getGPS(scanner);
        }else{
            return answer.equalsIgnoreCase("yes");
        }
    }

    public static int getAge(Scanner scanner){
        System.out.println("What is your current age?");
    System.out.print("If your are under the age of 25 it is a 30% surcharge fee ");
        int age = scanner.nextInt();
        if(age <= 0){
            System.out.printf("Sorry, you need to be alive to drive and rent a car. Your age of %d isn't going to work out. Please try again.%n", age);
            return  getAge(scanner);
        }else{
            return age;
        }
    }

    public static void startCarApplication(){
        Scanner scanner = new Scanner(System.in);
        String pickUpDate = getPickUpDate(scanner);
        int numberOfDays = getNumberOfDays(scanner);
        boolean electronicTag = getTollTag(scanner);
        boolean gps = getGPS(scanner);
        boolean roadside = getRoadside(scanner);
        int age = getAge(scanner);
        calculateAndDisplay(pickUpDate, numberOfDays, electronicTag, gps, age, roadside);

    }

    public static void calculateAndDisplay(String pickUpDate, int numberOfDays, boolean electronicTag,  boolean gps, int age, boolean roadside){
        double dailyFee = 29.99 * numberOfDays;
        double tollFee = (electronicTag ? 3.95 : 0.00) * numberOfDays;
        double gpsFee = (gps ? 2.95 : 0.00) * numberOfDays;
        double roadsideFee = (roadside ? 3.95 : 0.00) * numberOfDays;
        double surcharge = 0.00;
        double optionsFee = tollFee + gpsFee + roadsideFee;
        double totalCost = dailyFee + optionsFee;
        if(age <= 25 && age > 0){
           surcharge = dailyFee * 0.30;
//            surcharge = totalCost * 0.30;
        }
        totalCost += surcharge;
        displayRentalCost(pickUpDate,dailyFee,optionsFee,surcharge,totalCost);
    }

    public static void displayRentalCost(String pickUpDate, double dailyFee, double optionsFee, double surcharge, double totalCost){
        // Display the summary of costs
        System.out.println("******** SUMMARY OF RENTAL ********" );
        System.out.printf("---Pick Up Date: %s\n", pickUpDate);
        System.out.printf("---Daily Fee: $%.2f\n", dailyFee);
        System.out.printf("---Options Fee: $%.2f\n", optionsFee);
        System.out.printf("---Surcharge: $%.2f\n", surcharge);
        System.out.println("******** TOTAL ********" );
        System.out.printf("---Total Cost: $%.2f\n", totalCost);
        System.out.println("******** THANK YOU FOR RENTING AT JAVA MOTORS ********" );
    }
}
