package practice.implementaions.Splitwise.models;

import java.util.List;

public class EqualExpense extends Expense {

    public EqualExpense(int id, ExpenseMeta expenseInfo, User paidBy, double amount, List<Split> splits) {
        super(id, expenseInfo, paidBy, amount, splits);
    }

    @Override
    public boolean verifyExpense() {
        //TODO
        return true;
    }


}
