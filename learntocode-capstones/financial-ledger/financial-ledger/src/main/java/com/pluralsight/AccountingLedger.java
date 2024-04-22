package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AccountingLedger {
    // Hold all Transactions read from CSV file and apply them to an Arraylist to
    // easily append and retrieve values
    static ArrayList<Transaction> transactionHistory = new ArrayList<>();

    /**
     * Entry point of the Accounting Ledger application.
     *
     * @throws IOException If an I/O error occurs.
     */
    public static void main(String[] args) throws IOException {
        // Create a scanner object to handle user input throughout the application
        Scanner scanner = new Scanner(System.in);
        // Call the method that reads the CSV file and makes a class instance of each
        // one
        // After reading file it appends a new object of each transaction to the
        // ArrayList
        readAndAddToTransactionHistory();
        // Call the method that starts the whole application. It continues running until
        // user says otherwise
        displayHomeScreen(scanner);
    }

    /**
     * Reads transaction data from the CSV file and adds transactions to the
     * transaction ArrayList.
     *
     * @throws IOException If an I/O error occurs.
     */
    public static void readAndAddToTransactionHistory() throws IOException {
        // Create a new reader to access the csv file
        // Specify the path to the CSV file you want to re
        BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"));
        // Skip the first line as it contains the CSV headers
        // ex=> date|time|description|vendor|amount
        // We skip this line ^ by calling readLine() once
        reader.readLine();

        String line;
        // This line of code assigns the value returned by reader.readLine() as a string
        // this condition checks whether the value of line is not null, which means
        // there are more lines to read from the input stream.
        while ((line = reader.readLine()) != null) {
            // Split the line by the pipe character (|)
            String[] transactionsSplit = line.split(Pattern.quote("|"));
            // Pass the values that are split as arguments to a method that creates a NEW
            // INSTANCE OF A CLASS,
            // Create a new Transaction object from the split values and add it to the
            // transaction history ArrayList
            transactionHistory.add(createTransactionFromCsv(transactionsSplit));
        }
        // Close the reader to release all resources associated with it
        reader.close();
    }

    /**
     * Creates a Transaction object from an array of string values extracted from a
     * CSV file.
     *
     * @param csvTransactions An array of string values representing transaction
     *                        data.
     * @return A new Transaction object created from the CSV data.
     */
    public static Transaction createTransactionFromCsv(String[] csvTransactions) {
        // Split up values based by the index of the array into variables for better
        // reading
        String transactionDate = csvTransactions[0];
        String transactionTime = csvTransactions[1];
        String transactionDescription = csvTransactions[2];
        String transactionVendor = csvTransactions[3];
        // The final indexed array value returns as a string
        // We have to convert it from the data type of String to Double
        double transactionAmount = Double.parseDouble(csvTransactions[4]);
        // Create a new Transaction object with the extracted data and return the new
        // object
        return new Transaction(transactionDate, transactionTime, transactionDescription, transactionVendor,
                transactionAmount);
    }

    /**
     * Displays the main menu of the Account Ledger application and handles user
     * interactions.
     *
     * @param scanner A Scanner object used for user input.
     * @throws IOException If an I/O error occurs.
     */
    public static void displayHomeScreen(Scanner scanner) throws IOException {
        // Welcome the user and display the options for them to choose from
        System.out.println("------------------------------------------------------------");
        System.out.println("\t\t Welcome to the Account Ledger Application");
        System.out.println("\t\t - Your Ultimate Finance Tracker in Java! - \t");
        System.out.println("------------------------------------------------------------\n");
        System.out.println("Please select from the following options:");
        System.out.println("(D) Add Deposit - Add a deposit to the ledger");
        System.out.println("(P) Make Payment (Debit) - Make a payment and deduct it from the ledger");
        System.out.println("(L) Ledger - Display the ledger");
        System.out.println("(B) Balance - View Ledger Balance");
        System.out.println("(X) Exit - Exit the application");
        // Prompt user for input
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine().toUpperCase();
        // Handle user's choice by Letter
        switch (choice) {
            case "D":
                // Call method to add deposit
                // Pass the scanner as argument one
                // Pass true for the second argument if the transaction is a deposit
                addTransaction(scanner, true);
                break;
            case "P":
                // Call method to make payment
                // Pass the scanner as argument one
                // Pass false for the second argument since the transaction is not a deposit
                addTransaction(scanner, false);
                break;
            case "L":
                // Call method to display ledger
                // Pass the scanner as argument one
                displayLedger(scanner);
                break;
            case "B":
                // Call method to display ledger balance
                // Pass the scanner as argument one
                calculateLedgerBalance(scanner);
                break;
            case "X":
                // Handle Exit option
                System.out.println("Exiting the application...");
                break;
            default:
                // If user types the wrong option not displayed. Use recursion by calling the
                // method within itself
                System.out.println("\n----Invalid choice. Please enter a valid option.----\n");
                displayHomeScreen(scanner);
        }
        // Releases all resources associated with the reader.
        scanner.close();
    }

    /**
     * Prompts the user to enter details for a new transaction and adds it to the
     * ledger.
     *
     * @param scanner   A Scanner object for user input.
     * @param isDeposit A boolean indicating if the transaction is a deposit (true)
     *                  or payment (false).
     * @throws IOException If an I/O error occurs.
     */
    public static void addTransaction(Scanner scanner, boolean isDeposit) throws IOException {
        // Display information prompt for the user to fill out
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t   - Please Fill out the following information - \t");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        // Ask the user if they want to use the current date
        System.out.print("Do you want to use the current date? (Y/N): ");
        String choice = scanner.nextLine().toUpperCase();
        String date;
        // If a user chooses to use the current date, set it to the current date
        if (choice.equals("Y")) {
            date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } else {
            // Prompt the user to enter a specific date
            System.out.print("Please Enter The Date (YYYY-MM-DD): ");
            date = scanner.nextLine();
        }

        // Ask the user if they want to use the current time
        System.out.print("Do you want to use the current time? (Y/N): ");
        choice = scanner.nextLine().toUpperCase();
        LocalTime currentTime = LocalTime.now();
        String time;
        // If a user chooses to use the current time, set it to the current time
        if (choice.equals("Y")) {
            time = currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        } else {
            // Ask the user to enter a specific time
            System.out.print("Please Enter The Time (HH:MM:SS): ");
            time = scanner.nextLine().trim();
        }
        // Ask the user to enter a specific time
        System.out.print("Please Enter The Description: ");
        String description = scanner.nextLine().trim();

        System.out.print("Please Enter The Vendor: ");
        String vendor = scanner.nextLine().trim();

        System.out.print("Please Enter The Amount: ");
        double amount = scanner.nextDouble();

        // Convert positive amount to negative if it's a payment
        if (!isDeposit && amount > 0) {
            amount = -amount;
        }

        scanner.nextLine(); // Consume the newline character left by nextDouble()
        // Use ternary to check what if (IsDeposit) is true or false
        System.out.println("- Summary of " + (isDeposit ? "Deposit" : "Payment") + " -");
        // Create a new transaction
        Transaction newTransaction = new Transaction(date, time, description, vendor, amount);
        // Add the new transaction to the CSV file
        // Pass the value of the inputted data to have the method write to the CSV
        addTransactionToCSV(date, time, description, vendor, amount);
        // Add the new transaction to the transactionHistory ArrayList immediately
        transactionHistory.add(newTransaction);
        System.out.println(newTransaction);
        // Provide feedback to the user
        System.out.println((isDeposit ? "Deposit" : "Payment") + " added successfully!");

        // Return to the home screen
        goToHomeScreen(scanner);
    }

    /**
     * Displays the ledger options to the user and prompts for their choice.
     *
     * @param scanner A Scanner object for user input.
     * @throws IOException If an I/O error occurs.
     */
    public static void displayLedger(Scanner scanner) throws IOException {
        // Display ledger options for the user to choose from
        System.out.println("\nLedger Options:");
        System.out.println("(A) Show All - Display all transaction entries");
        System.out.println("(D) Deposits Only - Display only deposit transactions");
        System.out.println("(P) Payments Only - Display only negative transactions (payments)");
        System.out.println("(R) Run Reports - Open a new screen to run predefined transaction reports");
        System.out.print("Enter your choice: ");
        // Read user input and convert to uppercase to prevent case sensitivity
        String choice = scanner.nextLine().trim().toUpperCase();
        // Another way would be to do the .equalsIgnore()
        switch (choice) {
            // Invoke the same method to handle the first three options.
            // Specifying the category, each option corresponds to as the first argument
            // pass scanner as the second argument
            case "A":
                displayTransactions("All", scanner);
                break;
            case "D":
                displayTransactions("Deposits", scanner);
                break;
            case "P":
                displayTransactions("Payments", scanner);
                break;
            case "R":
                // Call method to handle running reports
                // pass scanner as the second argument
                displayReports(scanner);
                break;
            default:
                // If user types the wrong option not displayed. Use recursion by calling the
                // method within itself
                System.out.println("\n----Invalid choice. Please choose a valid option (A, D, P, or R).----\n");
                displayLedger(scanner);
        }

    }

    /**
     * Displays transactions based on the specified display option.
     *
     * @param displayOption The option to filter transactions (e.g., "All",
     *                      "Deposits", "Payments").
     * @param scanner       The Scanner object for user input.
     * @throws IOException If an I/O error occurs.
     */
    public static void displayTransactions(String displayOption, Scanner scanner) throws IOException {
        // Display header for transactions based on the chosen option
        System.out.println("\nTransactions (" + displayOption + "):");
        // Iterate through transaction history and filter based on the displayOption
        // variable
        for (Transaction transaction : transactionHistory) {
            switch (displayOption.toLowerCase()) {
                case "all":
                    // Display all transactions
                    System.out.println(transaction);
                    break;
                case "deposits":
                    // Display only deposit transactions
                    if (transaction.getAmount() > 0) {
                        System.out.println(transaction);
                    }
                    break;
                case "payments":
                    // Display only payment transactions (Negative)
                    if (transaction.getAmount() < 0) {
                        System.out.println(transaction);
                    }
                    break;
                default:
                    // Handle an invalid display option (will never happen)
                    System.out.println("Invalid display option");
                    return;
            }
        }

        // Prompt the user for the next action
        while (true) {
            System.out.println("\nPlease select your next action:");
            System.out.println("1. Go back home");
            System.out.println("2. View other ledger reports");
            System.out.print("Enter your choice: ");
            String userChoice = scanner.nextLine();
            switch (userChoice) {
                case "1":
                    // Go back home
                    displayHomeScreen(scanner);
                    return; // Break out of the loop
                case "2":
                    // View other ledger reports
                    displayLedger(scanner);
                    return; // Break out of the loop
                default:
                    System.out.println("Invalid choice. Please choose 1 or 2.");
            }
        }
    }

    /**
     * Calculates the total income and expenses from the transaction history
     * ArrayList.
     *
     * @param scanner The scanner object for user input.
     * @throws IOException If an I/O error occurs.
     */
    public static void calculateLedgerBalance(Scanner scanner) throws IOException {
        // Variables to store the total income and expenses
        double totalIncome = 0;
        double totalExpenses = 0;
        // Loop through the transaction history ArrayList to calculate totals
        for (Transaction transaction : transactionHistory) {
            // Check if the transaction amount is greater than 0 (income) or less than 0
            // (expenses) using the Getter Method
            if (transaction.getAmount() > 0) {
                // Accumulate income each time through the loop iteration
                totalIncome += transaction.getAmount();
            } else {
                // Accumulate expenses (amounts are negative) each time through the loop
                // iteration
                totalExpenses += transaction.getAmount();
            }
        }
        // Print out the ledger balance report for the user
        System.out.println("\n------------------------------------------------------------");
        System.out.println("\t\tYour Current Ledger Balance Report");
        System.out.println("------------------------------------------------------------");

        System.out.printf("Total Income: $%,.2f" ,totalIncome);
        System.out.printf("\nTotal Expenses: $%,.2f", totalExpenses);
        double balance = totalIncome + totalExpenses;
        System.out.printf("\nLedger Balance: $%,.2f", balance);

        // Navigate back to the home screen
        goToHomeScreen(scanner);
    }

    /**
     * Adds a new transaction to the CSV file.
     *
     * @param date        The date of the transaction.
     * @param time        The time of the transaction.
     * @param description The description of the transaction.
     * @param vendor      The vendor associated with the transaction.
     * @param amount      The amount of the transaction.
     * @throws IOException If an I/O error occurs.
     */
    public static void addTransactionToCSV(String date, String time, String description, String vendor, double amount)
            throws IOException {
        // Create a File object representing the CSV file you want to create
        File file = new File("transactions.csv");
        // Check if the file already exists
        boolean fileExists = file.exists();
        // Create a BufferedWriter to write to the file
        // Set the second option to true to activate append mode
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        // If the file doesn't exist, write the header
        if (!fileExists) {
            // Header line for the CSV file
            writer.write("date|time|description|vendor|amount\n");
        }
        // Write transaction data to the file
        // Format the transaction data and write it to the file
        writer.write(String.format("%s|%s|%s|%s|%.2f%n", date, time, description, vendor, amount));
        // Close the writer
        writer.close();
    }

    /**
     * Displays pre-defined reports or allows the user to run custom searches.
     *
     * @param scanner The Scanner object for user input.
     * @throws IOException If an I/O error occurs.
     */
    public static void displayReports(Scanner scanner) throws IOException {
        // Display report options to the user
        System.out.println("\nReports - Access pre-defined reports or run custom searches:");
        System.out.println("(1) Month To Date");
        System.out.println("(2) Previous Month");
        System.out.println("(3) Year To Date");
        System.out.println("(4) Previous Year");
        System.out.println("(5) Search by Vendor - Enter the vendor name to display all entries for that vendor");
        System.out.println("(6) Custom Search - Enter any input for filtered search");
        System.out.println("(7) Back - Return to the report page");
        System.out.println("(8) Home - Return to the home page");

        // Prompt user for choice
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                // Generate the Month To Date report to user
                ledgerMonthToDateReport(scanner);
                break;
            case "2":
                // Generate the previous Month report to user
                ledgerPreviousMonthReport(scanner);
                break;
            case "3":
                // Generate a Year To Date report to user
                ledgerYearToDateReport(scanner);
                break;
            case "4":
                // Generate a Previous Year report to user
                ledgerPreviousYearReport(scanner);
                break;
            case "5":
                // Handle Search by Vendor to user by user input
                searchByVendor(scanner);
                break;
            case "6":
                // Handle Custom Search to user by user input
                customReportSearch(scanner);
                break;
            case "7":
                // Return to the previous page (Ledger screen)
                displayLedger(scanner);
                break;
            case "8":
                // Return to the home page (Welcome screen)
                displayHomeScreen(scanner);
                break;
            default:
                // Inform the user of an invalid choice and prompt again
                System.out.println("Invalid choice. Please enter a number between 1 and 8.");
                // Re-display the report menu
                displayReports(scanner);
        }
    }

    /**
     * Generates and displays a report of transactions from the beginning of the
     * current month to the current date.
     *
     * @param scanner The Scanner object for user input.
     * @throws IOException If an I/O error occurs.
     */
    public static void ledgerMonthToDateReport(Scanner scanner) throws IOException {
        // Get current date
        LocalDate currentDate = LocalDate.now();
        // Get the first day of the month with its methods
        LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);
        // Display report header
        System.out.println("------------------------------------------------------------");
        System.out.printf("\t\tReports from %s through %s%n", firstDayOfMonth, currentDate);
        System.out.println("------------------------------------------------------------");
        // loop through the ArrayList
        for (Transaction transaction : transactionHistory) {
            // Parse transaction date from string to LocalDate object
            LocalDate transactionDate = LocalDate.parse(transaction.getDate());
            // Display the transaction if it falls within the range
            // Check if the date is equal to today or is after the first of current month
            // AND is before the current date
            if (transactionDate.isEqual(currentDate)
                    || (transactionDate.isAfter(firstDayOfMonth) && transactionDate.isBefore(currentDate))) {
                System.out.println(transaction);
            }
        }
        // Return to the home screen
        goToHomeScreen(scanner);
    }

    /**
     * Generates and displays a report of transactions from the previous month.
     *
     * @param scanner The Scanner object for user input.
     * @throws IOException If an I/O error occurs.
     */
    public static void ledgerPreviousMonthReport(Scanner scanner) throws IOException {
        // Get current date
        LocalDate currentDate = LocalDate.now();

        // Get the first day of the previous month
        LocalDate firstDayOfPreviousMonth = currentDate.minusMonths(1).withDayOfMonth(1);

        // Get the last day of the previous month
        LocalDate lastDayOfPreviousMonth = currentDate.minusMonths(1)
                .withDayOfMonth(currentDate.minusMonths(1).lengthOfMonth());
        // calculates and assigns the last day of the previous month to the variable

        // Display report header
        System.out.println("------------------------------------------------------------");
        System.out.printf("\t\tReports from %s through %s%n", firstDayOfPreviousMonth, lastDayOfPreviousMonth);
        System.out.println("------------------------------------------------------------");
        // Loop through the transaction history
        for (Transaction transaction : transactionHistory) {
            // Parse transaction date from string to LocalDate object
            LocalDate transactionDate = LocalDate.parse(transaction.getDate());

            // Check if the transaction date falls within the previous month
            if (transactionDate.isEqual(firstDayOfPreviousMonth) ||
                    (transactionDate.isAfter(firstDayOfPreviousMonth)
                            && transactionDate.isBefore(lastDayOfPreviousMonth.plusDays(1)))) {
                System.out.println(transaction);
            }
        }

        // Return to the home screen
        goToHomeScreen(scanner);
    }

    /**
     * Generates and displays a report of transactions from the beginning of the
     * year to the current date.
     *
     * @param scanner The Scanner object for user input.
     * @throws IOException If an I/O error occurs.
     */
    public static void ledgerYearToDateReport(Scanner scanner) throws IOException {
        // Get current date
        LocalDate currentDate = LocalDate.now();
        // Get the first day of the month with its methods
        LocalDate firstDayOfYear = LocalDate.of(currentDate.getYear(), Month.JANUARY, 1);
        // Display report header
        System.out.println("------------------------------------------------------------");
        System.out.printf("\t\tReports from %s through %s%n", firstDayOfYear, currentDate);
        System.out.println("------------------------------------------------------------");
        // loop through the ArrayList
        for (Transaction transaction : transactionHistory) {
            // Parse transaction date from string to LocalDate object
            LocalDate transactionDate = LocalDate.parse(transaction.getDate());
            // Check if the date is equal to today or is after the first of current month
            // AND is before the current date
            if (transactionDate.isEqual(currentDate)
                    || (transactionDate.isAfter(firstDayOfYear) && transactionDate.isBefore(currentDate))) {
                System.out.println(transaction);
            }
        }

        // Return to the home screen
        goToHomeScreen(scanner);
    }

    /**
     * Generates and displays a report of transactions from the previous year.
     *
     * @param scanner The Scanner object for user input.
     * @throws IOException If an I/O error occurs.
     */
    public static void ledgerPreviousYearReport(Scanner scanner) throws IOException {
        // Get current date
        LocalDate currentDate = LocalDate.now();

        // Get the first day of the previous year
        LocalDate firstDayOfPreviousYear = currentDate.minusYears(1).withDayOfYear(1);

        // Get the last day of the previous year
        LocalDate lastDayOfPreviousYear = firstDayOfPreviousYear.plusYears(1).minusDays(1);
        // Calculates and assigns the last day of the previous month to the variable

        // Display report header
        System.out.println("------------------------------------------------------------");
        System.out.printf("\t\tReports from %s through %s%n", firstDayOfPreviousYear, lastDayOfPreviousYear);
        System.out.println("------------------------------------------------------------");
        // Loop through the transaction history
        for (Transaction transaction : transactionHistory) {
            // Parse transaction date from string to LocalDate object
            LocalDate transactionDate = LocalDate.parse(transaction.getDate());

            // Check if the transaction date falls within the previous month
            if (transactionDate.isEqual(firstDayOfPreviousYear) ||
                    (transactionDate.isAfter(firstDayOfPreviousYear)
                            && transactionDate.isBefore(lastDayOfPreviousYear.plusDays(1)))) {
                System.out.println(transaction);
            }
        }

        // Return to the home screen
        goToHomeScreen(scanner);
    }

    /**
     * Searches for transactions by vendor name and displays the matching entries.
     *
     * @param scanner The Scanner object for user input.
     * @throws IOException If an I/O error occurs.
     */
    public static void searchByVendor(Scanner scanner) throws IOException {
        // Prompt the user to enter the name of the vendor to search for
        System.out.print("Please enter the name of the vendor you wish to search for: ");
        String userVendorInput = scanner.nextLine().toUpperCase();
        // loop through the ArrayList to find matching results
        for (Transaction transaction : transactionHistory) {
            // Check if the vendor name contains the user's input (case-insensitive)
            // You can also do .equalIgnore();
            if (transaction.getVendor().toUpperCase().contains(userVendorInput)) {
                System.out.println(transaction);
            }
        }
        // Return to the home screen
        goToHomeScreen(scanner);
    }

    /**
     * Allows the user to perform a custom search based on specified criteria and
     * displays the matching transactions.
     *
     * @param scanner The Scanner object for user input.
     * @throws IOException If an I/O error occurs.
     */
    public static void customReportSearch(Scanner scanner) throws IOException {
        // Declare variables to store user input and search criteria
        LocalDate checkStartDate = null;
        LocalDate checkEndDate = null;
        double convertedAmountInput = 0.0;
        boolean foundMatch = false; // a boolean variable to track if any matches were found

        // Prompt the user to enter search criteria
        System.out.print("Reports - Please Insert the following Search Criteria: ");
        System.out.print("\nStart date (YYYY-MM-DD): ");
        String userStartDateInput = scanner.nextLine().trim();
        if (!userStartDateInput.isEmpty()) {
            checkStartDate = LocalDate.parse(userStartDateInput);
        }

        System.out.print("End date (YYYY-MM-DD): ");
        String userEndDateInput = scanner.nextLine().trim();
        if (!userEndDateInput.isEmpty()) {
            checkEndDate = LocalDate.parse(userEndDateInput);
        }

        System.out.print("Description: ");
        String checkDescription = scanner.nextLine().trim().toLowerCase();

        System.out.print("Vendor: ");
        String checkVendor = scanner.nextLine().trim().toLowerCase();

        System.out.print("Amount (press Enter to skip): ");
        String checkAmountInputStringValue = scanner.nextLine().trim();
        if (!checkAmountInputStringValue.isEmpty()) {
            convertedAmountInput = Double.parseDouble(checkAmountInputStringValue);
        }

        // Display header for a custom search report
        System.out.println("------------------------------------------------------------");
        System.out.println("\t\t\t\tYour Custom Search Report");
        System.out.println("------------------------------------------------------------");

        for (Transaction transaction : transactionHistory) {
            // Parses the date string from the Transaction object to a LocalDate object.
            // This allows us to perform date comparisons.
            LocalDate transactionDate = LocalDate.parse(transaction.getDate());
            // Check if the transaction matches the criteria
            boolean isStartDateMatched = checkStartDate == null || !transactionDate.isBefore(checkStartDate);
            boolean isEndDateMatched = checkEndDate == null || !transactionDate.isAfter(checkEndDate);
            boolean isDescriptionMatched = checkDescription.isEmpty()
                    || transaction.getDescription().toLowerCase().contains(checkDescription);
            boolean isVendorMatched = checkVendor.isEmpty()
                    || transaction.getVendor().toLowerCase().contains(checkVendor);
            boolean isAmountMatched = convertedAmountInput == 0 || transaction.getAmount() == convertedAmountInput;

            // If all criteria are matched, display the transaction
            if (isStartDateMatched && isEndDateMatched && isDescriptionMatched && isVendorMatched && isAmountMatched) {
                // Print the matched transaction here
                foundMatch = true; // Set foundMatch to true if a match is found
                System.out.println(transaction);
            }
        }

        // If no matches are found, display a message
        if (!foundMatch) {
            System.out.println("No transactions found matching the criteria.");
        }

        // Return to the home screen
        goToHomeScreen(scanner);

    }

    /**
     * Redirects the user to the home screen or other options based on their choice.
     *
     * @param scanner The Scanner object for user input.
     * @throws IOException If an I/O error occurs.
     */
    public static void goToHomeScreen(Scanner scanner) throws IOException {
        // Display menu options for the user
        while (true) {
            System.out.println("\nPlease select your next action:");
            System.out.println("1. Go back home");
            System.out.println("2. View ledger reports");
            System.out.println("3. Exit Program");
            System.out.print("Enter your choice: ");
            String userChoice = scanner.nextLine();
            switch (userChoice) {
                case "1":
                    // Go back home
                    displayHomeScreen(scanner);
                    return; // Break out of the loop
                case "2":
                    // View other ledger reports
                    displayLedger(scanner);
                    return; // Break out of the loop
                case "3":
                    // Exit
                    System.out.println("Exiting....");
                    return; // Break out of the loop
                default:
                    System.out.println("Invalid choice. Please choose 1 or 2.");
            }
        }
    }

}

/* -resources
*How to write method comments-- https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html
*How to check dates before or after-- https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
*How to write a good read me-- https://www.makeareadme.com/
*/
