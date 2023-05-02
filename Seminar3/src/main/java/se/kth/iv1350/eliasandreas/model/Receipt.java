package main.java.se.kth.iv1350.eliasandreas.model;

import java.time.LocalTime;

public class Receipt {
    
    public Receipt(Sale sale)
    {
        
    }
    public void saveCurrentTime(){
        final LocalTime saleTime = LocalTime.now();
    }
}
