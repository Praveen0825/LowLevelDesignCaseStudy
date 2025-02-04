package State;

import Entity.VendingMachine;

public class IdleState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine machine, int amount) {
        machine.addBalance(amount);
        machine.setState(new HasMoneyState());
        System.out.println("Money inserted: " + amount);
    }

    @Override
    public void selectItem(VendingMachine machine, String itemCode) {
        throw new IllegalStateException("Insert money first!");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        throw new IllegalStateException("No item selected!");
    }
}