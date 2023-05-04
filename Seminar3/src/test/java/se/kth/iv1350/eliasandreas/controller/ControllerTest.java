package test.java.se.kth.iv1350.eliasandreas.controller;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.se.kth.iv1350.eliasandreas.controller.Controller;
import main.java.se.kth.iv1350.eliasandreas.integration.DatabaseConnector;
import main.java.se.kth.iv1350.eliasandreas.integration.ItemDTO;

public class ControllerTest {
    
    private Controller testContr;
    private DatabaseConnector testDatacon;

    @BeforeEach
    public void setUpClass(){
        testDatacon = new DatabaseConnector();
        testContr = new Controller(testDatacon, null);
    }

    @AfterEach
    public void tearDownClass(){
        testContr = null;
        testDatacon = null;
    }
    
    @Test
    void testControllerAddItem() {
        String testIdentifier = "peculiar identifier";

        String expResult = testIdentifier;
        testContr.startSale();
        ItemDTO result = testContr.addItem(testIdentifier, 1);
        int compareIDResult = result.identifier().equals(expResult) ? 1 : 0;

        assertEquals("identifier is incorrect", 1, compareIDResult, 0);
    }
}
