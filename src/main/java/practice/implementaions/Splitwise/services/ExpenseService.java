package practice.implementaions.Splitwise.services;


import practice.implementaions.Splitwise.enums.ExpenseType;
import practice.implementaions.Splitwise.exceptions.ExpenseTypeNotFoundException;
import practice.implementaions.Splitwise.exceptions.UserNotFoundException;
import practice.implementaions.Splitwise.models.*;
import practice.implementaions.Splitwise.repositories.ExpenseRepository;

import java.util.List;
import java.util.Map;

public class ExpenseService {

    private static int expenseId = 1;
    private ExpenseRepository expenseRepository;

    public ExpenseService() {
        expenseRepository = new ExpenseRepository();
    }

    public void createUser(String userName, String emailId, String conatct) {
        expenseRepository.addUser(userName, emailId, conatct);
    }

    public Expense createExpense(ExpenseType expenseType, double amount, Integer userId,
                                 List<Split> splits, ExpenseMeta expenseMetaInfo) throws ExpenseTypeNotFoundException, UserNotFoundException {
        User paidBy = expenseRepository.getUserById(userId);
        Expense expense;
        switch (expenseType) {
            case EQUAL:
                int totalSplits = splits.size();
                double splitAmount = Math.round(amount * 100 / totalSplits) / 100.0;
                for (Split split : splits) {
                    split.setAmount(splitAmount);
                }
                Split firstUserSplit = splits.get(0);
                firstUserSplit.setAmount(splitAmount + (amount - splitAmount * totalSplits));
                expense = new EqualExpense(expenseId++, expenseMetaInfo, paidBy, amount, splits);
                expenseRepository.addExpense(expense);
                return expense;
            case EXACT:
                expense = new ExactExpense(expenseId++, expenseMetaInfo, paidBy, amount, splits);
                expenseRepository.addExpense(expense);
                return expense;
            default:
                throw new ExpenseTypeNotFoundException("Please Enter a valid Expense Type...");
        }
    }

    public void showBalance() {
        Map<Integer, Map<Integer, Double>> balanceSheet = expenseRepository.getBalanceSheet();
        if (balanceSheet.size() == 0) System.out.println("NO BALANCE");
        for (Map.Entry<Integer, Map<Integer, Double>> balances : balanceSheet.entrySet()) {
            for (Map.Entry<Integer, Double> balance : balances.getValue().entrySet()) {
                Integer user1 = balances.getKey();
                Integer user2 = balance.getKey();
                Double value = balance.getValue();
                if (value < 0)
                    System.out.println(user1 + " owes " + user2 + " " + value);
                else
                    System.out.println(user2 + " owes " + user1 + "  " + value);
            }
        }
    }

    public void showBalance(Integer userId) {
        Map<Integer, Map<Integer, Double>> balanceSheet = expenseRepository.getBalanceSheet();
        for (Map.Entry<Integer, Double> balance : balanceSheet.get(userId).entrySet()) {
            if (balance.getValue() == 0)
                System.out.println("NO Balance");
            else {
                Integer user2 = balance.getKey();
                Double amount = balance.getValue();
                if (amount < 0)
                    System.out.println(userId + " owes " + user2 + amount);
                else
                    System.out.println(user2 + " owes " + userId + amount);
            }
        }
    }


}
