package HotelManagementSystem;

import java.time.LocalDate;

public class HotelManagementApp {
    public static void main(String[] args) {
        HotelManagementSystem system = new HotelManagementSystem();

        // Adding Rooms
        system.addRoom(new Room(101, RoomType.STANDARD));
        system.addRoom(new Room(102, RoomType.DELUXE));
        system.addRoom(new Room(103, RoomType.FAMILY_SUITE));

        // Adding Customers
        system.addCustomer(new Customer(1, "Alice", "alice@example.com"));
        system.addCustomer(new Customer(2, "Bob", "bob@example.com"));

        // Booking a Room
        system.bookRoom(1, 1, 101, LocalDate.now().plusDays(2), LocalDate.now().plusDays(5), 5000.0, PaymentMode.CREDIT_CARD);


        // Sending Reminders
        system.sendReminders();

        // Cancelling a Booking
        system.cancelBooking(1, 5000.0, PaymentMode.CREDIT_CARD);

    }
}
