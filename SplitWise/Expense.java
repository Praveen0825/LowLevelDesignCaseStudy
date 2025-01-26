package SplitWise;

import java.util.List;

public class Expense {
    private String expenseId;
    private User paidBy;
    private double amount;
    private String description;
    private List<Split> splits;

    public Expense(String expenseId, User paidBy, double amount, String description, List<Split> splits) {
        this.expenseId = expenseId;
        this.paidBy = paidBy;
        this.amount = amount;
        this.description = description;
        this.splits = splits;
    }


    public String getExpenseId() {
        return expenseId;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public List<Split> getSplits() {
        return splits;
    }
}
