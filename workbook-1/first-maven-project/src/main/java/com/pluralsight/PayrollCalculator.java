package com.pluralsight;

import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello and welcome!");
        System.out.print("What is your name Fellow Traveler? ");
        String userName = scan.nextLine();
        System.out.print("How many hours have you worked? ");
        double hours = scan.nextDouble();
        System.out.print("Alright and how much would you like to get paid for your work " + userName + "? ");
        double hourlyPay = scan.nextDouble();
        scan.nextLine();
        double grossPay = (hours * hourlyPay);

        if(hours > 40){
            int amountOfOvertime = (int) hours - 40;
            double overtimePay = hourlyPay * 1.5;
            double overtimeEarnings = overtimePay * amountOfOvertime;
            double grossPayBeforeOvertime = 40 * hourlyPay;
            grossPayBeforeOvertime += overtimeEarnings;
            System.out.printf("Great job, %s! You've earned $%.2f this week, with %d hours of overtime.\n", userName, grossPayBeforeOvertime, amountOfOvertime);
        }else{
            System.out.printf("Impressive work, %s! Your earnings for this week are $%.2f.\n", userName, grossPay);
        }
        System.out.printf("Congratulations, %s! You've worked %.2f hours this week! Your commitment is inspiring! :)\n", userName, hours);
        scan.close();
    }
}
