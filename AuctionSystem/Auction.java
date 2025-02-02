package AuctionSystem;

import java.util.*;

public class Auction {
    private String id;
    private int lowestBidLimit,highestBidLimit,participationCost;
    private Seller seller;
    private AuctionStatus status;
    private Map<Buyer,Bid> bids;
    private Set<Buyer> buyers;

    public Auction(String id, int lowestBidLimit, int highestBidLimit, int participationCost, Seller seller) {
        if (lowestBidLimit > highestBidLimit) {
            throw new AuctionException("Lowest bid limit cannot be greater than highest bid limit.");
        }
        this.id = id;
        this.lowestBidLimit = lowestBidLimit;
        this.highestBidLimit = highestBidLimit;
        this.participationCost = participationCost;
        this.seller = seller;
        this.status = AuctionStatus.OPEN;
        this.bids = new HashMap<>();
        this.buyers = new HashSet<>();
    }
    public void placeBid(Buyer buyer,int amount){
        if(status==AuctionStatus.CLOSED){
            throw new AuctionException("Cannot place bid. Auction is closed.");
        }
        if(amount<lowestBidLimit || amount > highestBidLimit){
            throw new AuctionException("Bid amount is out of range.");
        }
        bids.put(buyer,new Bid(buyer,amount));
        buyers.add(buyer);
        buyer.incrementParticipation();
    }

    public void withdrawBid(Buyer buyer){
        if(!bids.containsKey(buyer)){
            throw new AuctionException("no Bid found for this buyer");
        }
        bids.remove(buyer);
    }

    public void closeAuction(){
        status=AuctionStatus.CLOSED;
    }

    public Optional<Bid> getWinningBid(){
        Map<Integer, List<Buyer>> bidFreq=new HashMap<>();
        for(Map.Entry<Buyer,Bid> bid: bids.entrySet()){
            bidFreq.putIfAbsent(bid.getValue().getAmount(), new ArrayList<>());
            bidFreq.get(bid.getValue().getAmount()).add(bid.getValue().getBuyer());
        }
        return bidFreq.entrySet().stream()
                .filter(entry -> entry.getValue().size() == 1)
                .max(Map.Entry.comparingByKey())
                .map(entry -> new Bid(entry.getValue().get(0), entry.getKey()));
    }

    public double calculateProfit() {
        double participationProfit = buyers.size() * 0.2 * participationCost;
        double baseCost = (lowestBidLimit + highestBidLimit) / 2.0;
        return getWinningBid().map(Bid::getAmount).orElse(0) + participationProfit - baseCost;
    }
}
