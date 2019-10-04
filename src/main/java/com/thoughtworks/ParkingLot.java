package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int capacity;
    private List<Object> parkedObjects = new ArrayList<>();

    protected ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public boolean park(Object object) throws SpaceNotAvailableException, AlreadyParkedException {
        if (isFull()) {
            throw new SpaceNotAvailableException();
        }
        if (isAlreadyParked(object)) {
            throw new AlreadyParkedException();
        }
        return parkedObjects.add(object);
    }

    private boolean isAlreadyParked(Object object) {
        return parkedObjects.contains(object);
    }

    private boolean isFull() {
        return parkedObjects.size() >= capacity;
    }

    public Object unPark(Object object) throws ParkingLotEmptyException, VehicleNotParkedException {
        if (parkedObjects.isEmpty()) {
            throw new ParkingLotEmptyException();
        }
        if (!isAlreadyParked(object)) {
            throw new VehicleNotParkedException();
        }
        return parkedObjects.remove(parkedObjects.indexOf(object));
    }
}
