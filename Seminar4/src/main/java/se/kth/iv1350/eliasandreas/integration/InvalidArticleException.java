package main.java.se.kth.iv1350.eliasandreas.integration;

public class InvalidArticleException extends Exception{
    /*
     * An exception indicating that an invalid article has been attempted to be run through the system.
     */
    public InvalidArticleException()
    {
        super("No Such Article");
    }
}
