package main.java.se.kth.iv1350.eliasandreas.controller;

import main.java.se.kth.iv1350.eliasandreas.model.Sale;
import main.java.se.kth.iv1350.eliasandreas.model.CashRegister;
import main.java.se.kth.iv1350.eliasandreas.integration.ItemDTO;
import main.java.se.kth.iv1350.eliasandreas.integration.DatabaseConnector;

/*
 * This is the application's only controller. All calls to the model pass through this class.
 */
public class Controller{
    private Sale sale;
    private CashRegister cashRegister;

    public Controller(){
        cashRegister = new CashRegister();
    }

    /*
     * Starts a new sale.
     */
    public void startSale(){
        sale = new Sale();
    }

    public ItemDTO addItem(char itemIdentifier, int quantity){
        ItemDTO soldItem = sale.checkIfExists('a');
        if(soldItem == null){
            soldItem = new DatabaseConnector().fetchItem('a');
        }
        int runningTotal = sale.recordItem(soldItem, 1);
        return soldItem;
    }

    public void endSale(){

    }
}