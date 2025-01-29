package ParkingLot;

public class EntryPoint {
    private ParkingLot parkingLot;

    public EntryPoint(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket enter(Vehicle vehicle) {
        return parkingLot.assignSpot(vehicle);
    }
}

