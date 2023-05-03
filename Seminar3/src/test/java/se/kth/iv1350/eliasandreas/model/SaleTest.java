package test.java.se.kth.iv1350.eliasandreas.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.se.kth.iv1350.eliasandreas.model.Sale;
import main.java.se.kth.iv1350.eliasandreas.integration.ItemDTO;

public class SaleTest {
    
    private Sale testSale;

    @BeforeEach
    public void setUpClass(){
        testSale = new Sale();
    }

    @AfterEach
    public void tearDownClass(){
        testSale = null;
    }

    @Test
    void testSaleCheckIfExists(){
        String testIdentifier = "cool identifier";
        
        String expResult = testIdentifier;
        String result;
        ItemDTO resultDTO = testSale.checkIfExists(testIdentifier);
        int compareIDResult;

        if(resultDTO == null){
            compareIDResult = 1;
        }  
        else{
            result = resultDTO.identifier();
            compareIDResult = result.equals(expResult) ? 1 : 0;
        }

        assertEquals("identifier is incorrect", 1, compareIDResult, 0);
    }
    
    @Test
    void testSaleRecordItem(){
        ItemDTO tempus = new ItemDTO("", "", "", 0, 0);
        
        testSale.items[] = new ItemDTO(1);
        testSale.items[0] = tempus;

        int temp = testSale.recordItem(tempus, 0);
    }
    
    @Test
    void testSaleGetTotal(){

    }
    
    @Test
    void testSaleGetVAT(){

    }
    
    @Test
    void testSaleGetItems(){

    }
    
    @Test
    void testSaleGetQuantity(){

    }
}
