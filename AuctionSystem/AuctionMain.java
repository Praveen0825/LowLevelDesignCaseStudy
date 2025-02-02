package AuctionSystem;

public class AuctionMain {
    public static void main(String[] args) {
        AuctionSystem system = new AuctionSystem();
        system.addBuyer("buyer1");
        system.addBuyer("buyer2");
        system.addSeller("seller1");
        system.createAuction("A1", 10, 50, 5, "seller1");
        system.createBid("buyer1", "A1", 20);
        system.createBid("buyer2", "A1", 30);
        system.closeAuction("A1");
        system.getProfit("seller1", "A1");
    }
}
