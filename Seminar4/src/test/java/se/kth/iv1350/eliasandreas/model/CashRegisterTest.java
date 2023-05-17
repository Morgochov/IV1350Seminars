package test.java.se.kth.iv1350.eliasandreas.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.se.kth.iv1350.eliasandreas.model.CashRegister;

import java.lang.reflect.Field;

public class CashRegisterTest {

    private int registerStartAmount;
    private CashRegister testRegister;

    @BeforeEach
    public void setUpClass(){
        registerStartAmount = 2000;
        testRegister = new CashRegister(registerStartAmount);
    }

    @AfterEach
    public void tearDownClass(){
        registerStartAmount = 0;
        testRegister = null;
    }

    @Test
    void testCashRegisterUpdateAmount() {
        int testAmount = 50;
        testRegister.updateAmount(testAmount);
        
        int expResult = registerStartAmount + testAmount;
        int result = 0 ;
        try{
            Field testField = CashRegister.class.getDeclaredField("balance");
            testField.setAccessible(true);
            result = (int) testField.get(testRegister);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        assertEquals("wrong register result", expResult, result, 0);
    }

    @Test
    void testCashRegisterCalculateChange() {
        int testAmount = 50;
        int testPrice = 40;

        int expResult = testAmount - testPrice;
        int result = testRegister.calculateChange(testAmount, testPrice);
        assertEquals("Change calculated incorrectly", expResult, result, 0);
    }
}
