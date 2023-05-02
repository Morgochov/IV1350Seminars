package main.java.se.kth.iv1350.eliasandreas.model;

import java.text.SimpleDateFormat;  
import java.util.Date;  

import main.java.se.kth.iv1350.eliasandreas.integration.ItemDTO;

public class Receipt {
    String timeOfSale;
    String[] soldItems;
    int totalPrice;
    int VAT;
    String paymentAndChange;

    
    public Receipt(Sale sale, int change, int amountPaid)
    {
        Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
        timeOfSale = formatter.format(date); 
        ItemDTO[] items = sale.getItems();
        String itemDetails;
        for(int i = 0; i<items.length; i++)
        {
            itemDetails = items[i].name();
            itemDetails += " " + Integer.toString(sale.getQuantity(i));
            itemDetails += " " + Integer.toString(items[i].price());
            soldItems[i] = itemDetails;
        }
        totalPrice=sale.getTotal();
        VAT = sale.getVAT();
        paymentAndChange = "AmountPaid: "+ Integer.toString(amountPaid) +" AmountOfChange: "+ Integer.toString(change);

        
    }
}
