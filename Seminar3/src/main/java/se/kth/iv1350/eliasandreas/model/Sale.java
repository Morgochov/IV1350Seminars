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
        for(int i = 0; i<arrayLength; i++)
        {
            if(items[i] == soldItem)
            {
                itemQuantity[i] += quantity;
                return 1;
            }

        }
        /*
         * Extends the arrays and adds the new item and quantity there of then returns running total
         */
        ItemDTO[] temp = new ItemDTO[arrayLength+1];
        int[] quanttemp = new int[arrayLength+1];
        int i;
        for(i = 0; i<arrayLength; i++)
        {
            temp[i] = items[i];
            quanttemp[i] = itemQuantity[i];

        }
        temp[i] = soldItem;
        quanttemp[i] = quantity;
        items = temp;
        itemQuantity = quanttemp;
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
            totalPrice += items[i].price() * itemQuantity[i];
        }
        return totalPrice;
    }
}
