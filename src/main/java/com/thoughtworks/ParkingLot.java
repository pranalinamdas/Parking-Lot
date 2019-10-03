package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int capacity;
    private List<Object> parkedObjects = new ArrayList<>();

    protected ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public boolean park(Object object) throws ParkingLotException {
        if (isFull()) {
            throw new ParkingLotException("Parking lot is full.");
        }
        if (isAlreadyParked(object)) {
            throw new ParkingLotException("Object is already parked.");
        }
        return parkedObjects.add(object);
    }

    private boolean isAlreadyParked(Object object) {
        return parkedObjects.contains(object);
    }

    private boolean isFull() {
        return parkedObjects.size() >= capacity;
    }

    public boolean unPark(Object object) throws ParkingLotException {
        if(parkedObjects.isEmpty()){
            throw new ParkingLotException("Parking lot is empty");
        }
        return parkedObjects.remove(object);
    }
}
