package com.pluralsight;

import java.sql.*;
import java.util.Scanner;

public class AllProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What do you want to do?\n" +
                "1) Display all products\n" +
                "2) Display all customers\n" +
                "3) Display all categories\n" +
                "0) Exit\n" +
                "Select an option: ");
        String choice = scanner.nextLine().trim();
        System.out.println();
        switch (choice){
            case "1": getAllProducts(args);break;
            case "2": getAllCustomers(args);break;
            case "3": getAllCategoriesAndProducts(args);break;
            case "0":
                System.exit(0);
            default:
                System.out.println("Sorry select option 1), 2) or 0)");
                main(args);
        }
    }

    public static void getAllCategoriesAndProducts(String[] args) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/northwind",
                args[0],
                args[1]
        )) {
            String query = "SELECT * FROM Categories ORDER BY ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, "CategoryID");
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    System.out.print("CategoryId  ");
                    System.out.print("CategoryName  \n");
                    System.out.println("-------------------------");
                    while (resultSet.next()) {
                        System.out.print(resultSet.getString("CategoryID") + "           ");
                        System.out.print(resultSet.getString("CategoryName") + "\n");
                    }
                    System.out.print("Please insert a CategoryID to display all products (between 1 through 8): ");
                    Scanner scanner = new Scanner(System.in);
                    int categoryId = scanner.nextInt();

                    getAllProducts(args, String.valueOf(categoryId));
                    if (categoryId < 1 || categoryId > 8) {
                        System.out.println("Invalid CategoryID. Please insert a value between 1 through 8.");
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public static void getAllCustomers(String[] args){
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/northwind",
                args[0],
                args[1]
        )) {
            String query = "SELECT * FROM Customers ORDER BY ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, "Country");
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
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
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getAllProducts(String[] args){
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/northwind",
                args[0],
                args[1]
        )) {
            String query = "SELECT * FROM Products";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
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
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void getAllProducts(String[] args, String categoryId){
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/northwind",
                args[0],
                args[1]
        )) {
            String query = "SELECT * FROM Products WHERE CategoryID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, categoryId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    System.out.println("~~~~ SEARCHES FOR CategoryID OF " + categoryId);
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
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
