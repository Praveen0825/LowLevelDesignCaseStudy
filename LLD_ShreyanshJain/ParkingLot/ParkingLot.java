import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> floors;
    private String location;

    public ParkingLot(String location){
        this.location=location;
        floors=new ArrayList<>();
    }
    public void addFloor(ParkingFloor floor){
        floors.add(floor);
    }
    public ParkingSpot assignSpot(Vehicle vehicle){
        for(ParkingFloor floor:floors){
            ParkingSpot spot=floor.findFreeSpot(vehicle.getVehicleType());
            if(spot!=null){
                spot.parkVehicle();
                return spot;
            }
        }
        return null;
    }

    public void freeSpot(ParkingSpot spot){
        spot.removeVehicle();
    }

}
