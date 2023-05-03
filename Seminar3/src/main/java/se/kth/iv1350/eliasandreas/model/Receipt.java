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

    
    public Receipt(Sale sale, int change, int amountPaid)
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
        totalPrice=sale.getTotal();
        VAT = sale.getVAT();
        paymentAndChange = "Amount Paid: "+ Integer.toString(amountPaid) +"\nChange: "+ Integer.toString(change);        
    }
}
