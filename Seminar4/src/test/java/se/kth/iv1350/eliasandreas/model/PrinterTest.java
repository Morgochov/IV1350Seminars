package test.java.se.kth.iv1350.eliasandreas.integration;

import main.java.se.kth.iv1350.eliasandreas.model.Sale;
import main.java.se.kth.iv1350.eliasandreas.model.Receipt;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PrinterTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;
    
    @BeforeEach
    public void setUpStreams() {
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }
    
    @AfterEach
        public void cleanUpStreams() {
        outContent = null;
        System.setOut(originalSysOut);
    }
    
    @Test
    void testPrinterReceipt(){
        int amountPaid = 22;
        int change = 5;
        Sale sale = new Sale();
        Receipt receipt = new Receipt(sale, change, amountPaid);

        String expResult = "";
        String result = outContent.toString();
        assertTrue("Wrong printout.", result.contains(expResult));
        assertTrue("Wrong price", result.contains(Integer.toString(amountPaid)));
        assertTrue("Wrong change", result.contains(Integer.toString(change)));
    }
}
