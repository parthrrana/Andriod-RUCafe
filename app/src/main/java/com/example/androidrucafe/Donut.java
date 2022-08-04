package com.example.androidrucafe;

/**
 * Donut class extends MenuItem. The class represents
 * Donut menu item.
 *
 * @author Parth Rana, Sahil Patel
 */
public class Donut extends MenuItem{
    /**
     * Static final variable for the YEAST_DONUT_PRICE
     */
    public static final double YEAST_DONUT_PRICE = 1.59;

    /**
     * Static final variable for the CAKE_DONUT_PRICE
     */
    public static final double CAKE_DONUT_PRICE = 1.79;

    /**
     * Static final variable for the DONUT_HOLES_PRICE
     */
    public static final double DONUT_HOLES_PRICE = 0.39;

    private String donut_type;
    private String donut_flavor;
    private int quantity;
    private int image;
    private String unitPrice;

    /**
     * Constructor to create a Donut object
     *
     * @param donut_flavor the flavor of the donut
     * @param image the image of the donut
     * @param unitPrice the price of donut
     */
    public Donut(String donut_flavor, int image, String unitPrice){
        this.donut_flavor = donut_flavor;
        this.image = image;
        this.unitPrice = unitPrice;
    }

    /**
     * Constructor to create a Donut object
     *
     * @param donut_type the type of donut
     * @param donut_flavor the flavor of the donut
     * @param quantity the quantity of the donut
     */
    public Donut(String donut_type, String donut_flavor, int quantity){
        super();
        this.donut_type = donut_type;
        this.donut_flavor = donut_flavor;
        this.quantity = quantity;
    }

    /**
     * Method to calculate price of donut
     *
     * @return the price of the donut
     */
    @Override
    public double itemPrice() {
        switch (donut_type){
            case "Yeast Donuts":
                price += YEAST_DONUT_PRICE * quantity;
                break;
            case "Cake Donuts":
                price += CAKE_DONUT_PRICE * quantity;
                break;
            default:
                price += DONUT_HOLES_PRICE * quantity;
                break;
        }
        return price;
    }

    /**
     * Method to return donut information in given format
     *
     * @return string in given format
     */
    @Override
    public String toString() {
        return donut_flavor + "(" + quantity + ")";
    }

    /**
     * Getter method to return the donut flavor
     *
     * @return the flavor of the donut
     */
    public String getDonutFlavor() {
        return donut_flavor;
    }

    /**
     * Getter method to return the donut image
     *
     * @return the image of the donut
     */
    public int getImage() {
        return image;
    }

    /**
     * Getter method to return the unit price of the donut
     *
     * @return the unit price of the donut
     */
    public String getUnitPrice(){
        return unitPrice;
    }

}