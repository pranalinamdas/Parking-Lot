package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int capacity;
    private List<Object> parkedObjects = new ArrayList<>();
    private List<Subscriber> subscribers;

    protected ParkingLot(int capacity, List<Subscriber> subscribers) {
        this.capacity = capacity;
        this.subscribers = subscribers;
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
            for (Subscriber subscriber : subscribers) {
                subscriber.informSpaceIsFull();
            }
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
            for (Subscriber subscriber : subscribers) {
                subscriber.informSpaceIsAvailableAgain();
            }
        }
        return object;
    }
}
