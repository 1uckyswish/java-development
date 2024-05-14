package com.yearup.jbdcdealership.data;


import com.yearup.jbdcdealership.models.Vehicle;
import com.yearup.jbdcdealership.utilityMethods.VehicleUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DatabaseDealerDao implements DealerDao {
    private DataSource dataSource;

    public DatabaseDealerDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Vehicle> getByPrice(double minPrice, double maxPrice) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicle WHERE price BETWEEN ? AND ?;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setDouble(1, minPrice);
            preparedStatement.setDouble(2, maxPrice);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    do {
                        Vehicle vehicle = VehicleUtils.resultSetToVehicle(resultSet);
                        // Add the Vehicle object to the list
                        vehicles.add(vehicle);
                    } while (resultSet.next());
                } else {
                    System.out.println("sorry no vehicles found between the price of " + minPrice + " and " + maxPrice);
                }
            } catch (Exception e) {
                System.err.println("Error retrieving data from table: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Error retrieving data from table: " + e.getMessage());
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> getByMakeModel(String make, String model) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicle WHERE make = ? AND model = ?;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setString(1, make);
            preparedStatement.setString(2, model);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    do {
                        Vehicle vehicle = VehicleUtils.resultSetToVehicle(resultSet);
                        // Add the Vehicle object to the list
                        vehicles.add(vehicle);
                    } while (resultSet.next());
                } else {
                    System.out.println("sorry no vehicle with the make of " + make + " and model of " + model);
                }
            } catch (Exception e) {
                System.err.println("Error retrieving data from table: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Error retrieving data from table: " + e.getMessage());
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> getByYear(int year) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicle WHERE year = ?;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setInt(1, year);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    do {
                        Vehicle vehicle = VehicleUtils.resultSetToVehicle(resultSet);
                        // Add the Vehicle object to the list
                        vehicles.add(vehicle);
                    } while (resultSet.next());
                } else {
                    System.out.println("sorry no vehicle with the year of " + year);
                }
            } catch (Exception e) {
                System.err.println("Error retrieving data from table: " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Error retrieving data from table: " + e.getMessage());
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> getByColor(String carColor) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicle WHERE color = ?;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setString(1, carColor);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    do {
                        Vehicle vehicle = VehicleUtils.resultSetToVehicle(resultSet);
                        // Add the Vehicle object to the list
                        vehicles.add(vehicle);
                    } while (resultSet.next());
                } else {
                    System.out.println("sorry no vehicle with the color of " + carColor);
                }
            } catch (Exception e) {
                System.err.println("Error retrieving data from table: " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Error retrieving data from table: " + e.getMessage());
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> getByMileage(int min, int max) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicle WHERE odometer BETWEEN ? AND ?;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setInt(1, min);
            preparedStatement.setInt(2, max);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    do {
                        Vehicle vehicle = VehicleUtils.resultSetToVehicle(resultSet);
                        // Add the Vehicle object to the list
                        vehicles.add(vehicle);
                    } while (resultSet.next());
                } else {
                    System.out.println("sorry no vehicles found with the odometer reading between " + min + " and " + max);
                }
            } catch (Exception e) {
                System.err.println("Error retrieving data from table: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Error retrieving data from table: " + e.getMessage());
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> getByType(String carType) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicle WHERE type = ?;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setString(1, carType);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    do {
                        Vehicle vehicle = VehicleUtils.resultSetToVehicle(resultSet);

                        // Add the Vehicle object to the list
                        vehicles.add(vehicle);
                    } while (resultSet.next());
                } else {
                    System.out.println("sorry no vehicle with the type of " + carType);
                }
            } catch (Exception e) {
                System.err.println("Error retrieving data from table: " + e.getMessage());
            }


        } catch (Exception e) {
            System.err.println("Error retrieving data from table: " + e.getMessage());
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicle;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                Vehicle vehicle = VehicleUtils.resultSetToVehicle(resultSet);

                // Add the Vehicle object to the list
                vehicles.add(vehicle);
            }

        } catch (Exception e) {
            System.err.println("Error retrieving data from table: " + e.getMessage());
        }
        return vehicles;
    }

    @Override
    public Vehicle getByVin(String vin) {
        Vehicle vehicle = null;
        String sqlQuery = "SELECT * FROM vehicle WHERE vin = ?;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setInt(1, Integer.parseInt(vin));
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    do {
                        vehicle = VehicleUtils.resultSetToVehicle(resultSet);
                    } while (resultSet.next());
                } else {
                    System.out.println("sorry no vehicle with the VIN of " + vin);
                }
            } catch (Exception e) {
                System.err.println("Error retrieving data from table: " + e.getMessage());
            }


        } catch (Exception e) {
            System.err.println("Error retrieving data from table: " + e.getMessage());
        }
        return vehicle;
    }

    @Override
    public void create(Vehicle vehicle) {
        String sqlQuery = "INSERT INTO vehicle (vin, year, make, model, type, color, odometer, price, sold) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setString(1, vehicle.getVin());
            preparedStatement.setInt(2, vehicle.getYear());
            preparedStatement.setString(3, vehicle.getMake());
            preparedStatement.setString(4, vehicle.getModel());
            preparedStatement.setString(5, vehicle.getType());
            preparedStatement.setString(6, vehicle.getColor());
            preparedStatement.setInt(7, vehicle.getOdometer());
            preparedStatement.setDouble(8, vehicle.getPrice());
            preparedStatement.setString(9, vehicle.getSold());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("Vehicle inserted successfully.");
            } else {
                System.err.println("Error: Failed to insert vehicle.");
            }

        } catch (Exception e) {
            System.err.println("Error inserting vehicle: " + e.getMessage());
        }
    }

    @Override
    public void update(String vin, Vehicle vehicle) {
        String sqlQuery = "UPDATE vehicle SET year = ?, make = ?, model = ?, type = ?, color = ?, odometer = ?, price = ?, sold = ? " +
                "WHERE vin = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, vehicle.getYear());
            preparedStatement.setString(2, vehicle.getMake());
            preparedStatement.setString(3, vehicle.getModel());
            preparedStatement.setString(4, vehicle.getType());
            preparedStatement.setString(5, vehicle.getColor());
            preparedStatement.setInt(6, vehicle.getOdometer());
            preparedStatement.setDouble(7, vehicle.getPrice());
            preparedStatement.setString(8, vehicle.getSold());
            preparedStatement.setString(9, vin);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("Vehicle updated successfully.");
            } else {
                System.err.println("Error: Failed to update vehicle. Vehicle with VIN " + vin + " not found.");
            }
        } catch (Exception e) {
            System.err.println("Error updating vehicle: " + e.getMessage());
        }
    }


    @Override
    public boolean delete(String vin) {
        try (Connection connection = dataSource.getConnection()) {
            // Check if there are associated records in the inventory table
            String checkInventoryQuery = "SELECT COUNT(*) FROM inventory WHERE vin = ?";
            try (PreparedStatement checkInventoryStatement = connection.prepareStatement(checkInventoryQuery)) {
                checkInventoryStatement.setString(1, vin);
                try (ResultSet resultSet = checkInventoryStatement.executeQuery()) {
                    resultSet.next();
                    int count = resultSet.getInt(1);
                    if (count > 0) {
                        // There are associated records in the inventory table, delete them first
                        String deleteInventoryQuery = "DELETE FROM inventory WHERE vin = ?";
                        try (PreparedStatement deleteInventoryStatement = connection.prepareStatement(deleteInventoryQuery)) {
                            deleteInventoryStatement.setString(1, vin);
                            deleteInventoryStatement.executeUpdate();
                        }
                    }
                }
            }

            // Check if there are associated records in the lease_contracts table
            String checkLeaseContractsQuery = "SELECT COUNT(*) FROM lease_contracts WHERE vin = ?";
            try (PreparedStatement checkLeaseContractsStatement = connection.prepareStatement(checkLeaseContractsQuery)) {
                checkLeaseContractsStatement.setString(1, vin);
                try (ResultSet resultSet = checkLeaseContractsStatement.executeQuery()) {
                    resultSet.next();
                    int count = resultSet.getInt(1);
                    if (count > 0) {
                        // There are associated records in the lease_contracts table, delete them first
                        String deleteLeaseContractsQuery = "DELETE FROM lease_contracts WHERE vin = ?";
                        try (PreparedStatement deleteLeaseContractsStatement = connection.prepareStatement(deleteLeaseContractsQuery)) {
                            deleteLeaseContractsStatement.setString(1, vin);
                            deleteLeaseContractsStatement.executeUpdate();
                        }
                    }
                }
            }

            // Check if there are associated records in the sales_contract table
            String checkSalesContractQuery = "SELECT COUNT(*) FROM sales_contracts WHERE vin = ?";
            try (PreparedStatement checkSalesContractStatement = connection.prepareStatement(checkSalesContractQuery)) {
                checkSalesContractStatement.setString(1, vin);
                try (ResultSet resultSet = checkSalesContractStatement.executeQuery()) {
                    resultSet.next();
                    int count = resultSet.getInt(1);
                    if (count > 0) {
                        // There are associated records in the sales_contract table, delete them first
                        String deleteSalesContractQuery = "DELETE FROM sales_contracts WHERE vin = ?";
                        try (PreparedStatement deleteSalesContractStatement = connection.prepareStatement(deleteSalesContractQuery)) {
                            deleteSalesContractStatement.setString(1, vin);
                            deleteSalesContractStatement.executeUpdate();
                        }
                    }
                }
            }

            // Continue with the rest of the delete operation as before
            // Delete the vehicle from the vehicle table
            String deleteVehicleQuery = "DELETE FROM vehicle WHERE vin = ?";
            try (PreparedStatement deleteVehicleStatement = connection.prepareStatement(deleteVehicleQuery)) {
                deleteVehicleStatement.setString(1, vin);
                int rowsAffected = deleteVehicleStatement.executeUpdate();
                if (rowsAffected == 1) {
                    System.out.println("Vehicle with VIN " + vin + " deleted successfully.");
                    return true; // Return true indicating successful deletion
                } else {
                    System.err.println("Error: Failed to delete vehicle. Vehicle with VIN " + vin + " not found.");
                    return false; // Return false indicating failure to delete (vehicle not found)
                }
            }
        } catch (Exception e) {
            System.err.println("Error deleting vehicle: " + e.getMessage());
            return false; // Return false indicating failure to delete (due to exception)
        }
    }

    @Override
    public void sellCar(String vin) {
        try (Connection connection = dataSource.getConnection()) {
            // Update the vehicle table to mark the car as sold
            String updateSql = "UPDATE vehicle SET sold = 'Yes' WHERE vin = ?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
                updateStatement.setString(1, vin);
                int updateRowsAffected = updateStatement.executeUpdate();
                if (updateRowsAffected == 1) {
                    System.out.println("Vehicle Sold successfully.");
                } else {
                    System.err.println("Error: Failed to sell vehicle. Vehicle with VIN " + vin + " not found.");
                    return;
                }
            }

            // Insert the VIN into the sales_contract table
            String insertSql = "INSERT INTO sales_contracts (vin) VALUES (?)";
            try (PreparedStatement insertStatement = connection.prepareStatement(insertSql)) {
                insertStatement.setString(1, vin);
                int insertRowsAffected = insertStatement.executeUpdate();
                if (insertRowsAffected == 1) {
                    System.out.println("Vehicle VIN inserted into sales contract successfully.");
                } else {
                    System.err.println("Error: Failed to insert vehicle VIN into sales contract.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error selling vehicle: " + e.getMessage());
        }
    }

    @Override
    public void leaseCar(String vin) {
        try (Connection connection = dataSource.getConnection()) {
            // Update the vehicle table to mark the car as sold
            String updateSql = "UPDATE vehicle SET sold = 'No' WHERE vin = ?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
                updateStatement.setString(1, vin);
                int updateRowsAffected = updateStatement.executeUpdate();
                if (updateRowsAffected == 1) {
                    System.out.println("Vehicle leased successfully.");
                } else {
                    System.err.println("Error: Failed to lease vehicle. Vehicle with VIN " + vin + " not found.");
                    return;
                }
            }

            // Insert the VIN into the sales_contract table
            String insertSql = "INSERT INTO lease_contracts (vin) VALUES (?)";
            try (PreparedStatement insertStatement = connection.prepareStatement(insertSql)) {
                insertStatement.setString(1, vin);
                int insertRowsAffected = insertStatement.executeUpdate();
                if (insertRowsAffected == 1) {
                    System.out.println("Vehicle VIN inserted into sales contract successfully.");
                } else {
                    System.err.println("Error: Failed to insert vehicle VIN into sales contract.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error selling vehicle: " + e.getMessage());
        }
    }


    @Override
    public List<Vehicle> getAllSaleContracts() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT V.* FROM dealership.vehicle AS V JOIN dealership.sales_contracts AS S ON V.vin = S.vin;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                Vehicle vehicle = VehicleUtils.resultSetToVehicle(resultSet);

                // Add the Vehicle object to the list
                vehicles.add(vehicle);
            }

        } catch (Exception e) {
            System.err.println("Error retrieving data from table: " + e.getMessage());
        }
        return vehicles;
    }

    @Override
    public  List<Vehicle> getAllLeaseContracts(){
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT V.* FROM vehicle AS V JOIN lease_contracts AS L ON V.vin = L.vin;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                Vehicle vehicle = VehicleUtils.resultSetToVehicle(resultSet);

                // Add the Vehicle object to the list
                vehicles.add(vehicle);
            }

        } catch (Exception e) {
            System.err.println("Error retrieving data from table: " + e.getMessage());
        }
        return vehicles;
    }

@Override
    public List<Vehicle> getAllContracts(){
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.addAll(getAllLeaseContracts());
        vehicles.addAll(getAllSaleContracts());
        return vehicles;
    }



}

