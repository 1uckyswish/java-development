package com.pluralsight.northwindProcedures;

import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class NorthwindProcedures {
    public static void main(String[] args) {
        String username = args[0];
        String password = args[1];
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        NorthwindDataManager northwindDataManager = new NorthwindDataManager(dataSource);

        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nWelcome admin");
            System.out.println("Select a procedure to view:");
            System.out.println("1) Customer order history");
            System.out.println("2) Sales by year");
            System.out.println("3) Sales by category");
            System.out.println("0) Exit");
            System.out.print("Please insert your option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    northwindDataManager.customerOrderHistory();
                    break;
                case "2":
                    northwindDataManager.salesByYear();
                    break;
                case "3":
                    northwindDataManager.salesByCategory();
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println("Please choose one of the options from above");
                    break;
            }
        }
        scanner.close(); // Close the scanner when done
    }
}
