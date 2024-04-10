package com.pluralsight;

public class MathApp {
    public static void main(String[] args) {
        // first question
        int bobSalary = 2000;
        int garySalary = 5500;
        int highestSalary = Math.max(bobSalary, garySalary);
        System.out.println("The highest salary is ..." + highestSalary);
        //second question
        int carPrice = 30_000;
        int truckPrice = 55_000;
        int cheapestVehicle = Math.min(carPrice, truckPrice);
        System.out.println("The cheapest car is ..." + cheapestVehicle);
        // third question
        double area = (7.25 * 7.25) * Math.PI;
        System.out.println(String.format("%.2f", area));
        // forth question
        double squareRoot = Math.sqrt(5.0);
        System.out.println(String.format("%.2f", squareRoot));
        // fifth question
        double distance = Math.sqrt(Math.pow((85 - 5), 2) + Math.pow((50 - 10), 2));
        System.out.println(String.format("%.2f", distance));
        // sixth question
        double absoluteValue = Math.abs(-3.8);
        System.out.println(absoluteValue);
        // seventh question
        int randomNumber = (int)(Math.random() * 2);
        System.out.println(randomNumber);



    }
}

