package main.java.se.kth.iv1350.eliasandreas.model;

import main.java.se.kth.iv1350.eliasandreas.integration.ItemDTO;

import java.util.ArrayList;
import java.util.List;

import main.java.se.kth.iv1350.eliasandreas.util.TotalRevenueObserver;

/*
* One single sale made by one single customer and payed with one payment.
*/
public class Sale {
    private int totalPrice;
    private ItemDTO[] items;
    private int[] itemQuantity;

    private List<TotalRevenueObserver> totalRevenueObservers = new ArrayList<>();
    
    /*
     * Adds an new observer to a list of observeres.
     * 
     * @param obs is the observer that is being added, can be different due to the interface.
     */
    public void addTotalRevenueObserver(TotalRevenueObserver obs) {
        totalRevenueObservers.add(obs);
    }

    private void notifyObservers(int total) {
        for (TotalRevenueObserver obs : totalRevenueObservers) {
            obs.newSaleWasMade(total);
        }
    }

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
                if(items[i].identifier() == itemIdentifier)
                {
                    return items[i];
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
        if(items != null){
            arrayLength = items.length;
        }

        for(int i = 0; i < arrayLength; i++)
        { 
            if(items[i] == soldItem)
            {
                itemQuantity[i]++;
                return updateTotal();
            }
        }

        ItemDTO[] newItemDTOArray = new ItemDTO[arrayLength+1];
        int[] newQuantityArray = new int[arrayLength+1];
        int i;
        for(i = 0; i<arrayLength; i++)
        {
            newItemDTOArray[i] = items[i];
            newQuantityArray[i] = itemQuantity[i];

        }
        newItemDTOArray[i] = soldItem;
        newQuantityArray[i] = 1;
        items = newItemDTOArray;
        itemQuantity = newQuantityArray;
        return updateTotal();
    }

    /*
     * Gets the current total price of the sale.
     * 
     * @return returns the current total price.
     */
    public int updateTotal(){
        totalPrice = 0;
        for(int i = 0; i < items.length; i++){
            totalPrice += (items[i].price() * (1 + items[i].tax()/100f)) * itemQuantity[i];
        }
        return totalPrice;
    }

    /*
     * Gets the current total price of the sale.
     * 
     * @return returns the current total price.
     */
    public int getTotal(){
        notifyObservers(totalPrice);
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
            VAT += items[i].tax()/100f * items[i].price() * itemQuantity[i];
            System.out.println();
        }
        return VAT;
    }
    
    /*
     * Getter for the items in the sale.
     * 
     * @return gives the item array.
     */
    public ItemDTO[] getItems()
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
        return this.itemQuantity[i];
    }
}
