package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class SearchEngineLogger {
    public static void main(String[] args) {
        System.out.println("Welcome to JavaBrowser");
        search();
    }

    public static void search() {
        try {
            //Make a new file
            BufferedWriter writer = new BufferedWriter(new FileWriter("logs.txt", true));
            //Write start of program
            writer.write(getDate() + " Launch" );
            writer.newLine();
            //Start scanner outside of loop
            Scanner scanner = new Scanner(System.in);
            while (true) {
                //Prompt user
                System.out.print("Enter a search term (X to exit): ");
                String userInput = scanner.nextLine().trim();
                //Check if user wanst to exit out
                if(userInput.equalsIgnoreCase("X")){
                    writer.write(getDate() + " exit" );
                    writer.newLine();
                    System.out.println("Exiting...");
                    break;
                }
                //Else type to the file
                writer.write(getDate() + " search : " + userInput);
                writer.newLine(); // Add a newline character
            }
            // Close the writer and scanner
            writer.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error 404 error JavaBrowser is down at the moment");
        }
    }

    public static String getDate(){
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter myFormattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss", Locale.US);
        return myFormattedDate.format(date.atZone(ZoneId.systemDefault()));
    }

}
