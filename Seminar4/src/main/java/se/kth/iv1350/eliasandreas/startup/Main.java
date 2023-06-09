package main.java.se.kth.iv1350.eliasandreas.startup;

import main.java.se.kth.iv1350.eliasandreas.controller.Controller;
import main.java.se.kth.iv1350.eliasandreas.integration.DatabaseConnector;
import main.java.se.kth.iv1350.eliasandreas.integration.Printer;
import main.java.se.kth.iv1350.eliasandreas.view.View;

/*
 * Starts the entire application, contains the main method used to start the application.
 */
public class Main{
    /*
    * The main method used to start the entire application.
    * A fake execution is run for testing purposes
    * @param args the application does not take any command line parameters.
    */
    public static void main(String[] args){
        DatabaseConnector datacon = new DatabaseConnector();
        Printer printer = new Printer();
        Controller contr = new Controller(datacon, printer);
        View view = new View(contr);
        view.runFakeExecution();
        view.runFakeExecution();
    }
}