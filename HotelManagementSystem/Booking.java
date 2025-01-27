package HotelManagementSystem;

import java.util.Date;
import java.time.LocalDate;

public class Booking {
    int bookingId;
    Customer customer;
    Room room;
    LocalDate checkOutDate;
    LocalDate checkInDate;

    public Booking(int bookingId, Customer customer, Room room, LocalDate checkOutDate, LocalDate checkInDate) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.room = room;
        this.checkOutDate = checkOutDate;
        this.checkInDate = checkInDate;
    }

}
