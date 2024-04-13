package com.pluralsight;

import java.util.Scanner;

public class FullNameApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name");
        System.out.print("First name: ");
        String firstName = capitalizeFirstLetter(scanner.next().trim());
        scanner.nextLine(); // Consume newline character

        System.out.print("Middle name (press Enter to skip): ");
        String middleName = capitalizeFirstLetter(scanner.nextLine().trim()); // Read the entire line

        System.out.print("Last name: ");
        String lastName = capitalizeFirstLetter(scanner.next().trim());
        scanner.nextLine(); // Consume newline character

        System.out.print("Suffix (press Enter to skip): ");
        String suffix = capitalizeFirstLetter(scanner.nextLine().trim());

        String fullName = formatName(firstName, lastName, middleName, suffix);
        System.out.println("Full name: " + fullName);
    }

    public static String capitalizeFirstLetter(String str) {
        if (str.isEmpty()) {
            return str;
        }
        //grab the first letter and uppercase it
        //then grab the other half of word and add it
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String formatName(String firstName, String lastName, String middleName, String suffix){
        String fullName;
        if (middleName.isEmpty() && suffix.isEmpty()) {
            return fullName = firstName + " " + lastName;
        } else if (middleName.isEmpty()) {
            return fullName = firstName + " " + lastName + ", " + suffix;
        } else if (suffix.isEmpty()) {
            return fullName = firstName + " " + middleName.charAt(0) + ". " + lastName;
        } else {
            return fullName = firstName + " " + middleName.charAt(0) + ". " + lastName + ", " + suffix;
        }
    }
}
