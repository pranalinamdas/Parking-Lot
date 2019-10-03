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
        assertThrows(ParkingLotException.class,()->parkingLot.park(new Object()));
    }

    @Test
    void givenParkingLotOfCapacityTwo_whenParkSameObject_thenShouldNotAllow() throws ParkingLotException {
        ParkingLot parkingLot = new ParkingLot(2);
        Object objectOne = new Object();

        assertTrue(parkingLot.park(objectOne));
        assertThrows(ParkingLotException.class,()->parkingLot.park(objectOne));
    }
}
