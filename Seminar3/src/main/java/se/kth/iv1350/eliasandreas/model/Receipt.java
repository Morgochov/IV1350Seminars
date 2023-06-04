package main.java.se.kth.iv1350.eliasandreas.model;

import java.text.SimpleDateFormat;  
import java.util.Date;  

import main.java.se.kth.iv1350.eliasandreas.integration.ItemDTO;

public class Receipt {
    public String timeOfSale;
    public String[] soldItems;
    public int totalPrice;
    public float VAT;
    public String paymentAndChange;

    /*
     * Creates a new instance of a receipt.
     * 
     * @param sale is the sale that should be in the receipt.
     * @param change is the change that should be in the receipt.
     * @param amountPaid is the amount paid that should be in the receipt.
     */
    public Receipt(Sale sale, int change, int price)
    {
        Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
        timeOfSale = formatter.format(date); 
        ItemDTO[] items = sale.getItems();
        soldItems = new String[items.length];
        for(int i = 0; i<items.length; i++)
        {
            soldItems[i] = items[i].name();
            soldItems[i] += ", " + Integer.toString(sale.getQuantity(i));
            soldItems[i] += ", " + Integer.toString(items[i].price()) + "kr";
        }
        totalPrice=price;
        VAT = sale.getVAT();
        paymentAndChange = "Amount Paid: "+ Integer.toString(price + change) +"\nChange: "+ Integer.toString(change);        
    }
}
