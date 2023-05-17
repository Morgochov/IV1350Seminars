package main.java.se.kth.iv1350.eliasandreas.integration;

import main.java.se.kth.iv1350.eliasandreas.integration.InventorySystem;
import main.java.se.kth.iv1350.eliasandreas.integration.AccountingSystem;
import main.java.se.kth.iv1350.eliasandreas.integration.ItemDTO;
import main.java.se.kth.iv1350.eliasandreas.model.Sale;


public class DatabaseConnector {
    
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;

    /*
     * Creates a new instance of a Database Connector.
     */
    public DatabaseConnector(){
        inventorySystem = new InventorySystem();
        accountingSystem = new AccountingSystem();
    }

    /*
     * Fetches an item through the inventory system.
     * 
     * @return returns the DTO which is fetched from the inventory system.
     */
    public ItemDTO fetchItem(String itemIdentifier)throws InvalidArticleException,ConnectionException{
            return inventorySystem.searchInventory(itemIdentifier);
    }

    /*
     * Logs a sale into the accounting system and the inventory system.
     * 
     * @param currentSale is the sale that which is logged in the two systems.
     */
    public void logSale(Sale currentSale)throws ConnectionException{
        accountingSystem.recordSale(currentSale);
        inventorySystem.updateInventory(currentSale);
    }
}
