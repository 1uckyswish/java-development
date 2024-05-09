package com.pluralsight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AllProducts {
    public static void main(String[] args) {
       try{
           Connection connection = DriverManager.getConnection(
            "jdbc:mysql://127.0.0.1:3306/northwind",
                   "root",
                   "password"
           );
        String query = "SELECT * FROM Products";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
           System.out.print("ID  ");
           System.out.print("Name  ");
           System.out.print("Price  ");
           System.out.print("Stock  \n");
           System.out.println("-------------------------");
        while(resultSet.next()){
            System.out.print(resultSet.getString("ProductID") + "   ");
            System.out.print(resultSet.getString("ProductName") + "  ");
            System.out.print(resultSet.getString("UnitPrice") + "  ");
            System.out.print(resultSet.getString("UnitsinStock") + "\n");
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
       }catch (Exception e){
           e.printStackTrace();
       }

    }
}
