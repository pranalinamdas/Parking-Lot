package com.thoughtworks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    void givenParkingLotOfCapacityOne_whenParkOneObject_thenShouldBeAbleToPark() throws ParkingLotException {
        ParkingLot parkingLot = new ParkingLot(1);

        assertTrue(parkingLot.park(new Object()));
    }

    @Test
    void givenParkingLotCapacityOne_whenParkTwoObject_thenShouldNotBeAbleToParkSecondObject() throws ParkingLotException {
        ParkingLot parkingLot = new ParkingLot(1);

        assertTrue(parkingLot.park(new Object()));
        ParkingLotException exception = assertThrows(ParkingLotException.class, () -> parkingLot.park(new Object()));
        assertEquals("Parking lot is full", exception);
    }

    @Test
    void givenParkingLotOfCapacityTwo_whenParkSameObject_thenShouldNotAllow() throws ParkingLotException {
        ParkingLot parkingLot = new ParkingLot(2);
        Object objectOne = new Object();

        assertTrue(parkingLot.park(objectOne));
        ParkingLotException exception = assertThrows(ParkingLotException.class, () -> parkingLot.park(objectOne));
        assertEquals("Object is already parked", exception);
    }

    @Test
    void givenParkingLotWithNoParkedObject_WhenUnParkTheObject_ThenShouldNotBeAbleToUnParkTheObject() {
        ParkingLot parkingLot = new ParkingLot(1);

        ParkingLotException exception = assertThrows(ParkingLotException.class, () -> parkingLot.unPark(null));
        assertEquals("Parking lot is empty", exception);
    }

    @Test
    void givenParkingLotWithOneObjectParked_whenUnParkTheObject_thenShouldBeAbleToUnParkTheObject() throws ParkingLotException {
        ParkingLot parkingLot = new ParkingLot(1);
        Object object = new Object();
        parkingLot.park(object);

        assertTrue(parkingLot.unPark(object));
    }
}
