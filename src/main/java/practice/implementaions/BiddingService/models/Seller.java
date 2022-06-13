package practice.implementaions.BiddingService.models;

import java.util.List;

public class Seller extends User {

    private List<Auction> auctions;

    public Seller(int id, String name, List<Auction> auction) {
        super(id, name);
        this.auctions = auction;
    }

    public List<Auction> getAuctions() {
        return auctions;
    }

    public void addAuction(Auction auction){
        auctions.add(auction);
    }
}
