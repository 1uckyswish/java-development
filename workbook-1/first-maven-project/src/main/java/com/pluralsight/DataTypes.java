package com.pluralsight;

import java.util.Random;
import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
//        int id = 156_146_55;
//        String model = "Tesla";
//        String color = "Ruby Red";
//        boolean towingPackage = true;
//        int odometer = 55_899;
//        int price = 300_000;
//        char rating = 'A';
//        float phoneNumber = 980_242_7183f;
//        int social = 123_54_6697;
//        int zip = 28132;
//
//        int randomNumber = (int) (Math.random() * 5); // Generates either 0 or 1
//        System.out.println("Random number between 0 and 1: " + randomNumber);
//
//        Random rn = new Random();
//        int answer = rn.nextInt(10) + 1;
//        System.out.print("Hello ");
//        System.out.print("World!");

//        int id2 = 10135;
//        String name = "Brandon Plyers";
//        float pay = 5239.77f;
//        System.out.printf("%s  %d $%.2f", name, id2, pay);
//        int x = 5;
//        System.out.println(x++);

        float num = 2.2F;
        float result = (float) Math.pow(num, 2);
        System.out.println(result);
        double value = 1234.567;
        int wholeNumber = (int) Math.floor(value);
        System.out.println(wholeNumber);
        int wholeNumber2 = (int) Math.round(value);
        System.out.println(wholeNumber2);
    }
}
