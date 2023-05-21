package test.java.se.kth.iv1350.eliasandreas.integration;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.se.kth.iv1350.eliasandreas.integration.ConnectionException;
import main.java.se.kth.iv1350.eliasandreas.integration.DatabaseConnector;
import main.java.se.kth.iv1350.eliasandreas.integration.InvalidArticleException;
import main.java.se.kth.iv1350.eliasandreas.controller.Controller;
import main.java.se.kth.iv1350.eliasandreas.integration.ConnectionException;

public class ConnectionExceptionTest {

    private DatabaseConnector datacon;
    private Controller contr;
    private String itemIdentifier;

    @BeforeEach
    public void setUpClass(){
        datacon = new DatabaseConnector();
        contr = new Controller(datacon, null);
    }

    @AfterEach
    public void tearDownClass(){
        datacon = null;
        contr = null;
        itemIdentifier = null;
    }

    @Test
    void testExceptionConnectionWorks() throws InvalidArticleException{
        contr.startSale();
        itemIdentifier = "potato";
        try {
            contr.addItem(itemIdentifier);
        } catch (ConnectionException e) {
            assertEquals("The connection works but ConnectionException is called anyways", 1, 0, 0);
        }
    }

    @Test
    void testExceptionConnectionDoesntWork() throws InvalidArticleException{
        contr.startSale();
        itemIdentifier = "BA";
        int excepetionIsSent = 0;
        try {
            contr.addItem(itemIdentifier);
        } catch (ConnectionException e) {
            excepetionIsSent = 1;
        }
        assertEquals("The connection does not work, but the exception wasn't sent", 1, excepetionIsSent, 0);
    }
}
