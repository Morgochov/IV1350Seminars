package main.java.se.kth.iv1350.eliasandreas.integration;

import main.java.se.kth.iv1350.eliasandreas.model.Receipt;

public class Printer {
    
    /*
     * Prints the receipt, in terms of this assignment writes out the receipt in System.out.
     * 
     * @param receipt is the receipt that which is being printed.
     */
    public void printReceipt(Receipt receipt){
        System.out.println();
        System.out.println("Receipt:");
        System.out.println("Date and time: " + receipt.timeOfSale);
        System.out.println("--- Goods");
        for(int i = 1; i < receipt.soldItems.length + 1; i++){
            System.out.println("Item " + i + ": " + receipt.soldItems[(i - 1)]);
        }
        System.out.println("--- Payment");
        System.out.println("Total price: " + receipt.totalPrice);
        System.out.println("VAT: " + receipt.VAT);
        System.out.println(receipt.paymentAndChange);
    }
}
