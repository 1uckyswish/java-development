package com.pluralsight;

import java.util.Scanner;

public class PayrollCalculator2 {
    static Scanner scan = new Scanner(System.in);
    static String userName = "";
    static double hours;
    static double hourlyPay;
    static double grossPay;

    public static void main(String[] args) {
        // Call the promptUser method to get user input
        promptUser();

        // Check if the user worked overtime
        if (hours > 40) {
            displayOverTime(userName, hours, hourlyPay);
            payBreakDown();
        } else {
            displayMessage(hours, hourlyPay);
            payBreakDown();
        }
        scan.close();
    }

    public static void displayOverTime(String userName, double hours, double hourlyPay) {
        int amountOfOvertime = (int) hours - 40;
        double overtimePay = hourlyPay * 1.5;
        double overtimeEarnings = overtimePay * amountOfOvertime;
        double grossPayBeforeOvertime = 40 * hourlyPay;
        grossPayBeforeOvertime += overtimeEarnings;
        grossPay = grossPayBeforeOvertime;
        System.out.printf("Great job, %s! You've earned $%.2f this week, with %d hours of overtime.\n", userName,
                grossPayBeforeOvertime, amountOfOvertime);
        System.out.printf("Congratulations, %s! You've worked %.2f hours this week! Your commitment is inspiring! :)\n",
                userName, hours);
    }

    public static void promptUser() {
        System.out.println("Hello and welcome!");
        System.out.print("What is your name Fellow Traveler? ");
        userName = scan.nextLine();
        System.out.print("How many hours have you worked? ");
        // Update the hours variable
        hours = scan.nextDouble();
        System.out.print("Alright and how much would you like to get paid for your work " + userName + "? ");
        // Update the hourlyPay variable
        hourlyPay = scan.nextDouble();
    }

    public static void displayMessage(double hours, double hourlyPay) {
        grossPay = hours * hourlyPay;
        System.out.printf("Impressive work, %s! Your earnings for this week are $%.2f.\n", userName, grossPay);
        System.out.printf("Congratulations, %s! You've worked %.2f hours this week! Your commitment is inspiring! :)\n",
                userName, hours);
    }

    public static void payBreakDown() {
        System.out.println("~ Payroll Summary ~");
        System.out.println("Name: " + userName);
        System.out.printf("Hours Worked: %.2f\n", hours);
        System.out.printf("Pay Rate: $%.2f\n", hourlyPay);
        System.out.printf("Total Pay: $%.2f\n", grossPay);
        System.out.println("Don't go spending that money all in one place now " + userName + " :) !");
    }
}
