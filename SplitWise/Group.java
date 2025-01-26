package SplitWise;

import SplitWise.Expense;
import SplitWise.User;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupId;
    private String groupName;
    private List<User> members;
    private List<Expense> expenses;

    public Group(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.members = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }
    public void addMember(User user){
        members.add(user);
    }
    public void addExpense(Expense expense){
        expenses.add(expense);
    }

    public String getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<User> getMembers() {
        return members;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }
}
