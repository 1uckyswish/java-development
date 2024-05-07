package com.pluralsight.HotelOperations;

import java.util.ArrayList;
import java.util.List;

/*

// TODO Create a Hotel object - the number values for the hotel object should be based on
    the room array. numberOfSuites, numberOfRooms will be based on that array.

The numberofBookedSuites or numberOfBookedRooms will be based on that array.
*/
public class EzraMain {
    public static void main(String[] args) {

        // Create some room objects
        HotelRoom room1 = new HotelRoom(2, 100.00, false, true, true);
        HotelRoom room2 = new HotelRoom(1, 150.00,false,false,true);
        HotelRoom room3 = new HotelRoom(4,150.00,true,true,false);
        HotelRoom room4 = new HotelRoom(2,100.00,false,false,true);
        HotelRoom room5 = new HotelRoom(2,100.00,false,false,true);
        HotelRoom room6 = new HotelRoom(2,150.00,false,false,true);

        // create of an array (arraylist) of rooms.
        ArrayList<HotelRoom> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);
        rooms.add(room6);

        // create objects
        Reservation reservation1 = new Reservation("king", 3 , false);
        Reservation reservation2 = new Reservation("king",2,true);
        Reservation reservation3 = new Reservation("king", 3, true);
        Reservation reservation4 = new Reservation("double", 1, true);

        // add to array to loop through
        ArrayList<Reservation> reservationList = new ArrayList<>();
        reservationList.add(reservation1);
        reservationList.add(reservation2);
        reservationList.add(reservation3);
        reservationList.add(reservation4);


        int suitesCount = 0;
        int basicRoomCount = 0;

        for(HotelRoom room : rooms){
            if(room.getPrice() > 100){
                suitesCount++;
             } else {
                basicRoomCount++;
             }

        }

//        for (Reservation res: rooms){
//            if(res.getRoomType().equals("king")){
//                suitesCount++;
//            }else{
//                basicRoomCount++;
//            }
//
//        }

        // Create a Hotel object
        Hotel hotel1 = new Hotel("Ace Hotel", suitesCount, basicRoomCount, 0,0);
        hotel1.bookRoom(1, reservation1.getRoomType().equals("king"));
        hotel1.bookRoom(1, reservation2.getRoomType().equals("king"));
        hotel1.bookRoom(1, reservation3.getRoomType().equals("king"));
        hotel1.bookRoom(1, reservation4.getRoomType().equals("king"));
        System.out.println(hotel1);
    };
}
