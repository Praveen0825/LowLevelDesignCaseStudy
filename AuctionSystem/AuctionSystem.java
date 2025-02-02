package AuctionSystem;

import java.util.HashMap;
import java.util.Map;

public class AuctionSystem {
    private Map<String,Buyer> buyers=new HashMap<>();
    private Map<String,Seller> sellers=new HashMap<>();
    private Map<String,Auction> auctions=new HashMap<>();

    public void addBuyer(String name){
        buyers.put(name,new Buyer(name));
    }

    public void addSeller(String name){
        sellers.put(name,new Seller(name));
    }

    public void createAuction(String id,int lowestBid,int highestBid,int cost,String sellername){
        Seller seller=sellers.get(sellername);
        if(seller==null){
            throw new AuctionException("seller does exist.");
        }
        auctions.put(id,new Auction(id,lowestBid,highestBid,cost,seller));
    }

    public void createBid(String buyerName, String auctionId,int amount){
        Buyer buyer=buyers.get(buyerName);
        Auction auction=auctions.get(auctionId);
        if(buyer==null||auction==null){
            throw new AuctionException("buyer or Auction does exist.");
        }
        auction.placeBid(buyer,amount);
    }

    public void updateBid(String buyerName, String auctionId, int amount) {
        createBid(buyerName, auctionId, amount);
    }

    public void withdrawBid(String buyerName, String auctionId) {
        Buyer buyer = buyers.get(buyerName);
        Auction auction = auctions.get(auctionId);
        if (buyer == null || auction == null) {
            throw new AuctionException("Buyer or Auction does not exist.");
        }
        auction.withdrawBid(buyer);
    }

    public void closeAuction(String auctionId) {
        Auction auction = auctions.get(auctionId);
        if (auction == null) {
            throw new AuctionException("Auction does not exist.");
        }
        auction.closeAuction();
        auction.getWinningBid().ifPresentOrElse(
                bid -> System.out.println("Winner: " + bid.getBuyer().getName() + " with bid: " + bid.getAmount()),
                () -> System.out.println("No winner"));
    }

    public void getProfit(String sellerName, String auctionId) {
        Auction auction = auctions.get(auctionId);
        if (auction == null) {
            throw new AuctionException("Auction does not exist.");
        }
        System.out.println("Profit/Loss for " + sellerName + ": " + auction.calculateProfit());
    }
}
