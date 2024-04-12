package  com.pluralsight;


import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FullNameParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String[] arrayOfName;
        System.out.print("Please enter your full name: ");
        name = scanner.nextLine().trim();
        arrayOfName = name.split(Pattern.quote(" "));

        // If the length is not within the expected range, prompt the user to enter the name again
        while (arrayOfName.length < 2 || arrayOfName.length > 3) {
            System.out.println("Full name should contain 2 or 3 parts.");
            System.out.print("Please enter your full name: ");
            name = scanner.nextLine().trim();
            arrayOfName = name.split(Pattern.quote(" "));
        }

        String displayFirstName = capitalizeFirstLetter(arrayOfName[0]);
        String displayMiddleName = arrayOfName.length == 3 ? capitalizeFirstLetter(arrayOfName[1]).charAt(0) + "." : "(None)";
        String displayLastName = capitalizeFirstLetter(arrayOfName[arrayOfName.length - 1]);
        //since its zero based the length of [3] is out of bounds. so we minus one to always get the last index. EX. last name

        System.out.println("First Name: " + displayFirstName);
        System.out.println("Middle Name: " + displayMiddleName);
        System.out.println("Last Name: " + displayLastName);
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
