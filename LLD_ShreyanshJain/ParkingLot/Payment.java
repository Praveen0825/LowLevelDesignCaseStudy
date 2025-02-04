public class Payment {
    private double amount;
    private Payment(double amount){
        this.amount=amount;
    }

    public void processPayment(){
        System.out.println("Payment pf Rs."+amount+" processed");
    }
}
