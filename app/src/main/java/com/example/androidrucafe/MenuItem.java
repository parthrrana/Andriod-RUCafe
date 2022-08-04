package com.example.androidrucafe;

/**
 * MenuItem class is the parent class to the
 * menu items in the RUCafe.
 *
 * @author Parth Rana, Sahil Patel
 */
public class MenuItem {

    /**
     * Price of the menu item
     */
    protected double price;

    /**
     * Constructor to create a MenuItem object
     */
    public MenuItem(){
        this.price = 0;

    }

    /**
     * Method to calculate price of MenuItem
     *
     * @return the price of MenuItem
     */
    public double itemPrice() {
        return this.price;
    }

}
