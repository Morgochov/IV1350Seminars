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
import main.java.se.kth.iv1350.eliasandreas.integration.Printer;

import java.lang.reflect.Field;

public class ControllerTest {
    private DatabaseConnector datacon;
    private Controller contr;
    private String testIdentifier;
    private String result;

    @BeforeEach
    public void setUpClass(){
        datacon = new DatabaseConnector();
        contr = new Controller(datacon, new Printer());
        contr.startSale();
        testIdentifier = "awesome identifier";
    }

    @AfterEach
    public void tearDownClass(){
        datacon = null;
        contr = null;
        testIdentifier = null;
        result = null;
    }

    @Test
    void testControllerAddItem(){
        ItemDTO returnedItem = contr.addItem(testIdentifier);
        try{
            Field testField = ItemDTO.class.getDeclaredField("identifier");
            testField.setAccessible(true);
            result = (String) testField.get(returnedItem);

        }
        catch(Exception e){
            e.printStackTrace();
        }

        int compareIDResult = result.equals(testIdentifier) ? 1 : 0;

        assertEquals("identifier is incorrect", 1, compareIDResult, 0);
    }

    @Test
    void testControllerAddItemAlreadyExists(){
        contr.addItem(testIdentifier);
        ItemDTO returnedItem = contr.addItem(testIdentifier);
        try{
            Field testField = ItemDTO.class.getDeclaredField("identifier");
            testField.setAccessible(true);
            result = (String) testField.get(returnedItem);

        }
        catch(Exception e){
            e.printStackTrace();
        }

        int compareIDResult = result.equals(testIdentifier) ? 1 : 0;

        assertEquals("identifier is incorrect", 1, compareIDResult, 0);
    }

    @Test
    void testControllerEndSale(){
        contr.addItem(testIdentifier);
        int expResult = 22;
        int result = contr.endSale();
        assertEquals("the sale didn't end correctly", result, expResult, 0);
    }

    @Test
    void testControllerPays(){
        contr.addItem(testIdentifier);
        int expResult = 5;
        int totalPrice = contr.endSale();
        int result = contr.pays(totalPrice + 5);
        assertEquals("the change was incorrectly calculated", result, expResult, 0);
    }
}
