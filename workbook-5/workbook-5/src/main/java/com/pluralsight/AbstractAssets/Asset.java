package com.pluralsight.AssetManager;

public class Asset {
    private String descirption;
    private String dateAcquired;
    private double originalCost;

    public Asset(String descirption, String dateAcquired, double originalCost) {
        this.descirption = descirption;
        this.dateAcquired = dateAcquired;
        this.originalCost = originalCost;
    }

    public String getDescirption() {
        return descirption;
    }

    public void setDescirption(String descirption) {
        this.descirption = descirption;
    }

    public String getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(String dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public double getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(double originalCost) {
        this.originalCost = originalCost;
    }

    public double getValue(){
        return originalCost;
    }
}
