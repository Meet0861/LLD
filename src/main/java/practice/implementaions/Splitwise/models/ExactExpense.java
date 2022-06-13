package practice.implementaions.Splitwise.models;

import java.util.List;

public class ExactExpense extends Expense {

    public ExactExpense(int id, ExpenseMeta expenseInfo, User paidBy, double amount, List<Split> splits) {
        super(id, expenseInfo, paidBy, amount, splits);
    }

    @Override
    public boolean verifyExpense() {
        double total = getAmount();
        double sum = 0;
        for (Split split : getSplits()) {
            ExactSplit exactSplit = (ExactSplit) split;
            sum += exactSplit.getAmount();
        }

        if (total != sum)
            return false;
        return true;
    }
}
