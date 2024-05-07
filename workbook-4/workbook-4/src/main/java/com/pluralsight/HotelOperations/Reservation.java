package com.pluralsight.HotelOperations;

public class Reservation {
    private String roomType;
    private double pricePerNight;
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
        // Set price per night based on room type
        if (roomType.equals("king")) {
            this.pricePerNight = 139.00;
        } else if (roomType.equals("double")) {
            this.pricePerNight = 124.00;
        }
        // Adjust price if it's a weekend stay
        if (isWeekend) {
            this.pricePerNight *= 1.1; // Increase price by 10%
        }
    }

    // Getters and Setters
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }

    // Calculate total reservation cost
    public double getReservationTotal() {
        return pricePerNight * numberOfNights;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "roomType='" + roomType + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", numberOfNights=" + numberOfNights +
                ", isWeekend=" + isWeekend +
                '}';
    }
}
