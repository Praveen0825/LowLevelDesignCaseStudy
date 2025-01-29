package ParkingLot;

public class DigitalWalletPayment implements Payment{
    private String walletId;
    public DigitalWalletPayment(String walletId){
        this.walletId=walletId;
    }


    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}
