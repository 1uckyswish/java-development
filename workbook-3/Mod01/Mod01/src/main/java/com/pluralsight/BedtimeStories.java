package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {
        startBedTime();
    }

    public static void startBedTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose a bedtime story:");
        System.out.println("1. goldilocks.txt");
        System.out.println("2. hansel_and_gretel.txt");
        System.out.println("3. mary_had_a_little_lamb.txt");
        System.out.print("Enter the name of your choice: ");
        String bookName = scanner.nextLine();
        System.out.println();
        readBook(bookName);
        scanner.close();
    }

    public static void readBook(String bookName) {
        try{
            FileInputStream file = new FileInputStream(bookName);
            Scanner scanner = new Scanner(file);
            String fileLine;
            int numberOfLine = 0;
            while(scanner.hasNextLine()){
                fileLine = scanner.nextLine();
                numberOfLine++;
                Thread.sleep(1000);
                System.out.printf("%d.   %s\n", numberOfLine, fileLine);
            }
            scanner.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            startBedTime();
        }
    }
}
