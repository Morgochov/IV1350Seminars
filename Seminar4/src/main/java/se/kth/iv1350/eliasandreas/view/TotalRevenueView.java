package main.java.se.kth.iv1350.eliasandreas.view;

import main.java.se.kth.iv1350.eliasandreas.util.TotalRevenueObserver;

/*
 * prints the total revenue to <code>system.out</code>.
 */
public class TotalRevenueView implements TotalRevenueObserver {
    
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

    /*
     * Prints the total revenue to <code>system.out</code>.
     */
    @Override
    public void printTotal() {
        System.out.println("Total Revenue Generated:" + totalRevenue);
    }
}
