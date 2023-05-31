package main.java.se.kth.iv1350.eliasandreas.model;

import main.java.se.kth.iv1350.eliasandreas.integration.ItemDTO;

/*
* One single sale made by one single customer and payed with one payment.
*/
public class Sale {
    private ItemInCart[] items;

    /*
     * Checks if an item exists in the sale.
     * 
     * @param itemIdentifier is the identifier of the item that is checked.
     * @return returns the item if it exists or null if it doesn't.
     */
    public ItemDTO checkIfExists(String itemIdentifier){
        if(items != null){
            for(int i = 0; i<items.length; i++)
            {
                ItemDTO DTOOfCartItem = items[i].getItemDTO();
                if(DTOOfCartItem.identifier() == itemIdentifier)
                {
                    return DTOOfCartItem;
                }
            }
        }
        return null;
    }

    /*
     * Records an item in the sale.
     * 
     * @param soldItem is the item that is added to the sale.
     * @param quantity is the quantity of the item which is added.
     * @return is the new price total after adding the item.
     */
    public int recordItem(ItemDTO soldItem){
        int arrayLength = 0;
        /*
         * determine array length for future use
         */
        if(items != null){
            arrayLength = items.length;
        }
        /*
         * checks if item is already in items and if so then adds the quantity of items
         * If the item is present it returns the running total.
         */
        for(int i = 0; i < arrayLength; i++)
        { 
            if(items[i].getItemDTO() == soldItem)
            {
                items[i].updateQuantity();
                return getTotal();
            }
        }
        /*
         * Extends the arrays and adds the new item and quantity there of then returns running total
         */
        ItemInCart[] newItemsArray = new ItemInCart[arrayLength+1];
        int i;
        for(i = 0; i<arrayLength; i++)
        {
            newItemsArray[i] = items[i];
        }
        newItemsArray[i] = new ItemInCart(soldItem);
        items = newItemsArray;
        return getTotal();
    }

    /*
     * Gets the current total price of the sale.
     * 
     * @return returns the current total price.
     */
    public int getTotal(){
        int totalPrice = 0;
        for(int i = 0; i < items.length; i++){
            ItemDTO DTOOfCartItem = items[i].getItemDTO();
            totalPrice += (DTOOfCartItem.price() * (1 + DTOOfCartItem.tax()/100f)) * items[i].getQuantity();
        }
        return totalPrice;
    }
    
    /*
     * Gets the current total VAT of the sale.
     * 
     * @return returns the current total VAT.
     */
    public float getVAT()
    {
        float VAT = 0;
        for(int i = 0; i < items.length; i++){
            ItemDTO DTOOfCartItem = items[i].getItemDTO();
            VAT += DTOOfCartItem.tax()/100f * DTOOfCartItem.price() * items[i].getQuantity();
            System.out.println();
        }
        return VAT;
    }
    
    /*
     * Getter for the items in the sale.
     * 
     * @return gives the item array.
     */
    public ItemInCart[] getItems()
    {
        return items;
    }
    
    /*
     * Getter for the quantity of a certain item.
     * 
     * @param i is the place in the array where the item we need to get the quantity of exists.
     * @return returns the quantity of the checked item.
     */
    public int getQuantity(int i)
    {
        return items[i].getQuantity();
    }
}
