package practice.implementaions.Splitwise.repositories;


import practice.implementaions.Splitwise.exceptions.UserNotFoundException;
import practice.implementaions.Splitwise.models.Expense;
import practice.implementaions.Splitwise.models.Split;
import practice.implementaions.Splitwise.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseRepository {
    private static Map<Integer, User> usersByIdMap;
    private static Map<Integer, Map<Integer, Double>> balance;
    private static List<Expense> expenseList;
    private static int userId = 1;

    public ExpenseRepository() {
        usersByIdMap = new HashMap<>();
        expenseList = new ArrayList<>();
        balance = new HashMap<>();
    }


    public void addUser(String userName, String emailId, String conatct) {
        User user = new User(userId++, userName, emailId, conatct);
        usersByIdMap.put(user.getId(), user);
        HashMap<Integer, Double> map = new HashMap<>();
        balance.put(user.getId(), map);
    }

    public User getUserById(Integer userId) throws UserNotFoundException {
        if (usersByIdMap.containsKey(userId))
            return usersByIdMap.get(userId);
        else throw new UserNotFoundException("User Not exists...Please add User to continue");
    }

    public void addExpense(Expense expense) {
        expenseList.add(expense);
        List<Split> splitList = expense.getSplits();
        for (Split split : splitList) {
            Integer userid = split.getUser().getId();
            Map<Integer, Double> remainingBalance = balance.get(userid);
            if (!remainingBalance.containsKey(userid)) {
                remainingBalance.put(userid, 0.0);
            }
            remainingBalance.put(userid, remainingBalance.get(userid) + split.getAmount());

            if (!remainingBalance.containsKey(userid)) {
                remainingBalance.put(userid, 0.0);
            }
            remainingBalance.put(userid, remainingBalance.get(userid) - split.getAmount());
        }
    }

    public Map<Integer, Map<Integer, Double>> getBalanceSheet() {
        return balance;
    }

}
