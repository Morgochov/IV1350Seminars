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

import java.lang.reflect.Field;

public class ControllerTest {
    

    @Test
    void testControllerAddItem(){
        DatabaseConnector datacon = new DatabaseConnector();
        Controller contr = new Controller(datacon, null);
        String testIdentifier = "awesome identifier";

        String expResult = testIdentifier;
        String result = "";

        contr.startSale();
        ItemDTO returnedItem = contr.addItem(testIdentifier, 1);
        try{
            Field testField = ItemDTO.class.getDeclaredField("identifier");
            testField.setAccessible(true);
            result = (String) testField.get(returnedItem);

        }
        catch(Exception e){
            e.printStackTrace();
        }

        int compareIDResult = result.equals(expResult) ? 1 : 0;

        assertEquals("identifier is incorrect", 1, compareIDResult, 0);
    }
}
