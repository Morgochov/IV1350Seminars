package main.java.se.kth.iv1350.eliasandreas.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Outputs the total revenue to a file
 */
public class TotalRevenueFileOutput implements TotalRevenueObserver {
    private PrintWriter logStream;
    private int totalRevenue = 0;

    /*
     * Adds money from a new sale into the total revenue.
     * 
     * @param total is the sale total which will be added to the total revenue.
     */
    @Override
    public void addSaleMoney(int total) {
        totalRevenue += total;
    }
    
    /**
     * Creates an instance of the file logger
     */
    public TotalRevenueFileOutput() {
        try {
            logStream = new PrintWriter(new FileWriter("revenue.txt"), true);
        } catch (IOException ioe) {
            System.out.println("Can Not Log.");
            ioe.printStackTrace();
        }
    }

    /*
     * Prints the amount to the file.
     */
    public void printTotal() {
        logStream.println("Total Revenue Generated:" + totalRevenue);
    }
}
