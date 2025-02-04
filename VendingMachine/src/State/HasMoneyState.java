package State;

import Entity.VendingMachine;

public class HasMoneyState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine machine, int amount) {
        machine.addBalance(amount);
        System.out.println("Money inserted: " + amount);
    }

    @Override
    public void selectItem(VendingMachine machine, String itemCode) {
        if (machine.isItemAvailable(itemCode)) {
            machine.setSelectedItem(itemCode);
            machine.setState(new DispensingState());
            System.out.println("Item Selected: " + itemCode);
        } else {
            throw new IllegalArgumentException("Item not available");
        }
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        throw new IllegalStateException("Select an item first!");
    }
}