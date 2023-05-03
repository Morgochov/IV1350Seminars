package main.java.se.kth.iv1350.eliasandreas.integration;

import main.java.se.kth.iv1350.eliasandreas.model.Sale;

public class InventorySystem {
    
    public ItemDTO searchInventory(String itemIdentifier){
        return new ItemDTO(itemIdentifier, itemIdentifier, "cool description", 20, 10);
    }

    public void updateInventory(Sale currentSale){

    }
}
