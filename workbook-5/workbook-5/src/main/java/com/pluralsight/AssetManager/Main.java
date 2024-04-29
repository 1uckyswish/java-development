package com.pluralsight.AssetManager;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Asset> assetInventory = new ArrayList<>();
        House house1 = new House("Cozy Family Home", "2020-05-15", 250000.0, "123 Main St", 2, 2000, 5000);
        House house2 = new House("Spacious Villa", "2018-08-20", 500000.0, "456 Oak St", 1, 4000, 10000);
        Vehicle car1 = new Vehicle("Family Sedan", "2019-06-10", 30000.0, "Toyota Camry", 2018, 50000);
        Vehicle car2 = new Vehicle("Sporty Convertible", "2021-03-20", 45000.0, "BMW Z4", 2017, 30000);
        assetInventory.add(house1);
        assetInventory.add(house2);
        assetInventory.add(car1);
        assetInventory.add(car2);
        int counter = 1;
        for (int i = 0; i < assetInventory.size(); i++) {
            Asset asset = assetInventory.get(i);
            System.out.println("Asset " + counter);
            counter++;
            if(asset instanceof House){
                House house = (House) asset;
                System.out.println("House at " + house.getAddress());
            }else{
                Vehicle vehicle = (Vehicle) asset;
                System.out.println("Vehicle " + vehicle.getMakeModel());
            }
            System.out.println(asset.getDescirption());
            System.out.println(asset.getDateAcquired());
            System.out.printf("$%,.2f%n", asset.getOriginalCost());
            System.out.printf("$%,.2f%n", asset.getValue());
            System.out.println();
        }
    }
}
