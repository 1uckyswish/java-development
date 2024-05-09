package com.pluralsight.sakilaMovies;

import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;
import java.sql.*;

public class SakilaMovies {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Application needs two arguments to run: java com.hca.jdbc.UsingDriverManager <username> <password>");
            System.exit(1);
        }
        String username = args[0];
        String password = args[1];










    }
}
