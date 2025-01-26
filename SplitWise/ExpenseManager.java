package SplitWise;

import SplitWise.EqualSplit;
import SplitWise.Expense;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    private Map<String, User> users;
    private Map<String, Group> groups;
    private Map<String,Map<String,Double>> balances;

    public ExpenseManager() {
        this.users = new HashMap<>();
        this.groups = new HashMap<>();
        this.balances = new HashMap<>();
    }
    public void addUser(User user){
        users.put(user.getUserId(),user);
        balances.put(user.getUserId(),new HashMap<>());
    }
    public void addGroup(Group group){
        groups.put(group.getGroupId(),group);
    }
    public void addExpense(String groupId, String expenseId, User paidBy, double amount, String description, List<Split> splits){
        Group group=groups.get(groupId);
        if(group==null){
            System.out.println("group does not exist");
            return;
        }
        Expense expense=new Expense(expenseId,paidBy,amount,description,splits);
        group.addExpense(expense);
        for(Split split : splits){
            String paidTo =split.getUser().getUserId();
            double splitAmount=0;
            if(split instanceof EqualSplit){
                splitAmount=amount/splits.size();
            } else if (split instanceof PercentageSplit) {
                splitAmount=amount*((PercentageSplit)split).getPercentage()/100;
            }
            balances.get(paidBy.getUserId()).put(paidTo,balances.get(paidBy.getUserId()).getOrDefault(paidTo, 0.0) - splitAmount);
            balances.get(paidTo).put(paidBy.getUserId(),balances.get(paidTo).getOrDefault(paidBy.getUserId(), 0.0) + splitAmount);
        }
    }
    public void showBalances() {
        for (String user : balances.keySet()) {
            for (Map.Entry<String, Double> entry : balances.get(user).entrySet()) {
                if (entry.getValue() != 0) {
                    System.out.println(users.get(user).getName() + " owes " +
                            users.get(entry.getKey()).getName() + ": " + entry.getValue());
                }
            }
        }
    }

    public void showTransactionHistory(String groupId) {
        Group group = groups.get(groupId);
        if (group == null) {
            System.out.println("Group not found.");
            return;
        }

        System.out.println("Transaction history for group: " + groupId);
        for (Expense expense : group.getExpenses()) {
            System.out.println(expense.getDescription() + " - Amount: " + expense.getSplits().size());
        }
    }

}
