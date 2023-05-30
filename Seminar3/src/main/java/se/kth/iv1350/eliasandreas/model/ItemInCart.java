package main.java.se.kth.iv1350.eliasandreas.model;

import main.java.se.kth.iv1350.eliasandreas.integration.ItemDTO;

/*
* One single sale made by one single customer and payed with one payment.
*/
public class ItemInCart {
    private ItemDTO itemDTO;
    private int quantity = 1;

    public ItemInCart(ItemDTO itemDTO){
        this.itemDTO = itemDTO;
    }

    public ItemDTO getItemDTO(){
        return this.itemDTO;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void updateQuantity(){
        this.quantity++;
    }
}
