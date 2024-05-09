package com.pluralsight.sakilaMoviesWithClasses;

import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class SakilaApplication {
    public static void main(String[] args) {
        String username = args[0];
        String password = args[1];
        Scanner scanner = new Scanner(System.in);

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        System.out.println("Please Enter the Actor info to search movies they are in!");
        System.out.print("Actor First Name: ");
        String firstName = scanner.nextLine().trim();
        System.out.print("Actor Last Name: ");
        String lastName = scanner.nextLine().trim();

        SakilaDataManager dataManager = new SakilaDataManager(dataSource);
        List<Actor> actors = dataManager.getActors(firstName, lastName);


        System.out.print("Please Enter Actor ID to search films: ");
        String actorID = scanner.nextLine().trim();

        System.out.print("-------------------");
        List<Film> films = dataManager.getFilms(actorID);

        System.out.println("\n ITEMS IN ARRAYLIST \n");
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\nACTORS");
        actors.forEach(System.out::println);
        System.out.println();
        System.out.println("\nFILMS");
        films.forEach(System.out::println);
        System.out.println(films.size());
    }
}
