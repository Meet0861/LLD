package practice.implementaions.Splitwise.apis.impl;


import practice.implementaions.Splitwise.apis.Splitwise2;
import practice.implementaions.Splitwise.enums.ExpenseType;
import practice.implementaions.Splitwise.exceptions.ExpenseTypeNotFoundException;
import practice.implementaions.Splitwise.exceptions.UserNotFoundException;
import practice.implementaions.Splitwise.models.ExpenseMeta;
import practice.implementaions.Splitwise.models.Split;
import practice.implementaions.Splitwise.services.ExpenseService;

import java.util.List;

public class Splitwise2Impl implements Splitwise2 {

    private static ExpenseService expenseService;

    public Splitwise2Impl() {
        expenseService = new ExpenseService();
    }

    @Override
    public void addExpense(ExpenseType expenseType, double amount, Integer userId, List<Split> splits, ExpenseMeta expenseMetaInfo) throws UserNotFoundException, ExpenseTypeNotFoundException {
        expenseService.createExpense(expenseType, amount, userId, splits, expenseMetaInfo);
    }

    @Override
    public void showBalance() {
        expenseService.showBalance();
    }

    @Override
    public void showBalance(Integer userId) {
        expenseService.showBalance(userId);
    }
}
