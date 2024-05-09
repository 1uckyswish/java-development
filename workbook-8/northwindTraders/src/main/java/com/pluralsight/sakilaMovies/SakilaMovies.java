package com.pluralsight.sakilaMovies;

import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Scanner;

public class SakilaMovies {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Application needs two arguments to run: java com.hca.jdbc.UsingDriverManager <username> <password>");
            System.exit(1);
        }
        String username = args[0];
        String password = args[1];

    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    displayMoviesAndActor(dataSource);
    }

    public static void displayMoviesAndActor(BasicDataSource dataSource){
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT first_name, last_name FROM actor;");
        ){
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                System.out.println("\t\tActor Names");
                System.out.printf("%-12s | %-12s\n", "First Name", "Last Name"); // Header with labels
                System.out.println("--------------------------------");
                while(resultSet.next()){
                    System.out.printf(
                            "%-12s | %-12s\n", // Format string with labels
                            resultSet.getString(1), resultSet.getString(2)
                    );
                }

                System.out.println("Please Enter the Actor info to search movies they are in!");
                System.out.print("Actor First Name: ");
                String firstName = scanner.nextLine().trim();
                System.out.print("Actor Last Name: ");
                String lastName = scanner.nextLine().trim();
                displayMoviesByQuery(dataSource, firstName, lastName);

            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void displayMoviesByQuery(BasicDataSource dataSource, String firstName, String lastName){
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT F.title FROM sakila.actor AS A\n" +
                    "JOIN\n" +
                    "\tfilm_actor AS FA\n" +
                    "ON\n" +
                    "\tA.actor_id = FA.actor_id\n" +
                    "JOIN \n" +
                    "\tfilm AS F\n" +
                    "ON\n" +
                    "\tFA.film_id = F.film_id\n" +
                    "WHERE A.first_name = ? AND A.last_name = ?;");
        ){
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                System.out.println("Movies Actor is in");
                System.out.printf("%-12s\n", "Movie Title"); // Header with labels
                System.out.println("--------------------------------");

                if(resultSet.next()){
                    System.out.println("~~~Your matches are~~~\n");
                    do{
                        System.out.printf(
                                "%-12s\n", // Format string with labels
                                resultSet.getString(1));
                    }while (resultSet.next());
                }
                else{
                    System.out.println("No Matches Found");
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
