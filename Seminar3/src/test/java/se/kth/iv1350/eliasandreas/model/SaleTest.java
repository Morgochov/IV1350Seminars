package test.java.se.kth.iv1350.eliasandreas.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.se.kth.iv1350.eliasandreas.model.Sale;
import main.java.se.kth.iv1350.eliasandreas.integration.ItemDTO;

import java.lang.reflect.Field;

public class SaleTest {
    
    private Sale testSale;
    private ItemDTO testDTO;

    @BeforeEach
    public void setUpClass(){
        testSale = new Sale();
        testDTO = new ItemDTO("potato", "potato", "", 40, 10);
    }

    @AfterEach
    public void tearDownClass(){
        testSale = null;
        testDTO = null;
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
        String testIdentifier = "a";
        ItemDTO testItemDTO = new ItemDTO(testIdentifier, "a", "", 10, 10);
        testSale.recordItem(testItemDTO, 1);

        String expResult = testIdentifier;
        String result = "";
        ItemDTO[] itemInTestSale;
        try{
            Field testFieldItems = Sale.class.getDeclaredField("items");
            testFieldItems.setAccessible(true);
            itemInTestSale = (ItemDTO[]) testFieldItems.get(testSale);

            Field testFieldIdentifier = ItemDTO.class.getDeclaredField("identifier");
            testFieldIdentifier.setAccessible(true);
            result = (String) testFieldIdentifier.get(itemInTestSale[0]);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        int compareIDResult;

        compareIDResult = result.equals(expResult) ? 1 : 0;

        assertEquals("wrong register result", 1, compareIDResult, 0);
    }
    
    @Test
    void testSaleGetTotal(){

        testSale.recordItem(testDTO, 3);

        int expResult = (Math.round(40*(1+10/100f)))*3;
        int result = testSale.getTotal();
        assertEquals("incorrect total", expResult, result, 0);
    }
    
    @Test
    void testSaleGetVAT(){
        testSale.recordItem(testDTO, 3);

        int expResult = (Math.round(40*(10/100f)))*3;
        float result = testSale.getVAT();
        assertEquals("incorrect VAT", expResult, result, 0);
    }
}
