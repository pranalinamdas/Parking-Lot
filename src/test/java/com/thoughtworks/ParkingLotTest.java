package com.thoughtworks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ParkingLotTest {

//    @Test
//    void givenParkingLotOfCapacityOne_whenParkOneVehicle_thenShouldBeAbleToPark() throws SpaceNotAvailableException, AlreadyParkedException {
//        Owner owner = new Owner();
//        ParkingLot parkingLot = new ParkingLot(1, owner);
//
//        assertTrue(parkingLot.park(new Object()));
//    }

    @Test
    void givenParkingLotCapacityOne_whenParkTwoVehicle_thenShouldNotBeAbleToParkSecondObject() throws SpaceNotAvailableException, AlreadyParkedException {
        Owner owner = new Owner();
        ParkingLot parkingLot = new ParkingLot(1, owner);
        parkingLot.park(new Object());

        assertThrows(SpaceNotAvailableException.class, () -> parkingLot.park(new Object()));
    }

    @Test
    void givenParkingLotOfCapacityTwo_whenParkSameVehicle_thenShouldNotAllow() throws SpaceNotAvailableException, AlreadyParkedException {
        Owner owner = new Owner();
        ParkingLot parkingLot = new ParkingLot(2, owner);

        Object objectOne = new Object();
        parkingLot.park(objectOne);

        assertThrows(AlreadyParkedException.class, () -> parkingLot.park(objectOne));
    }

    @Test
    void givenParkingLotWithNoParkedVehicle_WhenUnParkTheVehicle_ThenShouldNotBeAbleToUnParkTheVehicle() {
        Owner owner = new Owner();
        ParkingLot parkingLot = new ParkingLot(1, owner);

        assertThrows(VehicleNotFoundException.class, () -> parkingLot.unPark(null));
    }

    @Test
    void givenParkingLotWithOneVehicleParked_whenUnParkTheVehicle_thenShouldBeAbleToUnParkTheVehicle() throws VehicleNotFoundException, AlreadyParkedException, SpaceNotAvailableException {
        Owner owner = new Owner();
        ParkingLot parkingLot = new ParkingLot(1, owner);

        Object object = new Object();
        parkingLot.park(object);

        assertEquals(object, parkingLot.unPark(object));
    }

    @Test
    void givenParkingLotWithOneVehicleParked_whenUnParkedNotParkedVehicle_thenShouldThrowException() throws SpaceNotAvailableException, AlreadyParkedException {
        Owner owner = new Owner();
        ParkingLot parkingLot = new ParkingLot(2, owner);

        Object objectOne = new Object();
        Object objectTwo = new Object();

        parkingLot.park(objectOne);
        assertThrows(VehicleNotFoundException.class, () -> parkingLot.unPark(objectTwo));
    }

    class DummyOwner extends Owner {

        private String message;
        int count = 0;

        @Override
        void inform(String message) {
            this.message = message;
            count++;
        }
    }

    @Test
    void givenParkingLot_whenFull_thenShouldInformOwner() throws AlreadyParkedException, SpaceNotAvailableException {
        DummyOwner owner = new DummyOwner();
        ParkingLot parkingLot = new ParkingLot(1, owner);

        Object vehicle = new Object();
        parkingLot.park(vehicle);

        assertEquals("Parking lot gets full", owner.message);
    }

    @Test
    void givenParkingLot_whenInformToOwner_thenShouldGetCalledOnce() throws AlreadyParkedException, SpaceNotAvailableException {
        DummyOwner owner = new DummyOwner();
        ParkingLot parkingLot = new ParkingLot(1, owner);

        Object vehicle = new Object();
        parkingLot.park(vehicle);

        assertEquals(1,owner.count);
    }

}
