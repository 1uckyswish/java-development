package com.pluralsight.ezraExcerise;

import com.pluralsight.ezraExcerise.models.Box;
import com.pluralsight.ezraExcerise.models.Rectangle;
import com.pluralsight.ezraExcerise.models.Square;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double length, width, height;

        do {
            System.out.println("Menu:");
            System.out.println("1. Rectangle Shape");
            System.out.println("2. Square Shape");
            System.out.println("3. Box Shape");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter length of the rectangle: ");
                    length = scanner.nextDouble();
                    System.out.print("Enter width of the rectangle: ");
                    width = scanner.nextDouble();
                    Rectangle rectangle = new Rectangle(length, width);
                    System.out.println("Rectangle Area: " + rectangle.getArea());
                    break;
                case 2:
                    System.out.print("Enter side length of the square: ");
                    length = scanner.nextDouble();
                    Square square = new Square(length);
                    System.out.println("Square Area: " + square.getArea());
                    break;
                case 3:
                    System.out.print("Enter length of the box: ");
                    length = scanner.nextDouble();
                    System.out.print("Enter width of the box: ");
                    width = scanner.nextDouble();
                    System.out.print("Enter height of the box: ");
                    height = scanner.nextDouble();
                    Box box = new Box(length, width, height);
                    System.out.println("Box Surface Area: " + box.getArea());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
