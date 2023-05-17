package main.java.se.kth.iv1350.eliasandreas.integration;

public class ConnectionException extends RuntimeException{
    public ConnectionException(){
        super("Could Not Find Database");
    }
}
