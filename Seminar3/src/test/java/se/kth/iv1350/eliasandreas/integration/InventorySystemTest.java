package test.java.se.kth.iv1350.eliasandreas.integration;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.se.kth.iv1350.eliasandreas.integration.InventorySystem;
import main.java.se.kth.iv1350.eliasandreas.integration.ItemDTO;

//        return new ItemDTO(itemIdentifier, "cool description", 20, 10);

public class InventorySystemTest {
    @Test
    void testInventorySystemSearchInventory() {
        InventorySystem testInventory = new InventorySystem();
        String testIdentifier = "test";

        ItemDTO expResult = new ItemDTO(testIdentifier, testIdentifier, "cool description", 20, 10);
        ItemDTO result = testInventory.searchInventory(testIdentifier);

        int identifierResult = result.identifier().equals(expResult.identifier()) ? 1 : 0;
        int nameResult = result.name().equals(expResult.name()) ? 1 : 0;
        int descriptionResult = result.description().equals(expResult.description()) ? 1 : 0;

        assertEquals("the identifier is incorrect", 1, identifierResult, 0);
        assertEquals("the name is incorrect", 1, nameResult, 0);
        assertEquals("the description is incorrect", 1, descriptionResult, 0);
        assertEquals("the result is incorrect", expResult.price(), result.price(), 0);
        assertEquals("the tax is incorrect", expResult.tax(), result.tax(), 0);
    }
}
