package ParkingLot;

import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private List<Level> levels;
    private ParkingLot(List<Level> levels){
        this.levels=levels;
    }
    public static synchronized ParkingLot getInstance(List<Level> levels){
        if(instance==null){
            instance=new ParkingLot(levels);
        }
        return instance;
    }
    public ParkingTicket assignSpot(Vehicle vehicle) {
        for (Level level : levels) {
            ParkingSpot spot = level.findAndOccupySpot(vehicle.getType());
            if (spot != null) {
                return new ParkingTicket("abc",vehicle, spot, System.currentTimeMillis());
            }
        }
        return null; // No available spots
    }

    public void releaseSpot(ParkingTicket ticket) {
        ParkingSpot spot = ticket.getSpot();
        Level level = levels.get(spot.getLevel() - 1);
        level.releaseSpot(spot);
    }

    public int getAvailableSpots(VehicleType type) {
        return levels.stream()
                .mapToInt(level -> level.getAvailableSpots(type))
                .sum();
    }

}
