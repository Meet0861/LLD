package practice.implementaions.BiddingService.repositories;


import practice.implementaions.BiddingService.exceptions.SellerAlreadyExists;
import practice.implementaions.BiddingService.models.Seller;
import practice.implementaions.BiddingService.models.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UserRepository {

    private static Set<User> users;
    private static int userId = 1;

    public UserRepository() {
        users = new HashSet<>();
    }

    public User addSeller(String userName) throws SellerAlreadyExists {
        User user = new Seller(userId++, userName, new ArrayList<>());
        users.add(user);
        return user;
    }

}
