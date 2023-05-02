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
    private Sale sale;
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
        ItemDTO soldItem = sale.checkIfExists("a");
        if(soldItem == null){
            soldItem = datacon.fetchItem("a");
        }
        int runningTotal = sale.recordItem(soldItem, 1);
        return soldItem;
    }

    /*
     * endSale and discountrequest bellow
     */
    public int endSale(){
        return sale.getTotal();
    }

    /*
     * Discount request with no function as it is stated in the flow 
     */
    public void discountrequest()
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

    public int pays(int amountPaid)
    {
        datacon.logSale(sale);
        cashRegister.updateAmount(amountPaid);
        Receipt currentReciept = new Receipt(sale);
        printer.printReceipt(currentReciept);
        return cashRegister.calculateChange(amountPaid, sale.getTotal());
    }
}