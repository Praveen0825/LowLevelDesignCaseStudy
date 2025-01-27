package HotelManagementSystem;

public class NotificationService {
    public void sendNotification(Customer customer, NotificationType notificationType){
        switch (notificationType){
            case CHECK_IN_REMINDER:
                System.out.println("Reminder: Dear "+ customer.name + ", your check-in date is approaching.");
            case CHECK_OUT_REMINDER:
                System.out.println("Reminder: Dear "+ customer.name + ", your check-out date is approaching.");
        }
    }
}
