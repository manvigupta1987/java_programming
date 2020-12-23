package DesignPatterns.InterviewQuestions;

// Vending Machine must keep track of the inventory
//A person should be able to insert cash into the machine & choose an item
//The Machine should confirm the inserted cash with the price of the selected item
//The machine must display an error in case of insufficient cash or unavailable item
//Finally, if all the above steps succeed then the user gets the selected item

// States :
//Ready — Machine ready to accept cash
//CashCollected — Machine has collected cash & user can now select the product or cancel the transaction
//DispenseChange — Give back the change to the user
//DispenseItem — Dispense the item upon successful validation of entered cash & the price of the selected item in inventory
//TransactionCancelled — If the user cancels the transaction, return the cash given by the user

//https://medium.com/swlh/vending-machine-design-a-state-design-pattern-approach-5b7e1a026cd2

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    public static void main(String[] args) {
        VendingContext vendingContext = new VendingContext();
        vendingContext.startNewTransaction("Pepsi", 15);

        vendingContext.startNewTransaction("Cilantro", 10);
        vendingContext.startNewTransaction("Peanuts", 10);
        vendingContext.startNewTransaction("Peanuts", 10);
    }
}

interface State {
    void selectItemAndCollectCash(String item, int cash, VendingContext context);
    void dispenseChange(String productCode, VendingContext context);
    void dispenseItem(String productCode, VendingContext context);
    void transactionCancelled(VendingContext context);
}

class Ready implements State {
    private static final Ready ready = new Ready();
    private Ready() {}

    public static Ready getInstance() {
        return ready;
    }

    @Override
    public void selectItemAndCollectCash(String item, int cash, VendingContext context) {
        context.setItem(item);
        context.collectCash(cash);
        System.out.println("\nItem selected: " + item + " Cash Collected: " + cash + "$");
        if (context.checkIfCashCorrect(cash, item)) {
            context.setState(DispenseChange.getInstance());
            context.dispenseChange();
        } else {
            context.setState(TransactionCancelled.getInstance());
            context.cancelTransaction();
        }
    }

    @Override
    public void dispenseChange(String productCode, VendingContext context) {
        throw new RuntimeException("Collecting cash, Not able to dispense item at this moment");
    }

    @Override
    public void dispenseItem(String productCode, VendingContext context) {
        throw new RuntimeException("Collecting cash, Not able to dispense item at this moment");
    }

    @Override
    public void transactionCancelled(VendingContext context) {
        context.setState(TransactionCancelled.getInstance());
        context.cancelTransaction();
    }
}
class DispenseChange implements State {
    private static final DispenseChange change = new DispenseChange();
    private DispenseChange() {}

    public static DispenseChange getInstance() {
        return change;
    }

    @Override
    public void selectItemAndCollectCash(String item, int cash, VendingContext context) {
        throw new RuntimeException("Dispensing change, Not able to collect Cash at this moment");
    }

    @Override
    public void dispenseChange(String productCode, VendingContext context) {
        context.calculateChange(productCode);
        context.setState(DispenseItem.getInstance());
        context.dispenseItem(productCode);
    }

    @Override
    public void dispenseItem(String productCode, VendingContext context) {
        throw new RuntimeException("Dispensing change, Not able to dispense item at this moment");
    }

    @Override
    public void transactionCancelled(VendingContext context) {
        throw new RuntimeException("Dispensing change, Transaction can't be cancelled");
    }
}
class DispenseItem implements State {
    private static final DispenseItem dispenseItem= new DispenseItem();
    private DispenseItem() {}

    public static DispenseItem getInstance() {
        return dispenseItem;
    }

    @Override
    public void selectItemAndCollectCash(String item, int cash, VendingContext context) {
        throw new RuntimeException("Dispensing change, Not able to collect Cash at this moment");
    }

    @Override
    public void dispenseChange(String productCode, VendingContext context) {
        throw new RuntimeException("Dispensing change, Not able to dispense item at this moment");
    }

