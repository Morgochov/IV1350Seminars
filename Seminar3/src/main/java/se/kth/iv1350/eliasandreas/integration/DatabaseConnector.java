package main.java.se.kth.iv1350.eliasandreas.integration;

import main.java.se.kth.iv1350.eliasandreas.integration.InventorySystem;
import main.java.se.kth.iv1350.eliasandreas.integration.AccountingSystem;
import main.java.se.kth.iv1350.eliasandreas.integration.ItemDTO;
import main.java.se.kth.iv1350.eliasandreas.model.Sale;


public class DatabaseConnector {
    
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;

    public DatabaseConnector(){
        inventorySystem = new InventorySystem();
        accountingSystem = new AccountingSystem();
    }

    public ItemDTO fetchItem(String itemIdentifier){
        return inventorySystem.searchInventory("a");
    }

    public void logSale(Sale currentSale){
        accountingSystem.recordSale(currentSale);
        inventorySystem.updateInventory(currentSale);
    }
}
