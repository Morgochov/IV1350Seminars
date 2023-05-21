package main.java.se.kth.iv1350.eliasandreas.util;

import main.java.se.kth.iv1350.eliasandreas.util.TotalRevenueObserver;

/*
 * Specifies an object which observes a file and detects
 * new sales and shows the total revenue based on that.
 * It is an interface so it is up to the different implementations
 * to handle the actual logic.
 */
public interface TotalRevenueObserver {
    /*
     * Adds money from a new sale into the total revenue.
     * 
     * @param total is the sale total which will be added to the total revenue.
     */
    void addSaleMoney(int total);
    /*
     * Prints the total revenue.
     */
    void printTotal();
}
