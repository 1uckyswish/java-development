package com.pluralsight.northwindShippers;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ShippersDao {
    static Scanner scanner = new Scanner(System.in);
    private DataSource dataSource;

    public ShippersDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public void insertNewShipperDataWithKeys() {
        String sql = "INSERT INTO Shippers (CompanyName, Phone) VALUES (?, ?);";
        System.out.println("~~~ INSERTING INTO NEW SHIPPER ~~~");
        System.out.print("Please insert Shipper name: ");
        String shipperName = scanner.nextLine().trim();
        System.out.print("Please insert Shipper number: ");
        String shipperNumber = scanner.nextLine().trim();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            preparedStatement.setString(1, shipperName);
            preparedStatement.setString(2, shipperNumber);

            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println(rowsInserted + " row(s) inserted.");

            // Retrieve generated keys
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                while (generatedKeys.next()) {
                    int generatedShipperId = generatedKeys.getInt(1);
                    System.out.println("New shipper ID: " + generatedShipperId);
                }
            } catch (Exception e) {
                System.err.println("Error retrieving generated keys: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Error occurred while inserting shipper: " + e.getMessage());
        }
    }

    public void getAllShippers(){
        String sql = "SELECT * FROM Shippers";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while(resultSet.next()){
                int shipperId = resultSet.getInt(1);
                String companyName = resultSet.getString(2);
                String phone = resultSet.getString(3);
                System.out.println("ShipperID: " + shipperId + " CompanyName: " + companyName + " Phone: " + phone);
            }
        }catch (Exception e){
            System.err.println("Error retrieving data from Shippers table: " + e.getMessage());
        }
    }


    public void updateShipperData() {
        String sql = "UPDATE Shippers SET Phone = ? WHERE ShipperID = ?";
        System.out.println("~~~ UPDATING SHIPPER DATA ~~~");
        System.out.print("Please insert Shipper ID: ");
        int shipperID = scanner.nextInt(); // Parse as integer
        scanner.nextLine(); // Consume newline character
        System.out.print("Please insert new Shipper number: ");
        String shipperNumber = scanner.nextLine().trim();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, shipperNumber); // Set phone number as string
            preparedStatement.setInt(2, shipperID); // Set ShipperID as integer
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " row(s) Updated.");

        } catch (Exception e) {
            System.err.println("Error occurred while updating shipper: " + e.getMessage());
        }
    }


    public void deleteShipperData() {
        String sql = "DELETE FROM Shippers WHERE ShipperID = ?";
        System.out.println("~~~ DELETING SHIPPER DATA ~~~");
        System.out.print("Please insert Shipper ID: ");
        int shipperID = scanner.nextInt(); // Parse as integer
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, shipperID); // Set ShipperID as integer
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " row(s) Updated.");

        } catch (Exception e) {
            System.err.println("Error occurred while updating shipper: " + e.getMessage());
        }
    }

}
