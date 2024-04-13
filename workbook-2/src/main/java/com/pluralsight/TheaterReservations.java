package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TheaterReservations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String userName = scanner.nextLine().trim();
        System.out.print("What date will you be coming (MM/DD/YYYY): ");
        String date = scanner.nextLine().trim();
        LocalDate comingDate = getDate(date);
        System.out.print("How many tickets would you like? ");
        int amountOfTickets = scanner.nextInt();
        displayReservation(userName, comingDate, amountOfTickets);
    }

    public static LocalDate getDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate comingDate = LocalDate.parse(date, formatter);
        return comingDate;
    }

    public static void displayReservation(String name, LocalDate date, int ticketAmount){
        String ticketFormatter = (ticketAmount > 1) ? "tickets" : "ticket";
        String[] nameSplit = name.split(" ");
        System.out.println(ticketAmount + " " + ticketFormatter + " reserved for " + date + " " + "under " + nameSplit[1] + ", " + nameSplit[0]);
    }
}
