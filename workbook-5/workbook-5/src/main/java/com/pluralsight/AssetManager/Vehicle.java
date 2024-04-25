package com.pluralsight.AssetManager;

import java.time.LocalDateTime;

public class Vehicle extends Asset{
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String descirption, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(descirption, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        int currentYear = java.time.LocalDate.now().getYear();
        int age = currentYear - year;

        // Calculate value based on age and mileage
        if (age <= 3) {
            // 0-3 years old - 3% reduced value of cost per year
            return getOriginalCost() * Math.pow(0.97, age);
        } else if (age <= 6) {
            // 4-6 years old - 6% reduced value of cost per year
            return getOriginalCost() * Math.pow(0.94, age - 3);
        } else if (age <= 10) {
            // 7-10 years old - 8% reduced value of cost per year
            return getOriginalCost() * Math.pow(0.92, age - 6);
        } else {
            // over 10 years old - $1000.00
            double value = 1000.0;
            if (getOdometer() > 100000 && !(makeModel.contains("Honda") || makeModel.contains("Toyota"))) {
                // MINUS reduce final value by 25% if over 100,000 miles
                value *= 0.75;
            }
            return value;
        }
    }


}
