package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CellPhone phone = new CellPhone();
        System.out.print("What is the serial number? ");
        phone.setSerialNumber(scanner.nextInt());
        scanner.nextLine();
        System.out.print("What model is the phone? ");
        phone.setModel(scanner.nextLine());
        System.out.print("Who is the carrier? ");
        phone.setCarrier(scanner.nextLine());
        System.out.print("What is the phone number? (888-555-1234)");
        phone.setPhoneNumber(scanner.nextLine());
        System.out.print("Who is the owner of the phone? ");
        phone.setOwner(scanner.nextLine());
        displayCellPhone(phone);
    }

    public static void displayCellPhone(CellPhone phone){
        System.out.println("\nPhone Information:");
        System.out.println("Serial Number: " + phone.getSerialNumber());
        System.out.println("Phone Model: " + phone.getModel());
        System.out.println("Carrier: " + phone.getCarrier());
        System.out.println("Phone Number: " + phone.getPhoneNumber());
        System.out.println("Owner: " + phone.getOwner());
    }
}

class CellPhone{
    private int serialNumber;
    private String model;
    private  String carrier;
    private String phoneNumber;
    private  String owner;

    public CellPhone(){
        this.serialNumber = 0;
        this.model = "";
        this.carrier = "";
        this.phoneNumber = "";
        this.owner = "";
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
