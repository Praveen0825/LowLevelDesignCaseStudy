package HotelManagementSystem;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HotelManagementSystem {
    Map<Integer,Room> rooms;
    Map<Integer,Customer> customers;
    Map<Integer,Booking> bookings;
    NotificationService notificationService;
    

    public HotelManagementSystem() {
        this.rooms = new HashMap<>();
        this.customers=new HashMap<>();
        this.bookings=new HashMap<>();
        this.notificationService=new NotificationService();
    }
    public void addRoom(Room room){
        rooms.put(room.roomId, room);
    }
    public void addCustomer(Customer customer){
        customers.put(customer.customerId,customer);
    }
    public Room searchAvailableRoom(RoomType type){
        for(Room room: rooms.values()){
            if(room.isAvailable && room.type==type){
                return room;
            }
        }
        return null;
    }
    public void bookRoom(int bookingId, int customerId, int roomId, LocalDate checkInDate, LocalDate checkOutDate, double amount, PaymentMode mode) {
        Customer customer = customers.get(customerId);
        Room room = rooms.get(roomId);

        if (room != null && customer != null && room.isAvailable) {
            room.isAvailable = false;

            // Process Payment
            PaymentService paymentService = new PaymentService();
            paymentService.processPayment(customer, amount, mode);

            // Create Booking
            Booking booking = new Booking(bookingId, customer, room, checkInDate, checkOutDate);
            bookings.put(bookingId, booking);

            System.out.println("Room booked successfully for customer: " + customer.name);
        } else {
            System.out.println("Booking failed. Room is not available or customer not found.");
        }
    }

    public void cancelBooking(int bookingId, double refundAmount, PaymentMode mode) {
        Booking booking = bookings.get(bookingId);

        if (booking != null) {
            if (LocalDate.now().isBefore(booking.checkInDate.minusDays(1))) {
                bookings.remove(bookingId);
                booking.room.isAvailable = true;

                // Process Refund
                PaymentService paymentService = new PaymentService();
                paymentService.processPayment(booking.customer, refundAmount, mode);

                System.out.println("Booking cancelled. Full refund issued.");
            } else {
                System.out.println("Cancellation not eligible for a refund.");
            }
        } else {
            System.out.println("Invalid booking ID.");
        }
    }


    public void sendReminders(){
        for(Booking booking: bookings.values()){
            if (LocalDate.now().equals(booking.checkInDate.minusDays(1))) {
                notificationService.sendNotification(booking.customer, NotificationType.CHECK_IN_REMINDER);
            }
            if (LocalDate.now().equals(booking.checkOutDate.minusDays(1))) {
                notificationService.sendNotification(booking.customer, NotificationType.CHECK_OUT_REMINDER);
            }
        }
    }
}
