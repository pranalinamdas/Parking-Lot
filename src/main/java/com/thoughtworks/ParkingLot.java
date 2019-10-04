package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int capacity;
    private List<Object> parkedObjects = new ArrayList<>();
    private Informer owner;

    protected ParkingLot(int capacity, Informer owner) {
        this.capacity = capacity;
        this.owner = owner;
    }

    public void park(Object object) throws SpaceNotAvailableException, AlreadyParkedException {
        if (isFull()) {
            throw new SpaceNotAvailableException();
        }
        if (isAlreadyParked(object)) {
            throw new AlreadyParkedException();
        }

        parkedObjects.add(object);
        if (parkedObjects.size() == capacity) {
            owner.informSpaceIsFull();
        }
    }

    private boolean isAlreadyParked(Object object) {
        return parkedObjects.contains(object);
    }

    private boolean isFull() {
        return parkedObjects.size() >= capacity;
    }

    public Object unPark(Object object) throws VehicleNotFoundException {
        if (parkedObjects.isEmpty()) {
            throw new VehicleNotFoundException();
        }
        if (!isAlreadyParked(object)) {
            throw new VehicleNotFoundException();
        }
        parkedObjects.remove(object);
        if (parkedObjects.size() == capacity - 1) {
            owner.informSpaceIsAvailableAgain();
        }
        return object;
    }
}
