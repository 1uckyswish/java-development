package com.pluralsight;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Pattern;

public class FormatDates {
    public static void main(String[] args) {
        /*
        09/05/2021
        2021-09-05
        September 5, 2021
        Sunday, Sep 5, 2021 10:02
         */
        String formattedDate1 = "";
        LocalDate date1 = LocalDate.now();
        DateTimeFormatter myFormatedDate1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        formattedDate1 = myFormatedDate1.format(date1);
        System.out.println(formattedDate1);

        //*04/16/2024

        //Second one
        String formattedDate2 = "";
        LocalDate date2 = LocalDate.now();
        System.out.println(date1);
        DateTimeFormatter myFormatedDate2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formattedDate1 = myFormatedDate2.format(date2);
        System.out.println(formattedDate2);

        //*2024-04-16

        //third one
        String formattedDate3 = "";
        LocalDate date3 = LocalDate.now();
        DateTimeFormatter myFormatedDate3 = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        formattedDate3 = myFormatedDate3.format(date3);
        System.out.println(formattedDate3);

        //* Apr 16, 2024

        //fourth one
        String formattedDate4 = "";
        LocalDateTime date4 = LocalDateTime.now();
        DateTimeFormatter myFormattedDate4 = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy HH:mm");
        formattedDate4 = myFormattedDate4.format(date4.atZone(ZoneId.of("GMT")));
        System.out.println(formattedDate4);

        //*Tuesday, April 16, 2024 14:42

        //LAST ONE
        String formattedDate5 = "";
        LocalDateTime date5 = LocalDateTime.now();
        DateTimeFormatter myFormattedDate5 = DateTimeFormatter.ofPattern("h:mm 'on' dd-MMM-yyyy", Locale.US);
        formattedDate5 = myFormattedDate5.format(date5.atZone(ZoneId.systemDefault()));
        System.out.println(formattedDate5);

        //*2:42 on 16-Apr-2024

        String formattedDate6 = ""; // Corrected variable name
        LocalDateTime date6 = LocalDateTime.now();
        DateTimeFormatter myFormattedDate6 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss", Locale.US);
        formattedDate6 = myFormattedDate6.format(date6.atZone(ZoneId.systemDefault()));
        System.out.println(formattedDate6); // Corrected variable name
    }
}
