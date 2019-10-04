package com.thoughtworks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ParkingLotTest {
    DummyOwner owner = new DummyOwner();

    @Test
    void givenParkingLotCapacityOne_whenParkTwoVehicle_thenShouldNotBeAbleToParkSecondObject() throws SpaceNotAvailableException, AlreadyParkedException {
        ParkingLot parkingLot = new ParkingLot(1, owner);
        parkingLot.park(new Object());

        assertThrows(SpaceNotAvailableException.class, () -> parkingLot.park(new Object()));
    }

    @Test
    void givenParkingLotOfCapacityTwo_whenParkSameVehicle_thenShouldNotAllow() throws SpaceNotAvailableException, AlreadyParkedException {

        ParkingLot parkingLot = new ParkingLot(2, owner);

        Object objectOne = new Object();
        parkingLot.park(objectOne);

        assertThrows(AlreadyParkedException.class, () -> parkingLot.park(objectOne));
    }

    @Test
    void givenParkingLotWithNoParkedVehicle_WhenUnParkTheVehicle_ThenShouldNotBeAbleToUnParkTheVehicle() {
        ParkingLot parkingLot = new ParkingLot(1, owner);

        assertThrows(VehicleNotFoundException.class, () -> parkingLot.unPark(null));
    }

    @Test
    void givenParkingLotWithOneVehicleParked_whenUnParkTheVehicle_thenShouldBeAbleToUnParkTheVehicle() throws VehicleNotFoundException, AlreadyParkedException, SpaceNotAvailableException {
        ParkingLot parkingLot = new ParkingLot(1, owner);

        Object object = new Object();
        parkingLot.park(object);

        assertEquals(object, parkingLot.unPark(object));
    }

    @Test
    void givenParkingLotWithOneVehicleParked_whenUnParkedNotParkedVehicle_thenShouldThrowException() throws SpaceNotAvailableException, AlreadyParkedException {
        ParkingLot parkingLot = new ParkingLot(2, owner);

        Object objectOne = new Object();
        Object objectTwo = new Object();

        parkingLot.park(objectOne);
        assertThrows(VehicleNotFoundException.class, () -> parkingLot.unPark(objectTwo));
    }


    @Test
    void givenParkingLot_whenFull_thenShouldInformOwner() throws AlreadyParkedException, SpaceNotAvailableException {
        DummyOwner owner = new DummyOwner();
        ParkingLot parkingLot = new ParkingLot(1, owner);

        Object vehicle = new Object();
        parkingLot.park(vehicle);

        assertEquals(1, owner.spaceIsFullInformed);
    }

    @Test
    void givenParkingLotFull_whenInformToOwner_thenShouldGetCalledOnce() throws AlreadyParkedException, SpaceNotAvailableException {
        DummyOwner owner = new DummyOwner();
        ParkingLot parkingLot = new ParkingLot(1, owner);

        Object vehicle = new Object();
        parkingLot.park(vehicle);

        assertEquals(1, owner.spaceIsFullInformed);
    }

    @Test
    void givenParkingLot_WhenParkAndUnParkAndAgainPark_thenShouldGetCalledTwice() throws AlreadyParkedException, SpaceNotAvailableException, VehicleNotFoundException {
        DummyOwner owner = new DummyOwner();
        ParkingLot parkingLot = new ParkingLot(1, owner);

        Object vehicle = new Object();

        parkingLot.park(vehicle);
        parkingLot.unPark(vehicle);
        parkingLot.park(vehicle);

        assertEquals(2, owner.spaceIsFullInformed);
        assertEquals(1, owner.spaceIsAvailableAgainInformed);

    }

    @Test
    void givenParkingLotFull_whenUnParkedTheVehicle_thenOwnerShouldGetInformed() throws AlreadyParkedException, SpaceNotAvailableException, VehicleNotFoundException {
        DummyOwner owner = new DummyOwner();
        ParkingLot parkingLot = new ParkingLot(2, owner);

        Object vehicleOne = new Object();
        Object vehicleTwo = new Object();

        parkingLot.park(vehicleOne);
        parkingLot.park(vehicleTwo);
        parkingLot.unPark(vehicleOne);

        assertEquals(1, owner.spaceIsFullInformed);
        assertEquals(1, owner.spaceIsAvailableAgainInformed);

    }

    @Test
    void GivenParkingLotFullWithCapacityFive_whenGetCount_thenShouldGetCountOfInformed() throws AlreadyParkedException, SpaceNotAvailableException, VehicleNotFoundException {
        DummyOwner owner = new DummyOwner();
        ParkingLot parkingLot = new ParkingLot(5, owner);

        Object vehicleOne = new Object();
        Object vehicleTwo = new Object();
        Object vehicleThree = new Object();
        Object vehicleFour = new Object();
        Object vehicleFive = new Object();

        parkingLot.park(vehicleOne);
        parkingLot.park(vehicleTwo);
        parkingLot.park(vehicleThree);
        parkingLot.park(vehicleFour);
        parkingLot.park(vehicleFive);

        parkingLot.unPark(vehicleOne);
        parkingLot.unPark(vehicleFive);
        parkingLot.unPark(vehicleThree);

        assertEquals(1, owner.spaceIsFullInformed);
        assertEquals(1, owner.spaceIsAvailableAgainInformed);
    }

}
