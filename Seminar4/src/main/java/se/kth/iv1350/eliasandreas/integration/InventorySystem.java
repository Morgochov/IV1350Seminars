package main.java.se.kth.iv1350.eliasandreas.integration;

import main.java.se.kth.iv1350.eliasandreas.model.Sale;

public class InventorySystem {
    
    /*
     * Searches the inventory for an item.
     * Due to not having an inventory in this assignment, we simply create a new ItemDTO instead.
     * 
     * @param itemIdentifier is the identifier which is searched for in the inventory.
     * In the case of this assignment, the itemIdentifier represents the new item we create.
     * @return returns the found ItemDTO. In the case of the assignment, returns the created ItemDTO.
     */
    public ItemDTO searchInventory(String itemIdentifier){
        return new ItemDTO(itemIdentifier, itemIdentifier, "cool description", 20, 10);
    }

    /*
     * Updates the inventory according to the sale.
     * 
     * @param currentSale is the sale that considered when updating the inventory.
     */
    public void updateInventory(Sale currentSale){

    }
}
