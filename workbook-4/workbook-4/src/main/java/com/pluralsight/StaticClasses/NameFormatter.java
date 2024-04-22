package com.pluralsight.StaticClasses;

public class NameFormatter {

    private NameFormatter(){

    }


    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix) {
        StringBuilder formattedName = new StringBuilder();
        formattedName.append(prefix).append(". ").append(firstName).append(" ").append(middleName).append(" ").append(lastName).append(", ").append(suffix);
        return formattedName.toString();
    }

    public static String format(String firstName, String lastName){
        return String.format("%s %s", firstName, lastName);
    }


    public static String format(String fullName){
        return fullName;
    }
}
