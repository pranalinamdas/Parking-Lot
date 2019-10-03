package com.thoughtworks;

public class ParkingLotFactory{
    public static ParkingLot parkingLot1(){
        return new ParkingLot(2);
    }

    public static ParkingLot parkingLot2(){
        return new ParkingLot(3);
    }
}
