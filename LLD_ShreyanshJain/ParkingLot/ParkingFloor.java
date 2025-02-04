import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private String floorNumber;
    private List<ParkingSpot> spots;

    public ParkingFloor(String floorNumber) {
        this.floorNumber = floorNumber;
        spots=new ArrayList<>();
    }
    public void addParkingSpot(ParkingSpot spot){
        spots.add(spot);
    }

    public ParkingSpot findFreeSpot(VehicleType type){
        for(ParkingSpot spot: spots){
            if(spot.isAvailable()&&spot.getSpotType()==type){
                return spot;
            }
        }
        return null;
    }
}
