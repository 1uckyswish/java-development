package com.yearup.jbdcdealership.application;

import com.yearup.jbdcdealership.data.DealerDao;
import com.yearup.jbdcdealership.models.Vehicle;

import java.util.List;

public class AdminUserInterface {
    private DealerDao dealerDao;
    private List<Vehicle> vehicles;

    public AdminUserInterface(DealerDao dealerDao) {
        this.dealerDao = dealerDao;
        this.vehicles = vehicles;
    }

    /**
     * Displays all contracts stored in the contract list.
     */
    public void viewAllContracts() {
        System.out.println("\nViewing all contracts:");
        vehicles = dealerDao.getAllContracts();
        for (Vehicle contract : vehicles) {
            System.out.println(contract);
        }
        System.out.println();
    }

    /**
     * Displays all sale contracts stored in the contract list.
     */
    public void viewSaleContracts() {
        System.out.println("\nViewing sale contracts:");
        vehicles = dealerDao.getAllSaleContracts();
        for (Vehicle contract : vehicles) {
            System.out.println(contract);
        }
        System.out.println();
    }

    /**
     * Displays all lease contracts stored in the contract list.
     */
    public void viewLeaseContracts() {
        System.out.println("\nViewing lease contracts:");
        vehicles = dealerDao.getAllLeaseContracts();
        for (Vehicle contract : vehicles) {
            System.out.println(contract);
        }
        System.out.println();
    }

    /**
     * Displays options for viewing contracts.
     */
    public void display(){
        System.out.println("What contracts do you want to view?");
        System.out.println("1. All contracts");
        System.out.println("2. Sale contracts");
        System.out.println("3. Lease contracts");
        System.out.print("Enter your choice: ");
    }

}
