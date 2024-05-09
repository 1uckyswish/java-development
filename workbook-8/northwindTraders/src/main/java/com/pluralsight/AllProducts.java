package com.pluralsight;

import java.sql.*;
import java.util.Scanner;

public class AllProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What do you want to do?\n" +
                "1) Display all products\n" +
                "2) Display all customers\n" +
                "0) Exit\n" +
                "Select an option: ");
        String choice = scanner.nextLine().trim();
        System.out.println();
        switch (choice){
            case "1": getAllProducts(args);break;
            case "2": getAllCustomers(args);break;
            case "0":
                System.exit(0);
            default:
                System.out.println("Sorry select option 1), 2) or 0)");
                main(args);
        }
    }


    public static void getAllCustomers(String[] args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/northwind",
                    args[0],
                    args[1]
            );
            String query = "SELECT * FROM Customers ORDER BY ?";
            preparedStatement = connection.prepareStatement(query);
           // if we need to set params for a query with ? index based
            preparedStatement.setString(1, "Country");
            resultSet = preparedStatement.executeQuery();
            System.out.print("CompanyName  ");
            System.out.print("ContactName  ");
            System.out.print("City  ");
            System.out.print("Country  ");
            System.out.print("Number  \n");
            System.out.println("-------------------------");
            while (resultSet.next()) {
                System.out.print(resultSet.getString("CompanyName") + "   ");
                System.out.print(resultSet.getString("ContactName") + "  ");
                System.out.print(resultSet.getString("City") + "  ");
                System.out.print(resultSet.getString("Country") + "  ");
                System.out.print(resultSet.getString("Phone") + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    public static void getAllProducts(String[] args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/northwind",
                    args[0],
                    args[1]
            );
            String query = "SELECT * FROM Products";
            preparedStatement = connection.prepareStatement(query);
            //preparedStatement.setString(1, "Sa%"); if we need to set params for query with ? index based
            resultSet = preparedStatement.executeQuery();
            System.out.print("ID  ");
            System.out.print("Name  ");
            System.out.print("Price  ");
            System.out.print("Stock  \n");
            System.out.println("-------------------------");
            while (resultSet.next()) {
                System.out.print(resultSet.getString("ProductID") + "   ");
                System.out.print(resultSet.getString("ProductName") + "  ");
                System.out.print(resultSet.getString("UnitPrice") + "  ");
                System.out.print(resultSet.getString("UnitsinStock") + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
