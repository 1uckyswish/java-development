package com.pluralsight.HotelOperations;

import java.time.LocalDateTime;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double startTime; // Track start time when punching in

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getTotalpay() {
        return hoursWorked * payRate;
    }
    public double getRegularHours() {
        // Regular hours are either 40 or less if the total hours worked are less than 40
        return Math.min(hoursWorked, 40);
    }

    public double getOvertimeHours() {
        // Overtime hours are the hours worked beyond 40
        return Math.max(hoursWorked - 40, 0); // Return 0 if hours worked are 40 or less
    }

    // Punch in method to track start time
    public void punchIn(double time) {
        startTime = time;
    }

    public void punchIn(){
        LocalDateTime time = LocalDateTime.now();
        startTime = Double.parseDouble(time.toString());
    }

    public void punchOut(){
        LocalDateTime time = LocalDateTime.now();
        startTime = Double.parseDouble(time.toString());
    }

    // Punch out method to calculate hours worked and update total hours worked
    public void punchOut(double time) {
        double hours = time - startTime;
        hoursWorked += hours;
    }




}
