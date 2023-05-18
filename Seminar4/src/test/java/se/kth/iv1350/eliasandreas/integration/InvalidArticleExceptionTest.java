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
    void testInvalidArticleExceptionItemExists() throws InvalidArticleException{
        contr.startSale();
        itemIdentifier = "AB";
        contr.addItem(itemIdentifier);
        try {
            contr.addItem(itemIdentifier);
        } catch (InvalidArticleException e) {
            System.out.println("AAAA");
            assertEquals("The item exists but InvalidArticleException is called anyways", 1, 1, 0);
        }
    }

    @Test
    void testInvalidArticleExceptionItemDoesNotExist() {
        contr.startSale();
        itemIdentifier = "AB";

        try {
            contr.addItem("AB");
        } catch (InvalidArticleException e) {
            assertEquals("The item exists but InvalidArticleException is called anyways", 1, 1, 0);
        }
    }
}
