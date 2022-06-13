package practice.implementaions.Splitwise.apis;


import practice.implementaions.Splitwise.enums.ExpenseType;
import practice.implementaions.Splitwise.exceptions.ExpenseTypeNotFoundException;
import practice.implementaions.Splitwise.exceptions.UserNotFoundException;
import practice.implementaions.Splitwise.models.ExpenseMeta;
import practice.implementaions.Splitwise.models.Split;

import java.util.List;

public interface Splitwise2 {

    void addExpense(ExpenseType expenseType, double amount, Integer userId,
                    List<Split> splits, ExpenseMeta expenseMetaInfo) throws UserNotFoundException, ExpenseTypeNotFoundException;

    void showBalance();

    void showBalance(Integer userId);

}
