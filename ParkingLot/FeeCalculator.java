package ParkingLot;

public class FeeCalculator {
    private static final double CAR_RATE = 5.0;
    private static final double TRUCK_RATE = 10.0;
    private static final double MOTORCYCLE_RATE = 3.0;

    public double calculateFee(ParkingTicket ticket) {
        long durationMillis = System.currentTimeMillis() - ticket.getEntryTime();
        double hours = Math.ceil(durationMillis / (1000.0 * 60 * 60));

        return switch (ticket.getVehicle().getType()) {
            case CAR -> hours * CAR_RATE;
            case TRUCK -> hours * TRUCK_RATE;
            case MOTORCYCLE -> hours * MOTORCYCLE_RATE;
        };
    }
}
