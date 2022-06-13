package practice.implementaions.BiddingService.apis;

import java.sql.Timestamp;

public interface BiddingSystem {

    void createAuction(String userName, String itemName, String itemPrice, float lowestBidPrice,
                       float highestBudPrice, Timestamp finalizationTime);

    float getProfit(int sellerId, int auctionId);

}
