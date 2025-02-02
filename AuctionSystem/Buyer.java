package AuctionSystem;

public class Buyer extends User{
    private int participationCnt;
    public Buyer(String name) {
        super(name);
        this.participationCnt = 0;
    }
    public void incrementParticipation() {
        participationCnt++;
    }
    public boolean isPreferredBuyer() {
        return participationCnt > 2;
    }
}
