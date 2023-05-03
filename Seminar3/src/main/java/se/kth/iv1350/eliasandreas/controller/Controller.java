package main.java.se.kth.iv1350.eliasandreas.controller;

import main.java.se.kth.iv1350.eliasandreas.model.Sale;
import main.java.se.kth.iv1350.eliasandreas.model.CashRegister;
import main.java.se.kth.iv1350.eliasandreas.model.Receipt;
import main.java.se.kth.iv1350.eliasandreas.integration.ItemDTO;
import main.java.se.kth.iv1350.eliasandreas.integration.DiscountDTO;
import main.java.se.kth.iv1350.eliasandreas.integration.Printer;
import main.java.se.kth.iv1350.eliasandreas.integration.DatabaseConnector;

/*
 * This is the application's only controller. All calls to the model pass through this class.
 */
public class Controller{
    public Sale sale;
    private CashRegister cashRegister;
    private DatabaseConnector datacon;
    private Printer printer;

    public Controller(DatabaseConnector datacon, Printer printer){
        this.datacon = datacon;
        this.printer = printer;
        cashRegister = new CashRegister();
    }

    /*
     * Starts a new sale.
     */
    public void startSale(){
        sale = new Sale();
    }

    public ItemDTO addItem(String itemIdentifier, int quantity){
        ItemDTO soldItem = sale.checkIfExists(itemIdentifier);
        if(soldItem == null){
            soldItem = datacon.fetchItem(itemIdentifier);
        }
        int runningTotal = sale.recordItem(soldItem, quantity);
        return soldItem;
    }

    /*
     * endSale and discountrequest below
     */
    public int endSale(){
        return sale.getTotal();
    }

    /*
     * pays logs the sale in both the accounting and the inventory system, updates the new cash amount
     * in the cash register, creates and prints a receipt and returns the amount of change
     * 
     * @param amountPaid is the amount the customer has paid
     */
    public int pays(int amountPaid)
    {
        datacon.logSale(sale);
        cashRegister.updateAmount(amountPaid);
        int change = cashRegister.calculateChange(amountPaid, sale.getTotal());
        Receipt currentReciept = new Receipt(sale, change, amountPaid);
        printer.printReceipt(currentReciept);
        return change;
    }

    /*
     * Discount request with no function as it is stated in the flow 
     */
    public void discountRequest()
    {
        /* 
         * WTF varför finns denna
         */
    }
    /*
     * getDiscount with customerID as parameter
     */
    public int getDiscount(String customerID)
    {
        DiscountDTO discount = datacon.fetchDiscount(customerID);
        sale.applyDiscount(discount);
        return sale.getTotal();
    }
}