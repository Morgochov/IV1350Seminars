package main.java.se.kth.iv1350.eliasandreas.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Logs to a file
 */
public class TotalRevenueFileOutput implements TotalRevenueObserver {
    //    private static final FileLogger FILE_LOGGER = new FileLogger();
    //    private static final String NAME_OF_LOG_FILE = "sale_log.txt";
    private PrintWriter logStream;
    private int totalRevenue = 0;

    @Override
    public void addSaleMoney(int total) {
        totalRevenue += total;
    }
    
    /**
     * Creates an instance of the FileLogger
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
     * Prints the specified string to the file.
     *
     * @param The message that will be printed.
     */
    public void printTotal() {
        logStream.println("Total Revenue Generated:" + totalRevenue);
    }
}
