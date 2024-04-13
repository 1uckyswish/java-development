package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CellPhone phone1 = createCellPhone(scanner);
        display(phone1);
        CellPhone phone2 = createCellPhone(scanner);
        display(phone2);

//        phone1.dial(phone2.getPhoneNumber());
//        phone2.dial(phone1.getPhoneNumber());
        dialNewPhone(phone1, phone2);
        dialNewPhone(phone2, phone1);
    }

    public static CellPhone createCellPhone(Scanner scanner) {
        CellPhone phone = new CellPhone();
        System.out.print("What is the serial number? ");
        phone.setSerialNumber(scanner.nextInt());
        scanner.nextLine(); // Consume the newline character left by nextInt()
        System.out.print("What model is the phone? ");
        phone.setModel(scanner.nextLine());
        System.out.print("Who is the carrier? ");
        phone.setCarrier(scanner.nextLine());
        System.out.print("What is the phone number? (ex. 123-456-7890): ");
        phone.setPhoneNumber(scanner.nextLine());
        System.out.print("Who is the owner of the phone? ");
        phone.setOwner(scanner.nextLine());
        return phone;
    }

    public static void display(CellPhone phone){
        System.out.println("\nPhone Information:");
        System.out.println("Serial Number: " + phone.getSerialNumber());
        System.out.println("Phone Model: " + phone.getModel());
        System.out.println("Carrier: " + phone.getCarrier());
        System.out.println("Phone Number: " + phone.getPhoneNumber());
        System.out.println("Owner: " + phone.getOwner()+ "\n");
    }

    // overloaded dial method.
    public static void dialNewPhone(CellPhone newPhone, CellPhone callingPhone) {
        callingPhone.dial(newPhone);
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
    // create constrcutor.
    public CellPhone(int serialNumber, String model, String carrier, String phoneNumber, String owner) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.carrier = carrier;
        this.phoneNumber = phoneNumber;
        this.owner = owner;
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

    public void dial(String phoneNumberDial){
        System.out.println(getOwner() + "'s phone is calling " + phoneNumberDial);
    }
    //overload
    public void dial(CellPhone phone) {
        System.out.println(owner + "'s phone is calling " + phone.getPhoneNumber());
    }
}
