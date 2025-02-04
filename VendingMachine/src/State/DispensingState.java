package State;

import Entity.VendingMachine;

public class DispensingState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine machine, int amount) {
        throw new IllegalStateException("Already dispensing item!");
    }

    @Override
    public void selectItem(VendingMachine machine, String itemCode) {
        throw new IllegalStateException("Already processing an item!");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        machine.dispenseSelectedItem();
        machine.setState(new IdleState());
    }
}
