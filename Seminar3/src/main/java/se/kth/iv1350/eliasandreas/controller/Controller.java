package main.java.se.kth.iv1350.eliasandreas.controller;

import main.java.se.kth.iv1350.eliasandreas.model.Sale;
import main.java.se.kth.iv1350.eliasandreas.model.CashRegister;
import main.java.se.kth.iv1350.eliasandreas.model.Receipt;
import main.java.se.kth.iv1350.eliasandreas.integration.ItemDTO;
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

    /*
     * Creates a new instance representing the controller.
     * 
     * @param datacon is the DatabaseConnector for accessing external systems.
     * @param printer is the printer for which this controller prints through.
     */
    public Controller(DatabaseConnector datacon, Printer printer){
        this.datacon = datacon;
        this.printer = printer;
        cashRegister = new CashRegister(2000);
    }

    /*
     * Starts a new sale.
     */
    public void startSale(){
        sale = new Sale();
    }

    /*
     * Adds an item to the ongoing sale.
     * 
     * @param itemIdentifier is the identifier of the added item
     * @param quantity is the amount of the item that is added
     * @return returns the added item for displaying in the theoretical view
     */
    public ItemDTO addItem(String itemIdentifier){
        ItemDTO soldItem = sale.checkIfExists(itemIdentifier);
        if(soldItem == null){
            soldItem = datacon.fetchItem(itemIdentifier);
        }
        int runningTotal = sale.recordItem(soldItem);
        return soldItem;
    }

    /*
     * endSale ends the current sale
     * 
     * @return returns the total price of the sale
     */
    public int endSale(){
        return sale.getTotal();
    }

    /*
     * pays logs the sale in both the accounting and the inventory system, updates the new cash amount
     * in the cash register, creates and prints a receipt and returns the amount of change
     * 
     * @param amountPaid is the amount the customer has paid
     * @return returns the amount of change
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
}