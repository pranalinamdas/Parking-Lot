package com.thoughtworks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    void givenParkingLotOfCapacityOne_whenParkOneVehicle_thenShouldBeAbleToPark() throws SpaceNotAvailableException, AlreadyParkedException {
        ParkingLot parkingLot = new ParkingLot(1);

        assertTrue(parkingLot.park(new Object()));
    }

    @Test
    void givenParkingLotCapacityOne_whenParkTwoVehicle_thenShouldNotBeAbleToParkSecondObject() throws SpaceNotAvailableException, AlreadyParkedException {
        ParkingLot parkingLot = new ParkingLot(1);

        assertTrue(parkingLot.park(new Object()));
        SpaceNotAvailableException exception = assertThrows(SpaceNotAvailableException.class, () -> parkingLot.park(new Object()));
    }

    @Test
    void givenParkingLotOfCapacityTwo_whenParkSameVehicle_thenShouldNotAllow() throws SpaceNotAvailableException, AlreadyParkedException {
        ParkingLot parkingLot = new ParkingLot(2);
        Object objectOne = new Object();

        assertTrue(parkingLot.park(objectOne));
        AlreadyParkedException exception = assertThrows(AlreadyParkedException.class, () -> parkingLot.park(objectOne));
    }

    @Test
    void givenParkingLotWithNoParkedVehicle_WhenUnParkTheVehicle_ThenShouldNotBeAbleToUnParkTheVehicle() {
        ParkingLot parkingLot = new ParkingLot(1);

        assertThrows(ParkingLotEmptyException.class, () -> parkingLot.unPark(null));
    }

    @Test
    void givenParkingLotWithOneVehicleParked_whenUnParkTheVehicle_thenShouldBeAbleToUnParkTheVehicle() throws ParkingLotEmptyException, VehicleNotParkedException, AlreadyParkedException, SpaceNotAvailableException {
        ParkingLot parkingLot = new ParkingLot(1);
        Object object = new Object();
        parkingLot.park(object);

        assertEquals(object, parkingLot.unPark(object));
    }

    @Test
    void givenParkingLotWithOneVehicleParked_whenUnParkedNotParkedVehicle_thenShouldThrowException() throws SpaceNotAvailableException, AlreadyParkedException {
        ParkingLot parkingLot = new ParkingLot(2);
        Object objectOne = new Object();
        Object objectTwo = new Object();

        parkingLot.park(objectOne);
        assertThrows(VehicleNotParkedException.class, () -> parkingLot.unPark(objectTwo));
    }


}
