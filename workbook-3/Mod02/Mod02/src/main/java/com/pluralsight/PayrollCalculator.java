package com.pluralsight;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PayrollCalculator {
    public static void main(String[] args) {
        //Run program
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file employee file to process: ");
        String processFile = scanner.nextLine().trim();
        System.out.println();
        System.out.print("Enter the name of the payroll file to create: ");
        String fileToCreate = scanner.nextLine().trim();
        readFile(processFile, fileToCreate);
    }

    public static void readFile(String processFile, String fileToCreate) {
        //Try to catch for file input reading
        try{
            //Instantiate a file reader stream
            FileInputStream file = new FileInputStream(processFile);
            //Pass the file to the scanner for it to read
            Scanner scanner = new Scanner(file);
            //Declare a variable for the scanner to read each line
            String input;
            //Skip the first line to remove the column fields
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            //loop through the CSV file
            while (scanner.hasNextLine()){
                input = scanner.nextLine();
                //Split each line based on the |
                String[] values = input.split(Pattern.quote("|"));
                //Pass the array of the current array to make a new object
                Employee employee = createEmployee(values);
                //After object is made then pass it to display the values of getters one by one.
                displayEmployeeDetails(employee);

                if(fileToCreate.endsWith(".json")){
                    createJSON(employee, fileToCreate);
                }else{
                    createCSV(employee, fileToCreate);
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void createCSV(Employee employee, String fileToCreate){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileToCreate, true));
            File file = new File(fileToCreate);
            if (file.length() == 0) {
                // Write the header only if the file is empty
                String text = "id|name|gross pay";
                writer.write(text);
                writer.newLine();
            }
            String formattedEmployee = String.format("%d|%s|%.2f", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
            writer.write(formattedEmployee);
            writer.newLine();
            writer.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static void createJSON(Employee employee, String fileToCreate){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileToCreate, true));
            File file = new File(fileToCreate);
            // If the file is empty, write the opening '['
//            if (file.length() == 0) {
//                writer.write("[");
//                writer.newLine();
//            }
            String formattedEmployee = String.format("{ \"id\": %d, \"name\": \"%s\", \"grossPay\": %.2f },",
                    employee.getEmployeeId(), employee.getName(), employee.getGrossPay());

            writer.write(formattedEmployee);
            writer.newLine();

            // Close the writer
            writer.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



    public static Employee createEmployee(String[] values) {
        //grab each value by its index. This never changes
        int employeeId = Integer.parseInt(values[0]);
        String name = values[1];
        double hoursWorked = Double.parseDouble(values[2]);
        double payRate = Double.parseDouble(values[3]);
        //Pass it to the constructor
        return new Employee(employeeId, name, hoursWorked, payRate);
    }

    public static void displayEmployeeDetails(Employee employee) {
        //Use the current object to use its setters
        System.out.printf("Employee ID: %d%n", employee.getEmployeeId());
        System.out.printf("Name: %s%n", employee.getName());
        System.out.printf("Gross Pay: %.2f%n", employee.getGrossPay());
        System.out.println(); // Empty line for separation
    }


}
