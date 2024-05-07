package com.pluralsight.HotelOperations;

public class Hotel {
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getBookedSuites() {
        return bookedSuites;
    }

    public int getBookedBasicRooms() {
        return bookedBasicRooms;
    }

    public boolean bookRoom(int numberOfRooms, boolean isSuite){
        if (isSuite) {
            if (numberOfRooms <= numberOfSuites - bookedSuites) {
                bookedSuites += numberOfRooms;
//                getAvailableSuites();
                removeSuites();
                return true;
            } else {
                return false;
            }
        } else {
            if (numberOfRooms <= numberOfRooms - bookedBasicRooms) {
                bookedBasicRooms += numberOfRooms;
//                getAvailableBasicRooms();
                removebasic();
                return true;
            } else {
                return false;
            }
        }
    }

    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }

    public int getAvailableBasicRooms() {
        return numberOfRooms - bookedBasicRooms;
    }

    public void removeSuites(){
        numberOfSuites--;
    }

    public void removebasic(){
        numberOfRooms--;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", numberOfSuites=" + numberOfSuites +
                ", numberOfRooms=" + numberOfRooms +
                ", bookedSuites=" + bookedSuites +
                ", bookedBasicRooms=" + bookedBasicRooms +
                '}';
    }
}
