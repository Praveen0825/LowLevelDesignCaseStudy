package HotelManagementSystem;

public class Room {
    int roomId;
    RoomType type;
    boolean isAvailable;

    public Room(int roomId, RoomType type) {
        this.roomId = roomId;
        this.type = type;
        this.isAvailable = true;
    }

    public int getRoomId() {
        return roomId;
    }

    public RoomType getType() {
        return type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
