package main.java.se.kth.iv1350.eliasandreas.integration;

public class ConnectionException extends RuntimeException{
    /*
     * An exception indicating connection issues.
     */
    public ConnectionException(){
        super("Could Not Find Database");
    }
}
