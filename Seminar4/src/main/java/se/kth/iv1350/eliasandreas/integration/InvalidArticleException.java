package main.java.se.kth.iv1350.eliasandreas.integration;

public class InvalidArticleException extends Exception{
    public InvalidArticleException()
    {
        super("No Such Article");
    }
}
