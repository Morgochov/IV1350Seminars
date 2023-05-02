package main.java.se.kth.iv1350.eliasandreas.integration;

public class ItemDTO {
    
    private String identifier;
    private String description;
    private int price;
    private int tax;
    private boolean validIdentifier;

    public ItemDTO(String identifierNew, String descriptionNew, int priceNew, int taxNew){
        this.identifier = identifierNew;
        this.description = descriptionNew;
        this.price = priceNew;
        this.tax = taxNew;
        this.validIdentifier = true;
    }

    public String identifier()
    {
        return this.identifier;
    }

    public int price(){
        return this.price;
    }
}
