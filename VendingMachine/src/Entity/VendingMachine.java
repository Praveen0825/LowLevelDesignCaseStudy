package Entity;

import Factory.ItemFactory;
import State.IdleState;
import State.VendingMachineState;

import java.util.*;

public class VendingMachine {
    private VendingMachineState state;
    private Map<String, Item> inventory = new HashMap<>();
    private int balance = 0;
    private String selectedItem;

    public VendingMachine() {
        this.state = new IdleState();
        inventory.put("A1", ItemFactory.createItem("chips"));
        inventory.put("B1", ItemFactory.createItem("soda"));
        inventory.put("C1", ItemFactory.createItem("chocolate"));
    }

    public void setState(VendingMachineState state) { this.state = state; }
    public void addBalance(int amount) { this.balance += amount; }
    public void setSelectedItem(String itemCode) { this.selectedItem = itemCode; }
    public boolean isItemAvailable(String itemCode) { return inventory.containsKey(itemCode); }

    public void insertCoin(int amount) { state.insertCoin(this, amount); }
    public void selectItem(String itemCode) { state.selectItem(this, itemCode); }
    public void dispenseItem() { state.dispenseItem(this); }

    public void dispenseSelectedItem() {
        Item item = inventory.get(selectedItem);
        if (item.getPrice() > balance) {
            throw new IllegalStateException("Insufficient balance!");
        }
        balance -= item.getPrice();
        System.out.println("Dispensing: " + item.getName());
        System.out.println("Remaining balance: " + balance);
        selectedItem = null;
    }
}