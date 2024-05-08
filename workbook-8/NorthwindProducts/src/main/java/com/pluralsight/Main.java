package com.pluralsight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Load the MySQL driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Database connection parameters
        String url = "jdbc:mysql://127.0.0.1:3306/northwind";
        String username = "root";
        String password = "password";

        // Open a connection to the database
        Connection connection = DriverManager.getConnection(url, username, password);


        // Create statement
        Statement statement = connection.createStatement();

        // Define your query
        String query = "SELECT ProductName FROM Products";

        // Execute your query
        ResultSet resultSet = statement.executeQuery(query);

        // Process the results
        System.out.println("Products sold by Northwind:");
        while (resultSet.next()) {
            String productName = resultSet.getString("ProductName");
            System.out.println(productName);
        }

    }
}
