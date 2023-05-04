package main.java.se.kth.iv1350.eliasandreas.model;

public class CashRegister {
    private int balance;

    /*
     * Creates an instance of a cash register.
     * 
     * @param cashAmount is the amount that is inside of the register to begin with.
     */
    public CashRegister(int cashAmount){
        balance = cashAmount;
    }

    /*
     * Updates the amount in the cash register.
     * 
     * @param amountPaid is the amount that a customer has paid, and is the amount that the register is updated by.
     */
    public void updateAmount(int amountPaid){
        balance += amountPaid;
    }

    /*
     * Calculates the change and updates the register accordingly.
     * 
     * @param amountPaid is the amount that is paid by the customer.
     * @param totalPrice is the total price of the sale.
     * @return returns the change.
     */
    public int calculateChange(int amountPaid, int totalPrice){
        int change = amountPaid - totalPrice;
        balance -= change;
        return change;
    }
}
