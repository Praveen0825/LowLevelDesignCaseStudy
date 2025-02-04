import java.security.PublicKey;
import java.time.LocalDateTime;

public class ParkingTicket {
    private String ticketNumber;
    public Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private LocalDateTime entryTime;

    public ParkingTicket(String ticketNumber, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketNumber = ticketNumber;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime=LocalDateTime.now();
    }
    public long calculatingParkingDuration(){
        return java.time.Duration.between(entryTime, LocalDateTime.now()).toMinutes();
    }

    public double calculateFee(){
        long duration = calculatingParkingDuration();
        return duration*5;
    }
}
