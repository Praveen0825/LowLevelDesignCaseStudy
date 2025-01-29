package ParkingLot;

public class CreditCardPayment implements Payment{
    private String cardNumber;
    public String expiryDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public boolean processPayment(double amount){
        //payment integration
        return true;
    }
}
