package com.yearup.jbdcdealership;

import com.yearup.jbdcdealership.application.UserInterface;
import com.yearup.jbdcdealership.data.DatabaseConnector;
import com.yearup.jbdcdealership.data.DatabaseDealerDao;
import org.apache.commons.dbcp2.BasicDataSource;

public class Program {
    public static void main(String[] args) {
        String username = args[0];
        String password = args[1];

        BasicDataSource dataSource = DatabaseConnector.connect(username, password);
        DatabaseDealerDao dealerDao = new DatabaseDealerDao(dataSource);
        UserInterface program = new UserInterface(dealerDao);
        program.run();
    }
}
