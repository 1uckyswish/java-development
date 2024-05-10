package com.pluralsight.northwindShippers;

import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class northwindApplication {
    public static void main(String[] args) {
        String username = args[0];
        String password = args[1];
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        ShippersDao shippersDao = new ShippersDao(dataSource);
        shippersDao.insertNewShipperDataWithKeys();
        shippersDao.getAllShippers();
        shippersDao.updateShipperData();
        shippersDao.getAllShippers();
        shippersDao.deleteShipperData();
        shippersDao.getAllShippers();
    }


}
