package main.java.se.kth.iv1350.eliasandreas.util;


/*
 * Serves as a template to the classes
 * TotalRevenueView and TotalRevenueFileOutput.
 */
public abstract class ObserverTemplate implements TotalRevenueObserver{
    /*
     * Adds money from a new sale into the total revenue.
     * 
     * @param total is the sale total which will be added to the total revenue.
     */
    @Override
    public void newSaleWasMade(int priceOfTheSaleThatWasJustMade) {
        showTotalIncome(priceOfTheSaleThatWasJustMade);
    }

    private void showTotalIncome(int total){
        try{
            doShowTotalIncome(total);
        } catch (Exception e){
            handleErrors(e);
        }
    }
        
    protected abstract void doShowTotalIncome(int total) throws Exception;

    protected abstract void handleErrors(Exception e);
}
