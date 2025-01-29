package ParkingLot;

import java.util.Arrays;
import java.util.List;

public class ParkingLotSystem {
    public static void main(String[] arg){
        List<ParkingSpot> level1Spots = Arrays.asList(
                new ParkingSpot("L1-S1", VehicleType.CAR, 1),
                new ParkingSpot("L1-S2", VehicleType.TRUCK, 1)
        );
        Level level1 = new Level(1, level1Spots);
        ParkingLot parkingLot = ParkingLot.getInstance(List.of(level1));
        FeeCalculator feeCalculator = new FeeCalculator();

// Create entry/exit points
        EntryPoint entry = new EntryPoint(parkingLot);
        ExitPoint exit = new ExitPoint(parkingLot, feeCalculator);

// Vehicle enters
        Vehicle car = new Car("ABC123");
        ParkingTicket ticket = entry.enter(car);

// Vehicle exits with credit card payment
        Payment payment = new CreditCardPayment("1234-5678-9012-3456", "12/25", "123");
        exit.exit(ticket, payment);
    }
}
