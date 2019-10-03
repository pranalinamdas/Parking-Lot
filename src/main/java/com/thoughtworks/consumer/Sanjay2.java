package com.thoughtworks.consumer;

import com.thoughtworks.ParkingLot;
import com.thoughtworks.ParkingLotException;

import static com.thoughtworks.ParkingLotFactory.parkingLot1;
import static com.thoughtworks.ParkingLotFactory.parkingLot2;

public class Sanjay2 {
    public static void main(String[] args) {
        ParkingLot parkingLot1 = parkingLot1();
        ParkingLot parkingLot2 = parkingLot2();
        Object carA= new Object();
        Object carB= new Object();
        Object carC= new Object();

        try {
            System.out.println(parkingLot1.park(carA));
            System.out.println(parkingLot1.park(carB));
            System.out.println(parkingLot1.park(carC));
        } catch (ParkingLotException e) {
            System.out.println(e.message());
        }
    }
}
