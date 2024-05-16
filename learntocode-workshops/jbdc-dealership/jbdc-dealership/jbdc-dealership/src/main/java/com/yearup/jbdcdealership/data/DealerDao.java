package com.yearup.jbdcdealership.data;


import com.yearup.jbdcdealership.models.Vehicle;

import java.util.List;

public interface DealerDao {
    List<Vehicle> getByPrice(double minPrice, double maxPrice);
    List<Vehicle> getByMakeModel(String make, String model);
    List<Vehicle> getByYear(int year);
    List<Vehicle> getByColor(String color);
    List<Vehicle> getByMileage(int min, int max);
    List<Vehicle> getByType(String type);
    List<Vehicle> getAllVehicles();
    Vehicle getByVin(String vin);
    void create(Vehicle vehicle);
    void update(String vin,Vehicle vehicle );
    boolean delete(String vin);
    void sellCar(String vin);
    void leaseCar(String vin);
    List<Vehicle> getAllContracts();
    List<Vehicle> getAllSaleContracts();
    List<Vehicle> getAllLeaseContracts();
}
