package main.java.se.kth.iv1350.eliasandreas.view;

import main.java.se.kth.iv1350.eliasandreas.controller.Controller;
import main.java.se.kth.iv1350.eliasandreas.integration.ItemDTO;
import main.java.se.kth.iv1350.eliasandreas.integration.InvalidArticleException;
import main.java.se.kth.iv1350.eliasandreas.integration.ConnectionException;

import main.java.se.kth.iv1350.eliasandreas.util.ConsoleLogger;
import main.java.se.kth.iv1350.eliasandreas.util.FileLogger;
import main.java.se.kth.iv1350.eliasandreas.util.Logger;
/*
 * This is a placeholder for the real view.
 * It contains a hardcoded execution with calls to all system operations in the controller.
 * Client for Logger. Prints messages to logger.
 */
public class View{
    private Controller contr;
    private Logger logger;

    public void setLogger(Logger logger)
    {
        this.logger = logger;
    }

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
    public void runFakeExecution()throws InvalidArticleException, ConnectionException{
        contr.startSale();
        ItemDTO displayAddedItem = null;
        try{
            displayAddedItem = contr.addItem("BA");
        }
        catch(InvalidArticleException e)
        {
            setLogger(new FileLogger());
            logger.log(e.getMessage());
            setLogger(new ConsoleLogger());
            logger.log(e.getMessage());
        }
        catch(ConnectionException e)
        {
            setLogger(new ConsoleLogger());
            logger.log(e.getMessage());
            setLogger(new FileLogger());
            logger.log(e.getMessage());
        }
        int totalPrice = contr.endSale();
        try{
            int change = contr.pays(totalPrice + 5);
            System.out.println("\n------\nReturned ItemDTO: " + displayAddedItem);
            System.out.println("Returned price: " + totalPrice);
            System.out.println("Returned change: " + change + "\n------");
        }
        catch(ConnectionException e)
        {
            setLogger(new FileLogger());
            logger.log(e.getMessage());
            setLogger(new ConsoleLogger());
            logger.log(e.getMessage());
        }
    }
}