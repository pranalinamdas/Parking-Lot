package com.thoughtworks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {

    @Test
    void givenParkingLotOfCapacityOne_whenParkOneObject_thenShouldBeAbleToPark() {
        ParkingLot parkingLot = new ParkingLot(1);

        assertTrue(parkingLot.park(new Object()));
    }

    @Test
    void givenParkingLotCapacityOne_whenParkTwoObject_thenShouldNotBeAbleToParkSecondObject(){
        ParkingLot parkingLot = new ParkingLot(1);

        assertTrue(parkingLot.park(new Object()));
        assertFalse(parkingLot.park(new Object()));

    }
}
