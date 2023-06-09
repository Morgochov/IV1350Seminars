package test.java.se.kth.iv1350.eliasandreas.integration;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.se.kth.iv1350.eliasandreas.integration.DatabaseConnector;
import main.java.se.kth.iv1350.eliasandreas.controller.Controller;
import main.java.se.kth.iv1350.eliasandreas.integration.InvalidArticleException;
import main.java.se.kth.iv1350.eliasandreas.integration.ConnectionException;

public class InvalidArticleExceptionTest {

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
    void testExceptionItemExists() throws ConnectionException{
        contr.startSale();
        itemIdentifier = "potato";
        try {
            contr.addItem(itemIdentifier);
        } catch (InvalidArticleException e) {
            assertEquals("The item exists but InvalidArticleException is called anyways", 1, 0, 0);
        }
    }

    @Test
    void testExceptionItemDoesNotExist() throws ConnectionException{
        contr.startSale();
        itemIdentifier = "AB";
        int excepetionIsSent = 0;
        try {
            contr.addItem(itemIdentifier);
        } catch (InvalidArticleException e) {
            excepetionIsSent = 1;
        }
        assertEquals("The item does not exist, but the exception wasn't sent", 1, excepetionIsSent, 0);
    }
}
