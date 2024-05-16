package com.yearup.jbdcdealership.models;

public class Dealership {
    private String dealershipID;
    private String dealershipName;
    private String dealershipAddress;
    private String dealershipNumber;

    public Dealership(String dealershipID, String dealershipName, String dealershipAddress, String dealershipNumber) {
        this.dealershipID = dealershipID;
        this.dealershipName = dealershipName;
        this.dealershipAddress = dealershipAddress;
        this.dealershipNumber = dealershipNumber;
    }

    public String getDealershipID() {
        return dealershipID;
    }

    public void setDealershipID(String dealershipID) {
        this.dealershipID = dealershipID;
    }

    public String getDealershipName() {
        return dealershipName;
    }

    public void setDealershipName(String dealershipName) {
        this.dealershipName = dealershipName;
    }

    public String getDealershipAddress() {
        return dealershipAddress;
    }

    public void setDealershipAddress(String dealershipAddress) {
        this.dealershipAddress = dealershipAddress;
    }

    public String getDealershipNumber() {
        return dealershipNumber;
    }

    public void setDealershipNumber(String dealershipNumber) {
        this.dealershipNumber = dealershipNumber;
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "dealershipID='" + dealershipID + '\'' +
                ", dealershipName='" + dealershipName + '\'' +
                ", dealershipAddress='" + dealershipAddress + '\'' +
                ", dealershipNumber='" + dealershipNumber + '\'' +
                '}';
    }
}
