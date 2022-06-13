package practice.implementaions.BiddingService.apis.impl;


import practice.implementaions.BiddingService.apis.BiddingSystem;
import practice.implementaions.BiddingService.services.BiddingService;

import java.sql.Timestamp;

public class BiddingSystemImpl implements BiddingSystem {

    private static BiddingService biddingService;

    public BiddingSystemImpl() {
        biddingService = new BiddingService();
    }

    @Override
    public void createAuction(String userName, String itemName, String itemPrice, float lowestBidPrice, float highestBudPrice, Timestamp finalizationTime) {

    }

    @Override
    public float getProfit(int sellerId, int auctionId) {
        return 0;
    }
}
