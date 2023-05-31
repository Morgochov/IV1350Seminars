package main.java.se.kth.iv1350.eliasandreas.integration;

import main.java.se.kth.iv1350.eliasandreas.model.Sale;

public class InventorySystem {
    
    private static final InventorySystem INVENTORY_SYSTEM = new InventorySystem();
    
    /**
    * @return returns the only instance of this singleton.
    */
    public static InventorySystem getInventorySystem() {
        return INVENTORY_SYSTEM;
    }

    /*
     * Searches the inventory for an item.
     * Due to not having an inventory in this assignment, we simply create a new ItemDTO instead.
     * 
     * @param itemIdentifier is the identifier which is searched for in the inventory.
     * In the case of this assignment, the itemIdentifier represents the new item we create.
     * @return returns the found ItemDTO. In the case of the assignment, returns the created ItemDTO.
     * @throws ConnectionException If Database could not be found
     * @throws InvalidArticleException if the itemIdentifier dosn't exist in the sale
     */
    public ItemDTO searchInventory(String itemIdentifier) throws InvalidArticleException, ConnectionException{
        if(itemIdentifier == "AB")
        {
            throw new InvalidArticleException();
        }
        if(itemIdentifier == "BA")
        {
            throw new ConnectionException();
        }
        return new ItemDTO(itemIdentifier, itemIdentifier, "cool description", 20, 10);
    }

    /*
     * Updates the inventory according to the sale.
     * 
     * @param currentSale is the sale that considered when updating the inventory.
     * @throws ConnectrionException If Database could not be found
     */
    public void updateInventory(Sale currentSale) throws ConnectionException{
        if(1==2)
        {
            throw new ConnectionException();
        }
    }
}
