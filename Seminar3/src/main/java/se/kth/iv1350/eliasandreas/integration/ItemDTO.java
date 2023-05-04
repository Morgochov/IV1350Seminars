package main.java.se.kth.iv1350.eliasandreas.integration;

public class ItemDTO {
    
    private String identifier;
    private String name;
    private String description;
    private int price;
    private int tax;
    private boolean validIdentifier;

    /*
     * Creates a new instance of an ItemDTO.
     * 
     * @param identifierNew is the identifier of the new ItemDTO.
     * @param nameNew is the name of the new ItemDTO.
     * @param descriptionNew is the description of the new ItemDTO.
     * @param priceNew is the price of the new ItemDTO.
     * @param taxNew is the tax of the new ItemDTO.
     */
    public ItemDTO(String identifierNew, String nameNew, String descriptionNew, int priceNew, int taxNew){
        this.identifier = identifierNew;
        this.name = nameNew;
        this.description = descriptionNew;
        this.price = priceNew;
        this.tax = taxNew;
        this.validIdentifier = true;
    }

    /*
     * Getter for the ItemDTO's identifier.
     * 
     * @return returns the identifier.
     */
    public String identifier()
    {
        return this.identifier;
    }

    /*
     * Getter for the ItemDTO's name.
     * 
     * @return returns the name.
     */
    public String name()
    {
        return this.name;
    }

    /*
     * Getter for the ItemDTO's description.
     * 
     * @return returns the description.
     */
    public String description()
    {
        return this.description;
    }

    /*
     * Getter for the ItemDTO's price.
     * 
     * @return returns the price.
     */
    public int price(){
        return this.price;
    }

    /*
     * Getter for the ItemDTO's tax.
     * 
     * @return returns the tax.
     */
    public int tax()
    {
        return this.tax;
    }
}
