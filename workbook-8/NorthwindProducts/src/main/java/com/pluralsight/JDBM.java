package com.pluralsight;

import java.sql.*;

public class JDBM {
    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/northwind",
                    "root",
                    "password"
            );

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Products");

            while(resultSet.next()){
                System.out.println(resultSet.getString("ProductID"));
                System.out.println(resultSet.getString("ProductName"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
