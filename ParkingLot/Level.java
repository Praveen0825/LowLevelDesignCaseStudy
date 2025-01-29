package ParkingLot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Level {
    private int levelNumber;
    private List<ParkingSpot> spots;
    private Map<VehicleType,Integer> availableSpots;
    public Level(int levelNumber, List<ParkingSpot> spots){
        this.levelNumber=levelNumber;
        this.spots=spots;
        availableSpots=new HashMap<>();
        availableSpots.put(VehicleType.CAR,0);
        availableSpots.put(VehicleType.MOTORCYCLE,0);
        availableSpots.put(VehicleType.TRUCK,0);
        for(ParkingSpot spot:spots){
            availableSpots.put(spot.getType(),availableSpots.get(spot.getType())+1);
        }
    }
    public synchronized ParkingSpot findAndOccupySpot(VehicleType type){
        if(availableSpots.get(type)<=0)
            return null;

        for(ParkingSpot spot:spots){
            if(spot.getType()==type && spot.isAvailable()){
                availableSpots.put(type,availableSpots.get(type)-1);
                return spot;
            }
        }
        return null;
    }
    public synchronized void releaseSpot(ParkingSpot spot){
        if(spot.release()){
            availableSpots.put(spot.getType(),availableSpots.get(spot.getType())+1);
        }
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public Integer getAvailableSpots(VehicleType type) {
        return availableSpots.get(type);
    }
}
