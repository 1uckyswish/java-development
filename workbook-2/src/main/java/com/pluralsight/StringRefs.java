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
//        System.out.println(birthDay);
        StringBuilder skills = new StringBuilder();
// append strings to the StringBuilder object
        skills.append("Git, ");
        skills.append("HTML, ");
        skills.append("CSS, ");
        skills.append("and Bootstrap\n");
        skills.append("JavaScript, ");
        skills.append("ES6, ");
        skills.append("jQuery, ");
        skills.append("REST APIs, ");
        skills.append("and Express\n");
        skills.append("Angular\n");
        skills.append("Java\n");
// retrieve the underlying characters from
// the StringBuilder
        String mySkills = skills.toString();
        System.out.println(mySkills);
    }
}
