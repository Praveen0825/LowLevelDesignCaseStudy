package Entity;

import Factory.ItemFactory;
import State.IdleState;
import State.VendingMachineState;

import java.util.*;

public class VendingMachine {
    private VendingMachineState state;
    private Map<String, Item> items = new HashMap<>();
    private Map<String, Integer> inventory = new HashMap<>();
    private int balance = 0;
    private String selectedItem;

    public VendingMachine() {
        this.state = new IdleState();
        items.put("A1", ItemFactory.createItem("chips"));
        items.put("B1", ItemFactory.createItem("soda"));
        items.put("C1", ItemFactory.createItem("chocolate"));
        inventory.put("A1", 10);
        inventory.put("B1", 10);
        inventory.put("C1", 10);
    }

    public void setState(VendingMachineState state) { this.state = state; }
    public void addBalance(int amount) { this.balance += amount; }
    public void setSelectedItem(String itemCode) { this.selectedItem = itemCode; }
    public boolean isItemAvailable(String itemCode) { return inventory.getOrDefault(itemCode, 0) > 0; }

    public void insertCoin(int amount) { state.insertCoin(this, amount); }
    public void selectItem(String itemCode) { state.selectItem(this, itemCode); }
    public void dispenseItem() { state.dispenseItem(this); }

    public void dispenseSelectedItem() {
        Item item = items.get(selectedItem);
        if (balance < item.getPrice()) {
            throw new IllegalStateException("Insufficient balance to purchase item!");
        }
        if (inventory.get(selectedItem) > 0) {
            inventory.put(selectedItem, inventory.get(selectedItem) - 1);
        }
        int change = balance - item.getPrice();
        balance = 0;
        System.out.println("Dispensing item: " + item.getName());
        System.out.println("Remaining stock: " + inventory.get(selectedItem));
        System.out.println("Returning change: " + change);
        selectedItem = null;
    }
}