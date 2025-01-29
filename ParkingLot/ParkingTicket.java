package ParkingLot;

public class ParkingTicket {
    private String ticketId;
    public Vehicle vehicle;
    private ParkingSpot spot;
    private long entryTime;
    private long exitTime;

    public ParkingTicket(String ticketId, Vehicle vehicle, ParkingSpot spot, long entryTime) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = entryTime;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }
}
