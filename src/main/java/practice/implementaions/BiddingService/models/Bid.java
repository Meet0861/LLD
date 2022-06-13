package practice.implementaions.BiddingService.models;

import enums.BidStatus;

public class Bid {
    private int id;
    private Buyer buyer;
    private BidStatus bidStatus;
    private float proposedPrice;

    public Bid(int id) {
        this.id = id;
        this.bidStatus = BidStatus.PENDING;
    }

    public int getId() {
        return id;
    }

    public BidStatus getBidStatus() {
        return bidStatus;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public void setBidStatus(BidStatus bidStatus) {
        this.bidStatus = bidStatus;
    }
}
