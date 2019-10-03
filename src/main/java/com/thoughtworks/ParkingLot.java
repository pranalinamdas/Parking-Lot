package com.thoughtworks;

public class ParkingLot {
    private final int capacity;
    private int spaceAvailable;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        spaceAvailable = capacity;
    }

    public boolean park(Object object) {
        if (spaceAvailable > 0) {
            spaceAvailable--;
            return true;
        }
        return false;
    }
}
