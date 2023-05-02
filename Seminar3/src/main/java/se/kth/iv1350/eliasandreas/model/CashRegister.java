package main.java.se.kth.iv1350.eliasandreas.model;

public class CashRegister {
    private int balance = 2000;

    public void updateAmount(int amountPaid){
        balance += amountPaid;
    }

    public int calculateChange(int amountPaid, int totalPrice){
        return amountPaid - totalPrice;
    }
}
