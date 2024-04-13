package com.pluralsight;

import java.util.Scanner;

public class AddressBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printCustomerInformation(getName(scanner), getAddress(scanner, "Billing"), getAddress(scanner, "Shipping"));
    }

    public static String getName(Scanner scanner){
        StringBuilder name = new StringBuilder();
        System.out.print("Full name: ");
        name.append(scanner.nextLine());
        System.out.println("");
        return name.toString();
    }

    public static String getAddress(Scanner scanner, String addressType){
        StringBuilder address = new StringBuilder();
        System.out.print(addressType + " Street: ");
        address.append(scanner.nextLine()).append("\n");
        System.out.print(addressType + " City: ");
        address.append(scanner.nextLine()).append(", ");
        System.out.print(addressType + " State: ");
        address.append(scanner.nextLine()).append(" ");
        System.out.print(addressType + " Zip: ");
        address.append(scanner.nextLine());
        System.out.println("");
        return address.toString();
    }

    public static void printCustomerInformation(String name, String billingAddress, String shippingAddress){
        System.out.printf("%s\n\nBilling Address:\n%s\n\nShipping Address:\n%s\n",
                name, billingAddress, shippingAddress);
    }


}
