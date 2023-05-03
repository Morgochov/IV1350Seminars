package test.java.se.kth.iv1350.eliasandreas.integration;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.se.kth.iv1350.eliasandreas.integration.DatabaseConnector;

public class DatabaseConnectorTest {

    @Test
    void testDatabaseConnectorFetchItem() {
        DatabaseConnector datacon = new DatabaseConnector();
        String itemIdentifier = "fun identifier";
        
        String expResult = itemIdentifier;
        String result = datacon.fetchItem(itemIdentifier).identifier();
        int compareIDResult = result.equals(expResult) ? 1 : 0;

        assertEquals("identifier is incorrect", 1, compareIDResult, 0);
    }
}
