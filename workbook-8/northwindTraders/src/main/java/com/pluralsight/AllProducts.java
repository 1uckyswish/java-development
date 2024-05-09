package com.pluralsight;

import java.sql.*;

public class AllProducts {
    public static void main(String[] args) {
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
