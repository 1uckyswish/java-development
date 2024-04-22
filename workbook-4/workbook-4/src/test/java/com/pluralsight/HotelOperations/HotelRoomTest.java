package com.pluralsight.HotelOperations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelRoomTest {

    @Test
    void checkInOccupiedRoom() {
        HotelRoom room = new HotelRoom(2, 100.0, true, false, true);
        room.checkIn();
        assertTrue(room.isOccupied());
    }

    @Test
    void checkInDirtyRoom() {
        HotelRoom room = new HotelRoom(2, 100.0, false, true, true);
        room.checkIn();
        assertTrue(room.isDirty());
    }

    @Test
    void checkInUnavailableRoom() {
        HotelRoom room = new HotelRoom(2, 100.0, false, false, false);
        room.checkIn();
        assertFalse(room.isAvailable());
    }

    @Test
    void cleanRoom() {
        HotelRoom room = new HotelRoom(2, 100.0, true, true, false);
        room.cleanRoom();
        assertFalse(room.isDirty());
        assertFalse(room.isOccupied());
    }

    @Test
    void checkOut() {
        HotelRoom room = new HotelRoom(2, 100.0, true, true, false);
        room.checkOut();
        assertTrue(room.isAvailable());
        assertFalse(room.isOccupied());
        assertFalse(room.isDirty());
    }
}
