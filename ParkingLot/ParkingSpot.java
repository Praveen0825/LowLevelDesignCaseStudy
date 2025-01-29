package ParkingLot;

public class ParkingSpot {
    private String spotId;
    private VehicleType type;
    private boolean isAvailable;
    private int level;

    public ParkingSpot(String spotId, VehicleType type, boolean isAvailable, int level) {
        this.spotId = spotId;
        this.type = type;
        this.isAvailable = isAvailable;
        this.level = level;
    }
    public boolean occupy(){
        if(isAvailable){
            isAvailable=false;
            return true;
        }
        return false;
    }
    public boolean release(){
        if(!isAvailable){
            isAvailable=true;
            return true;
        }
        return false;
    }

    public String getSpotId() {
        return spotId;
    }

    public VehicleType getType() {
        return type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getLevel() {
        return level;
    }
}
