package main.java.se.kth.iv1350.eliasandreas.model;

import main.java.se.kth.iv1350.eliasandreas.integration.ItemDTO;
import main.java.se.kth.iv1350.eliasandreas.integration.DiscountDTO;


/*
* One single sale made by one single customer and payed with one payment.
*/
public class Sale {
    private ItemDTO[] items;
    private int[] itemQuantity;
    private DiscountDTO discounts;

    public ItemDTO checkIfExists(String itemIdentifier){
        if(items != null){
            for(int i = 0; i<items.length; i++)
            {
                if(items[i].identifier() == itemIdentifier)
                {
                    return items[i];
                }
            }
        }
        return null;
    }

    public int recordItem(ItemDTO soldItem, int quantity){
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
            if(items[i] == soldItem)
            {
                itemQuantity[i] += quantity;
                return getTotal();
            }

        }
        /*
         * Extends the arrays and adds the new item and quantity there of then returns running total
         */
        ItemDTO[] newItemDTOArray = new ItemDTO[arrayLength+1];
        int[] newQuantityArray = new int[arrayLength+1];
        int i;
        for(i = 0; i<arrayLength; i++)
        {
            newItemDTOArray[i] = items[i];
            newQuantityArray[i] = itemQuantity[i];

        }
        newItemDTOArray[i] = soldItem;
        newQuantityArray[i] = quantity;
        items = newItemDTOArray;
        itemQuantity = newQuantityArray;
        return getTotal();
    }
    
    public void applyDiscount(DiscountDTO discounts)
    {
        this.discounts = discounts;
        //Osäker kring detta 
    }

    public int getTotal(){
        int totalPrice = 0;
        for(int i = 0; i < items.length; i++){
            totalPrice += (items[i].price() + items[i].tax()) * itemQuantity[i];
        }
        return totalPrice;
    }
    
    public int getVAT()
    {
        int VAT = 0;
        for(int i = 0; i < items.length; i++){
            VAT += items[i].tax()/10 * items[i].price() * itemQuantity[i];
        }
        return VAT;
    }
    
    public ItemDTO[] getItems()
    {
        return items;
    }
    
    public int getQuantity(int i)
    {
        return this.itemQuantity[i];
    }
}
