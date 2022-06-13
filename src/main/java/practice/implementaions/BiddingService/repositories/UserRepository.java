package practice.implementaions.BiddingService.repositories;

import exceptions.SellerAlreadyExists;
import models.Seller;
import models.User;

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
