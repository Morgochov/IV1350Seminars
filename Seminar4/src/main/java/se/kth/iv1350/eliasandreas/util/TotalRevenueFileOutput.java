package main.java.se.kth.iv1350.eliasandreas.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Outputs the total revenue to a file
 */
public class TotalRevenueFileOutput extends ObserverTemplate{
    private PrintWriter logStream;
    private static int totalRevenue;

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

    @Override
    protected void doShowTotalIncome(int total) throws Exception{
        totalRevenue += total;
        logStream.println("Total Revenue Generated:" + totalRevenue);
    }
    
    @Override
    protected void handleErrors(Exception e){
        e.printStackTrace();
    }
}
