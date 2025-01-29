package ParkingLot;

public class ExitPoint {
    private ParkingLot parkingLot;
    private FeeCalculator feeCalculator;

    public ExitPoint(ParkingLot parkingLot, FeeCalculator feeCalculator) {
        this.parkingLot = parkingLot;
        this.feeCalculator = feeCalculator;
    }
    public void exit(ParkingTicket ticket, Payment payment) {
        double amount = feeCalculator.calculateFee(ticket);
        if (payment.processPayment(amount)) {
            parkingLot.releaseSpot(ticket);
            ticket.setExitTime(System.currentTimeMillis());
        } else {
            throw new RuntimeException("Payment failed!");
        }
    }
}
