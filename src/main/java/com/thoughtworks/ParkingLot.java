package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int capacity;
    private List<Object> parkedObjects=new ArrayList<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public boolean park(Object object) {
        if (parkedObjects.size() < capacity && !parkedObjects.contains(object)) {
            return parkedObjects.add(object);
        }
        return false;
    }
}
