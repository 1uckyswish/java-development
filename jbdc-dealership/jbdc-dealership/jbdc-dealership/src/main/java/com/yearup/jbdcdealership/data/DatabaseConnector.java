package com.yearup.jbdcdealership.data;

import org.apache.commons.dbcp2.BasicDataSource;

public class DatabaseConnector {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dealership";

    public static BasicDataSource connect(String username, String password) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
