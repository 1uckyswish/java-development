package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSourceJDBC {
    public static void main(String[] args) {
        String username = args[0];
        String password = args[1];

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/sakila");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(
                             "SELECT first_name, last_name FROM customer " +
                                     "WHERE last_name LIKE ? ORDER BY first_name");
        ) {
            preparedStatement.setString(1, "Sa%");
            try (ResultSet resultSet = preparedStatement.executeQuery()
            ) {
                while (resultSet.next()) {
                    System.out.printf("first_name = %s, last_name = %s;\n",
                            resultSet.getString(1), resultSet.getString(2));
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
