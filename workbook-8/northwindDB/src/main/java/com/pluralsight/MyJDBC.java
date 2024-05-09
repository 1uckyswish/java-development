package com.pluralsight;

import java.sql.*;

public class MyJDBC {
    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/northwind",
                    "root",
                    "password"
            );

            String productName = "Ikura";
            String query = "SELECT * FROM Products " + "WHERE ProductName = \'Chang\'";

             PreparedStatement statement = connection.prepareStatement(query);
//             statement.setString(1, productName);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                System.out.print("ID |" +resultSet.getString("ProductID")+ " | ");
                System.out.println("ProductName |" + resultSet.getString("ProductName"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
