package com.pluralsight;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Whats your name ");
        String name = scanner.nextLine();
        System.out.println("Howdy " + name);
        name();
    }

    public static void name(){
        System.out.println("noel");
    }
}
