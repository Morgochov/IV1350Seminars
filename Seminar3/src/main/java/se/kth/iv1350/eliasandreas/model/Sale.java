package main.java.se.kth.iv1350.eliasandreas.model;

import main.java.se.kth.iv1350.eliasandreas.integration.ItemDTO;

/*
* One single sale made by one single customer and payed with one payment.
*/
public class Sale {
    int items;
    char discounts;

    public ItemDTO checkIfExists(char itemIdentifier){
        return new ItemDTO();
    }

    public int recordItem(ItemDTO soldItem, int quantity){
        return 1;
    }

    public int getTotal(){
        return 1;
    }
}
