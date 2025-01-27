package HotelManagementSystem;

public class PaymentService {
    public void processPayment(Customer customer,Double amount, PaymentMode mode){
        System.out.println("Payment of " + amount + " by " + mode + " processed for " + customer.name);
    }
}
