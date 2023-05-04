package main.java.se.kth.iv1350.eliasandreas.view;

import main.java.se.kth.iv1350.eliasandreas.controller.Controller;
import main.java.se.kth.iv1350.eliasandreas.integration.ItemDTO;

/*
 * This is a placeholder for the real view.
 * It contains a hardcoded execution with calls to all system operations in the controller.
 */
public class View{
    private Controller contr;

    /*
     * Creates a new instance, that uses the specified controller for all calls to other layers.
     * 
     * @param contr the controller to use for all calls to other layers
     */
    public View(Controller contr){
        this.contr = contr;
    }
    
    /*
     * Performs a fake sale.
     */
    public void runFakeExecution(){
        contr.startSale();
        ItemDTO displayAddedItem = contr.addItem("potato", 2);
        int totalPrice = contr.endSale();
        int change = contr.pays(totalPrice + 5);
        System.out.println("\n------\nReturned ItemDTO: " + displayAddedItem);
        System.out.println("Returned price: " + totalPrice);
        System.out.println("Returned change: " + change + "\n------");
    }
}