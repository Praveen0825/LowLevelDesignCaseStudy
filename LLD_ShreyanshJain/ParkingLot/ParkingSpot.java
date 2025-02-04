public class ParkingSpot {
    private String spotNumber;
    private VehicleType spotType;
    private boolean isAvailable;

    public ParkingSpot(String spotNumber, VehicleType spotType, boolean isAvailable) {
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        this.isAvailable = isAvailable;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void parkVehicle(){
        this.isAvailable=false;
    }
    public void removeVehicle(){
        this.isAvailable=true;
    }
}
