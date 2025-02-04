package State;
import Entity.VendingMachine;

public interface VendingMachineState {
    void insertCoin(VendingMachine machine, int amount);
    void selectItem(VendingMachine machine, String itemCode);
    void dispenseItem(VendingMachine machine);
}
