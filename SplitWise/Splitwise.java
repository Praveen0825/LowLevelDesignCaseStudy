package SplitWise;

import SplitWise.EqualSplit;
import SplitWise.ExpenseManager;
import SplitWise.Split;

import java.util.ArrayList;
import java.util.List;

public class Splitwise {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();

        User u1 = new User("1", "Alice", "alice@example.com");
        User u2 = new User("2", "Bob", "bob@example.com");
        User u3 = new User("3", "Charlie", "charlie@example.com");

        manager.addUser(u1);
        manager.addUser(u2);
        manager.addUser(u3);

        Group group = new Group("g1", "Friends");
        group.addMember(u1);
        group.addMember(u2);
        group.addMember(u3);
        manager.addGroup(group);

        List<Split> splits = new ArrayList<>();
        splits.add(new EqualSplit(u2));
        splits.add(new EqualSplit(u3));

        manager.addExpense("g1", "e1", u1, 300, "Dinner", splits);
        manager.showBalances();
        manager.showTransactionHistory("g1");
    }
}
