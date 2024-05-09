package com.pluralsight.sakilaMoviesWithClasses;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SakilaDataManager {
    private DataSource dataSource;

    public SakilaDataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Actor> getActors(String firstName, String lastName){
        List<Actor> actors = new ArrayList<>();
        String sql = "SELECT actor_id, first_name, last_name FROM sakila.actor WHERE first_name = ? AND last_name = ?;";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);)
        {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    System.out.println("\t\tActor Information");
                    System.out.printf("%-8s | %-12s | %-12s\n", "Actor ID", "First Name", "Last Name"); // Header with labels
                    System.out.println("---------------------------------------------");
                    do{
                        String id = resultSet.getString("actor_id");
                        String first = resultSet.getString("first_name");
                        String last = resultSet.getString("last_name");
                        System.out.printf("%-8s | %-12s | %-12s\n",id, first, last);
                        Actor actor = new Actor(id, first, last);
                        actors.add(actor);

                        //
                    }while (resultSet.next());
//                    Scanner scanner = new Scanner(System.in);
//                    System.out.print("Please Enter Actor ID to search films: ");
//                    String actorID = scanner.nextLine().trim();
//                    getFilms(actorID);
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
        return actors;
    }



    public List<Film> getFilms(String actorID){
        List<Film> films = new ArrayList<>();
        String sql = "SELECT F.* \n" +
                "FROM sakila.actor AS A\n" +
                "JOIN film_actor AS FA ON A.actor_id = FA.actor_id\n" +
                "JOIN film AS F ON FA.film_id = F.film_id\n" +
                "WHERE A.actor_id = ?;";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            preparedStatement.setString(1, actorID);
            try(ResultSet resultSet = preparedStatement.executeQuery();){
                if(resultSet.next()){
                    System.out.printf("\n%s | %s | %s | %s | %s\n", "Film ID", "Title", "Description", "Release Year", "Length");
                    do{
                       String filmId = resultSet.getString(1);
                       String title = resultSet.getString(2);
                       String description = resultSet.getString(3);
                       String releaseYear = resultSet.getString(4);
                       String length = resultSet.getString(9);
                        System.out.printf("%-8s | %-40s | %-50s | %-12s | %-6s\n", filmId, title, description, releaseYear, length);

                        Film film = new Film(filmId, title, description, releaseYear, length);
                        films.add(film);
                    }while (resultSet.next());
                }else{
                    System.out.println("No Matches Found");
                }
            }catch (Exception e){

            }
        }catch (Exception e){

        }


        return films;
    }
}
