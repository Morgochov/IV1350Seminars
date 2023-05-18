package main.java.se.kth.iv1350.eliasandreas.view;

import main.java.se.kth.iv1350.eliasandreas.util.TotalRevenueObserver;

/*
 * prints to <code>system.out</code>.
 */
public class TotalRevenueView implements TotalRevenueObserver {
    
    private int totalRevenue = 0;

    @Override
    public void addSaleMoney(int total) {
        totalRevenue += total;
    }

    /*
     * Prints the specified string to <code>system.out</code>.
     *
     * @param message will be printed to <code>system.out</code>.
     */
    @Override
    public void printTotal() {
        System.out.println("Total Revenue Generated:" + totalRevenue);
    }
}
