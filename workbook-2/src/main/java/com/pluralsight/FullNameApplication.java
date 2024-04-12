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

        String fullName;
        if (middleName.isEmpty() && suffix.isEmpty()) {
            fullName = firstName + " " + lastName;
        } else if (middleName.isEmpty()) {
            fullName = firstName + " " + lastName + ", " + suffix;
        } else if (suffix.isEmpty()) {
            fullName = firstName + " " + middleName.charAt(0) + ". " + lastName;
        } else {
            fullName = firstName + " " + middleName.charAt(0) + ". " + lastName + ", " + suffix;
        }

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
}
