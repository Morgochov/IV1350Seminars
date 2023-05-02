package main.java.se.kth.iv1350.eliasandreas.model;

import main.java.se.kth.iv1350.eliasandreas.integration.ItemDTO;
import main.java.se.kth.iv1350.eliasandreas.integration.DiscountDTO;


/*
* One single sale made by one single customer and payed with one payment.
*/
public class Sale {
    ItemDTO[] items;
    int[] itemqQuantity;
    DiscountDTO discounts;

    public ItemDTO checkIfExists(String itemIdentifier){
        for(int i = 0; i<items.length; i++)
        {
            if(items[i].identifier() == itemIdentifier)
            {
                return items[i];
            }
        }
        return null;
    }

    public int recordItem(ItemDTO soldItem, int quantity){
        /*
         * checks if item is already in items and if so then adds the quantity of items
         * If the item is present it returns the running total.
         */
        for(int i = 0; i<items.length; i++)
        {
            if(items[i] == soldItem)
            {
                itemqQuantity[i] += quantity;
                return 1;
            }

        }
        /*
         * Extends the arrays and adds the new item and quantity there of then returns running total
         */
        ItemDTO[] temp = new ItemDTO[items.length+1];
        int[] quanttemp = new int[items.length+1];
        int i;
        for(i = 0; i<items.length; i++)
        {
            temp[i] = items[i];
            quanttemp[i] = itemqQuantity[i];

        }
        temp[i] = soldItem;
        quanttemp[i] = quantity;
        items = temp;
        itemqQuantity = quanttemp;
        return 1;
    }
    public void applyDiscount(DiscountDTO discounts)
    {
        this.discounts = discounts;
        //Osäker kring detta 
    }

    public int getTotal(){
        return 1;
    }
}
