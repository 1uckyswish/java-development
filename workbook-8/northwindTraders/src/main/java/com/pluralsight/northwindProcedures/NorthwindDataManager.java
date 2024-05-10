package com.pluralsight.northwindProcedures;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class NorthwindDataManager {
    private DataSource dataSource;
    static Scanner scanner = new Scanner(System.in);

    public NorthwindDataManager(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public void getCustomers(){
        String sql = "SELECT CustomerID, CompanyName, ContactName FROM Customers;";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    do{
                        System.out.print("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
                        System.out.print("\n|CustomerID: " + resultSet.getString(1));
                        System.out.print("\n|CompanyName: " + resultSet.getString(2));
                        System.out.print("\n|ContactName: " + resultSet.getString(3));
                        System.out.print("\n|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
                        System.out.println("");
                    }while (resultSet.next());
                }else {
                    System.out.println("sorry no data found");
                }
            }

        }catch (Exception e){

        }
    }


    public void customerOrderHistory(){
        System.out.println("ALL CUSTOMERS INFORMATION");
        getCustomers();
        System.out.print("Please enter CustomerID: ");
        String customerID = scanner.nextLine().trim();
        String query = "{CALL CustOrderHist(?)};";
        try(Connection connection = dataSource.getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
        ){
            callableStatement.setString(1, customerID);
            try(ResultSet resultSet = callableStatement.executeQuery()){
                if(resultSet.next()){
                    do{
                        System.out.print("\nProductName: " + resultSet.getString(1));
                        System.out.print("\nTOTAL: " + resultSet.getString(2));
                        System.out.println();
                    }while (resultSet.next());
                }else {
                    System.out.println("sorry no data with the ID of" + customerID);
                }
            }catch (Exception e){
                System.err.println("Error retrieving data from table: " + e.getMessage());
            }

        }catch (Exception e){
            System.err.println("Error retrieving data from table: " + e.getMessage());
        }
    }

    public void salesByYear(){
        System.out.println("\nPlease enter date in this format: YYYY-MM-DD");
        System.out.print("\nPlease enter Start Date: ");
        String startDate = scanner.nextLine().trim();
        System.out.print("Please enter End Date: ");
        String endDate = scanner.nextLine().trim();
        String query = "{CALL `Sales by Year`(?, ?)}"; // Note the backticks around the stored procedure name
        try(Connection connection = dataSource.getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
        ){
            callableStatement.setString(1, startDate);
            callableStatement.setString(2, endDate);
            try(ResultSet resultSet = callableStatement.executeQuery()){
                if(resultSet.next()){
                    do{
                        System.out.print("\nShippedDate: " + resultSet.getString(1));
                        System.out.print("\nOrderID: " + resultSet.getString(2));
                        System.out.print("\nSubtotal: " + resultSet.getString(3));
                        System.out.print("\nYear: " + resultSet.getString(4));
                        System.out.println();
                    }while (resultSet.next());
                }else {
                    System.out.println("sorry no data with the start Date of " + startDate + "and end date of " + endDate);
                }
            }catch (Exception e){
                System.err.println("Error retrieving data from table: " + e.getMessage());
            }

        }catch (Exception e){
            System.err.println("Error retrieving data from table: " + e.getMessage());
        }
    }

    public void salesByCategory(){
        System.out.print("\nPlease enter Category Name (ex: Produce) : ");
        String categoryName = scanner.nextLine().trim();
        System.out.print("Please enter Order Year (ex: 1996) : ");
        String orderYear = scanner.nextLine().trim();
        String query = "{CALL SalesByCategory(? , ?)}";
        try(Connection connection = dataSource.getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
        ){
            callableStatement.setString(1, categoryName);
            callableStatement.setString(2, orderYear);
            try(ResultSet resultSet = callableStatement.executeQuery()){
                if(resultSet.next()){
                    do{
                        System.out.print("\nProductName: " + resultSet.getString(1));
                        System.out.printf("\nTotalPurchase: $%,.2f", resultSet.getDouble(2));
                        System.out.println();
                    }while (resultSet.next());
                }else {
                    System.out.println("sorry no data with the category of " + categoryName + "and order year of " + orderYear);
                }
            }catch (Exception e){
                System.err.println("Error retrieving data from table: " + e.getMessage());
            }

        }catch (Exception e){
            System.err.println("Error retrieving data from table: " + e.getMessage());
        }
    }

}
