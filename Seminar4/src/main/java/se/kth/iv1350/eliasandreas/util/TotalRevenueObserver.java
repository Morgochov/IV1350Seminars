package main.java.se.kth.iv1350.eliasandreas.util;

import main.java.se.kth.iv1350.eliasandreas.util.TotalRevenueObserver;

/*
 * Specifies an object that can print to a log. This interface
 * does not handle log locations, it is up to the implementing
 * class to decide where the log is.
 */
public interface TotalRevenueObserver {
    /*
     * @param Message will be printed to log.
     */
    void printTotal();
    void addSaleMoney(int total);
}
