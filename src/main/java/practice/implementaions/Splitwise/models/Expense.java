package practice.implementaions.Splitwise.models;

import java.util.List;

public abstract class Expense {
    private int id;
    private ExpenseMeta expenseInfo;
    private User paidBy;
    private double amount;
    private List<Split> splits;

    public Expense(int id, ExpenseMeta expenseInfo, User paidBy, double amount, List<Split> splits) {
        this.id = id;
        this.expenseInfo = expenseInfo;
        this.paidBy = paidBy;
        this.amount = amount;
        this.splits = splits;
    }

    public abstract boolean verifyExpense();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ExpenseMeta getExpenseInfo() {
        return expenseInfo;
    }

    public void setExpenseInfo(ExpenseMeta expenseInfo) {
        this.expenseInfo = expenseInfo;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }
}
