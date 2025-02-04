import Entity.VendingMachine;

public class Main {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        try {
            vm.insertCoin(20);
            vm.selectItem("A1");
            vm.dispenseItem();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Hello world!");
    }
}