package practice.implementaions.BiddingService.models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Auction {
    private int id;
    private List<Bid> bids;
    private float lowestPrice;
    private float highestPrice;
    private Timestamp finalizationTime;
    private Item item;
    private Timestamp startTime;
    private User auctionBy;
    private float profit;

    public Auction(int id, float lowestPrice, float highestPrice, Timestamp finalizationTime, Item item, Timestamp startTime, User auctionBy) {
        this.id = id;
        this.lowestPrice = lowestPrice;
        this.highestPrice = highestPrice;
        this.finalizationTime = finalizationTime;
        this.item = item;
        this.bids = new ArrayList<>();
        this.startTime = startTime;
        this.auctionBy = auctionBy;
        profit = 0;
    }

    public float getLowestPrice() {
        return lowestPrice;
    }

    public float getHighestPrice() {
        return highestPrice;
    }

    public Timestamp getFinalizationTime() {
        return finalizationTime;
    }

    public Item getItem() {
        return item;
    }



    public void addBid(Bid bid){
        bids.add(bid);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }


    public User getAuctionBy() {
        return auctionBy;
    }

    public void setAuctionBy(User auctionBy) {
        this.auctionBy = auctionBy;
    }


    public List<Bid> getBids() {
        return bids;
    }


    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }
}