    @Override
    public void dispenseItem(String productCode, VendingContext context) {
        context.removeProduct(productCode);
        System.out.println("Dispensing Item " + productCode);
        context.setCash(0);
        context.setState(Ready.getInstance());
    }

    @Override
    public void transactionCancelled(VendingContext context) {
        throw new RuntimeException("Dispensing change, Transaction can't be cancelled");
    }
}

class TransactionCancelled implements State {
    private static final TransactionCancelled transactionCancelled = new TransactionCancelled();
    private TransactionCancelled() {}

    public static TransactionCancelled getInstance() {
        return transactionCancelled;
    }

    @Override
    public void selectItemAndCollectCash(String item, int cash, VendingContext context) {
        throw new RuntimeException("Cancelling Transction, Not able to collect Cash at this moment");
    }

    @Override
    public void dispenseChange(String productCode, VendingContext context) {
        throw new RuntimeException("Cancelling Transction, Not able to dispense change");
    }

    @Override
    public void dispenseItem(String productCode, VendingContext context) {
        throw new RuntimeException("Cancelling Transction, Not able to dispense item at this moment");
    }

    @Override
    public void transactionCancelled(VendingContext context) {
        System.out.println("Cancelling the Transaction");
        context.setCash(0);
        context.setState(Ready.getInstance());
    }
}

class VendingContext {
    private State state;
    private Map<String, Integer> productCodePriceMap;
    private Map<String, Integer> productCodeQuantityMap;
    private int collectedCash;
    private String selectedItem;

    VendingContext() {
        productCodePriceMap = new HashMap<>();
        productCodePriceMap.put("Coke", 12);
        productCodePriceMap.put("Pepsi", 10);
        productCodePriceMap.put("Chips", 5);
        productCodePriceMap.put("Peanuts", 6);
        productCodePriceMap.put("MixedNuts", 10);

        productCodeQuantityMap = new HashMap<>();
        productCodeQuantityMap.put("Coke", 4);
        productCodeQuantityMap.put("Pepsi", 5);
        productCodeQuantityMap.put("Chips", 3);
        productCodeQuantityMap.put("Peanuts", 1);
        productCodeQuantityMap.put("MixedNuts", 2);
        collectedCash = 0;
        selectedItem = "";
        state = Ready.getInstance();
    }

    void startNewTransaction(String item , int cash) {
        this.state.selectItemAndCollectCash(item, cash, this);
    }

    boolean checkIfCashCorrect(int cash, String productCode) {
        if (checkIfProductAvailable(productCode)) {
            int price = productCodePriceMap.get(productCode);
            System.out.println("Price of the item :" + productCode + " is :" + price + "$");
            return (cash >= price) ? true : false;
        } else {
            System.out.println("Item " + productCode + " is out of stock");
            return false;
        }
    }

    void setItem(String product) {
        this.selectedItem = product;
    }

    public void collectCash(int cash) {
        collectedCash += cash;
    }

    public void setCash(int cash) {
        collectedCash = 0;
    }

    void calculateChange(String productCode) {
        int productPrice = productCodePriceMap.get(productCode);
        System.out.println("Dispensing Change : " + (collectedCash - productPrice) + "$");
    }

    void dispenseChange() {
        this.state.dispenseChange(selectedItem, this);
    }

    void cancelTransaction() {
        this.state.transactionCancelled(this);
    }

    void dispenseItem(String productCode) {
        this.state.dispenseItem(productCode, this);
    }

    void removeProduct(String productCode) {
        int quantity = productCodeQuantityMap.get(productCode);
        System.out.println(quantity + " " + productCode + " are in stock.");
        if (quantity == 1) {
            productCodeQuantityMap.remove(productCode);
        } else {
            productCodeQuantityMap.put(productCode, (quantity -1));
        }
    }

    boolean checkIfProductAvailable(String productCode) {
        return productCodeQuantityMap.containsKey(productCode);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}


