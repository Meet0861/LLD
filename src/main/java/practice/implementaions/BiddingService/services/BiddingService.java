package practice.implementaions.BiddingService.services;

import exceptions.SellerAlreadyExists;
import models.Auction;
import models.Bid;
import models.Item;
import models.User;
import repositories.UserRepository;

import java.sql.Timestamp;

public class BiddingService {

    private UserRepository userRepository;

    public BiddingService() {
        userRepository = new UserRepository();
    }

    private int itemId = 1;
    private int bidId = 1;

    void createAuction(String userName, String itemName, float itemPrice, float lowestBidPrice,
                   float highestBudPrice, Timestamp finalizationTime) throws SellerAlreadyExists {
        Item item = new Item(itemId++, itemName, itemPrice);
        Bid bid = new Bid(bidId++);
        User user = userRepository.addSeller(userName);
        Auction auction = new Auction(bidId++, lowestBidPrice, highestBudPrice, finalizationTime, item
        , new Timestamp(System.currentTimeMillis()), user);
    }



}
