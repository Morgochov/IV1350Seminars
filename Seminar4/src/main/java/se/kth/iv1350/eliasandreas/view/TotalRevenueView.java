package main.java.se.kth.iv1350.eliasandreas.view;

import main.java.se.kth.iv1350.eliasandreas.util.ObserverTemplate;

/*
 * prints the total revenue to <code>system.out</code>.
 */
public class TotalRevenueView extends ObserverTemplate {
    private static int totalRevenue;

    @Override
    protected void doShowTotalIncome(int total) throws Exception{
        totalRevenue += total;
        System.out.println("Total Revenue Generated:" + totalRevenue);
    }

    @Override
    protected void handleErrors(Exception e){
        e.printStackTrace();
    }
}
