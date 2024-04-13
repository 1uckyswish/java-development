package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class StringRefs {
    public static void main(String[] args) {
        String welcome = "Big Tex says \"Howdy\"!";
        String welcome2 = "Let's get\r this started!";

        String name = "    Noel Guilen    ";
//        System.out.println(name.trim());

        String discountCode = "FAIR-15OFF";
//        System.out.println(discountCode.endsWith("F"));
//        System.out.println(discountCode.startsWith("F"));
        String trackingCode = "USA-12981-Y-22";
        char hasShipped = trackingCode.charAt(10);
//        System.out.println(hasShipped);
        String productCode = "ACME-12213";
        int dashPosition = productCode.indexOf("E");
//        System.out.println(dashPosition);
        String vendor = productCode.substring(0, 3);
//        System.out.println(vendor);
        String code = productCode.substring(5, 10);
//        System.out.println(code);

        String input = "Dallas|Ft. Worth|Austin";
        String[] cities = input.split("\\|");
//        System.out.println(Arrays.toString(cities));
        String[] cities2 = input.split(Pattern.quote("|"));
//        System.out.println(Arrays.toString(cities2));

        int id = Integer.parseInt("111");
        String numberString = String.valueOf(200);
        double price = Double.parseDouble("2000");
//        System.out.print(price);
//        System.out.println(id);
//        System.out.print(numberString);
//        LocalDate birthDay = LocalDate.parse("2002-10-17");
        String userInput;
        DateTimeFormatter formatter;
        userInput = "07 may 23";
        formatter = DateTimeFormatter.ofPattern("dd MMMM yy");
        LocalDate birthDay = LocalDate.parse(userInput, formatter);
        System.out.println(birthDay);

    }
}
