package com.pluralsight;

import java.util.Random;
import java.util.Scanner;

public class FamousQuotes {
    // Add 10 favorite quotes to the array
    private static String[] quotes = new String[10];
    public static void main(String[] args) {
        populateQuotes();
        Scanner scanner = new Scanner(System.in);
        promptUser(scanner);

    }

    public static void promptUser(Scanner scanner){
        try{
            System.out.println("Choice a number between 1 - 10");
            System.out.print("To Generate a quote for the day: ");
            int rangeNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            System.out.println(quotes[rangeNumber - 1]);
            askUserForLoop(scanner);
        }catch (Exception e){
            System.out.println("Your number is out of range\n");
            promptUser(scanner);
        }
    }

    public static void askUserForLoop(Scanner scanner){
        System.out.print("Would you like to generate another quote? (yes/no): ");
        String userChoice = scanner.nextLine().toLowerCase();
        switch (userChoice){
            case "yes" : switchGenerate(scanner);break;
            case "no" :
                System.out.println("Thank you have a nice day!...");
                break;
        }
    }

    public static void switchGenerate(Scanner scanner){
        System.out.println("What type of Quote generation would you like?");
        System.out.println("(1): Random Quote generation");
        System.out.println("(2) Numbered Quote Generation");
        System.out.print("Choose your command: ");
        String userChoice = scanner.nextLine().toLowerCase();
        System.out.println();
        switch (userChoice){
            case "1": randomGenerate(scanner); break;
            case "2": promptUser(scanner); break;
            default:
                System.out.println("Sorry that option doesn't exist");
                switchGenerate(scanner);
        }
    }

    public static void randomGenerate(Scanner scanner){
        int randomIndex = (int) (Math.random() * 10 + 1);
        System.out.println(quotes[randomIndex]);
        askUserForLoop(scanner);
    }

    public static void populateQuotes(){
        quotes[0] = "\"The only way to do great work is to love what you do.\" - Steve Jobs\n";
        quotes[1] = "\"In the end, it's not the years in your life that count. It's the life in your years.\" - Abraham Lincoln\n";
        quotes[2] = "\"Believe you can and you're halfway there.\" - Theodore Roosevelt\n";
        quotes[3] = "\"It does not matter how slowly you go as long as you do not stop.\" - Confucius\n";
        quotes[4] = "\"Strive not to be a success, but rather to be of value.\" - Albert Einstein\n";
        quotes[5] = "\"The future belongs to those who believe in the beauty of their dreams.\" - Eleanor Roosevelt\n";
        quotes[6] = "\"Success is not final, failure is not fatal: It is the courage to continue that counts.\" - Winston Churchill\n";
        quotes[7] = "\"The only limit to our realization of tomorrow will be our doubts of today.\" - Franklin D. Roosevelt\n";
        quotes[8] = "\"In three words I can sum up everything I've learned about life: it goes on.\" - Robert Frost\n";
        quotes[9] = "\"You miss 100% of the shots you don't take.\" - Wayne Gretzky\n";

    }
}
