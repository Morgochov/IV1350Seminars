package test.java.se.kth.iv1350.eliasandreas.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.se.kth.iv1350.eliasandreas.model.Sale;
import main.java.se.kth.iv1350.eliasandreas.integration.ItemDTO;
import main.java.se.kth.iv1350.eliasandreas.model.ItemInCart;

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
        int compareIDResult = 0;

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

        testSale.recordItem(testDTO);
        String expResult = "potato";
        String result = "";
        ItemInCart[] itemsInTestSale = testSale.getItems();
        try{
            Field testFieldIdentifier = ItemDTO.class.getDeclaredField("identifier");
            testFieldIdentifier.setAccessible(true);
            result = (String) testFieldIdentifier.get(itemsInTestSale[0].getItemDTO());
        }
        catch(Exception e){
            e.printStackTrace();
        }

        int compareIDResult = result.equals(expResult) ? 1 : 0;

        assertEquals("wrong register result", 1, compareIDResult, 0);
    }

    @Test
    void testSaleRecordItemAlreadyExists(){

        testSale.recordItem(testDTO);
        testSale.recordItem(testDTO);
        int expResult = 2;
        int result = testSale.getItems()[0].getQuantity();

        try {
            ItemInCart item = testSale.getItems()[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            assertEquals("wrong register result", result, expResult, 0);
        }
    }
    
    @Test
    void testSaleGetTotal(){

        testSale.recordItem(testDTO);

        int expResult = Math.round(40*(1+10/100f));
        int result = testSale.getTotal();
        assertEquals("incorrect total", expResult, result, 0);
    }
    
    @Test
    void testSaleGetVAT(){
        testSale.recordItem(testDTO);

        int expResult = Math.round(40*(10/100f));
        float result = testSale.getVAT();
        assertEquals("incorrect VAT", expResult, result, 0);
    }
}
