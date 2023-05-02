package main.java.se.kth.iv1350.eliasandreas.integration;

import main.java.se.kth.iv1350.eliasandreas.integration.InventorySystem;
import main.java.se.kth.iv1350.eliasandreas.integration.AccountingSystem;
import main.java.se.kth.iv1350.eliasandreas.integration.ItemDTO;
import main.java.se.kth.iv1350.eliasandreas.model.Sale;


public class DatabaseConnector {
    
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;
    private DiscountSystem discountSystem;

    public DatabaseConnector(){
        inventorySystem = new InventorySystem();
        accountingSystem = new AccountingSystem();
        discountSystem = new DiscountSystem();
    }

    public ItemDTO fetchItem(String itemIdentifier){
        return inventorySystem.searchInventory("a");
    }

    public void logSale(Sale currentSale){
        accountingSystem.recordSale(currentSale);
        inventorySystem.updateInventory(currentSale);
    }
    public DiscountDTO fetchDiscount(String customerID)
    {
        return discountSystem.searchDiscount(customerID);
    }
}
