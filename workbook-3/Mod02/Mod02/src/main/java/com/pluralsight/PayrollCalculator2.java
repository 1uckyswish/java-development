package com.pluralsight;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PayrollCalculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file employee file to process: ");
        String processFile = scanner.nextLine().trim();
        System.out.println();
        System.out.print("Enter the name of the payroll file to create: ");
        String fileToCreate = scanner.nextLine().trim();
        writeToUserFile(processFile, fileToCreate);
    }

    public static void writeToUserFile(String processFile, String fileToCreate) {
        try{
            FileInputStream fileStream = new FileInputStream(processFile);
            Scanner scanner = new Scanner(fileStream);
            String input;
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            while (scanner.hasNextLine()){
                input = scanner.nextLine();
                String[] values = input.split(Pattern.quote("|"));
                createFile(values, fileToCreate);
            }
            scanner.close();
        }catch (Exception e){

        }
    }

    public static void createFile(String[] values, String fileToCreate){
//        Scanner scanner = new Scanner();
        try{
            if(fileToCreate.contains(".json")){
                createJSON(values, fileToCreate);
                return;
            }
            File file = new File(fileToCreate);
            if (!file.exists()) {
                file.createNewFile();
                writeHeader(fileToCreate);
            }
            FileWriter fileWriter = new FileWriter(file, true); // append mode
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            String text = String.format("%s|%s|%s\n", values[0], values[1], values[2]); // appending newline
            bufWriter.write(text);
            bufWriter.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void createJSON(String[] values, String fileToCreate){
        try {
            File file = new File(fileToCreate);
            boolean fileExists = file.exists();
            FileWriter fileWriter = new FileWriter(file, true); // append mode
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            // Formatting values into JSON-like format
            String json = String.format("{ \"id\": %s, \"name\": \"%s\", \"grossPay\": %.2f }",
                    values[0], values[1], Double.parseDouble(values[2]));
            bufWriter.write(json);
            // Add a comma and newline to separate JSON objects
            bufWriter.write(",\n");
            bufWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeHeader(String fileToCreate) {
        try {
            FileWriter fileWriter = new FileWriter(fileToCreate, true); // append mode
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            bufWriter.write("id|name|gross pay\n"); // Write the header
            bufWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
